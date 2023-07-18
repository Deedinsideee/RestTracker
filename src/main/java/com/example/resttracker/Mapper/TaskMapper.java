package com.example.resttracker.Mapper;

import com.example.resttracker.DTO.TaskDTO;
import com.example.resttracker.Model.Task;
import com.example.resttracker.Repository.BoardRepository;
import com.example.resttracker.Repository.TaskRepository;
import com.example.resttracker.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
@Component
public class TaskMapper extends GenericMapper<Task, TaskDTO> {
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    public TaskMapper(ModelMapper modelMapper, TaskRepository taskRepository, UserRepository userRepository, BoardRepository boardRepository) {
        super(Task.class,TaskDTO.class,modelMapper);
        this.userRepository = userRepository;

        this.boardRepository = boardRepository;
    }



    @Override
    protected void setupMapper() {

        modelMapper.createTypeMap(Task.class,TaskDTO.class)
                .addMappings(m->m.skip(TaskDTO::setAssignee)).setPostConverter(toDTOConverter())
                .addMappings(m->m.skip(TaskDTO::setBoard)).setPostConverter(toDTOConverter());

        modelMapper.createTypeMap(TaskDTO.class,Task.class)
                .addMappings(m->m.skip(Task::setAssignee)).setPostConverter(toEntityConverter())
                .addMappings(m->m.skip(Task::setBoard)).setPostConverter(toEntityConverter());


    }

    @Override
    protected void mapSpecificFields(TaskDTO source, Task destination) {
        if(!Objects.isNull(source.getAssignee()))
        {
            destination.setAssignee(userRepository.getById(source.getAssignee()));
        }
        else
        {
            destination.setAssignee(null);
        }

        if(!Objects.isNull(source.getBoard()))
        {
            destination.setBoard(boardRepository.getById(source.getBoard()));
        }
        else
        {
            destination.setBoard(null);
        }

    }

    @Override
    protected void mapSpecificFields(Task source, TaskDTO destination) {

        destination.setBoard(source.getBoard().getId());
        if (source.getAssignee() == null)
        {
            destination.setAssignee(null);
        }
        else {
            destination.setAssignee(source.getAssignee().getId());
        }


    }



    @Override
    protected List<Long> getIds(Task entity) {
        return null;
    }
}
