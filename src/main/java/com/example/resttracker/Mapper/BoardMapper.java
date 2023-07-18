package com.example.resttracker.Mapper;
import com.example.resttracker.DTO.BoardDTO;
import com.example.resttracker.Model.Board;
import com.example.resttracker.Model.GenericModel;
import com.example.resttracker.Repository.TaskRepository;
import com.example.resttracker.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Component
public class BoardMapper extends GenericMapper<Board, BoardDTO>{

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public BoardMapper(ModelMapper modelMapper, UserRepository userRepository, TaskRepository taskRepository) {
        super(Board.class, BoardDTO.class, modelMapper);
        this.userRepository = userRepository;


        this.taskRepository = taskRepository;
    }






    @Override
    protected void setupMapper() {
        modelMapper.createTypeMap(Board.class,BoardDTO.class)
                .addMappings(m->m.skip(BoardDTO::setOwner)).setPostConverter(toDTOConverter())
                .addMappings(m->m.skip(BoardDTO::setTasks)).setPostConverter(toDTOConverter());

        modelMapper.createTypeMap(BoardDTO.class,Board.class)
                .addMappings(m->m.skip(Board::setOwner)).setPostConverter(toEntityConverter())
                .addMappings(m->m.skip(Board::setTasks)).setPostConverter(toEntityConverter());
    }



    @Override
    protected void mapSpecificFields(BoardDTO source, Board destination) {
        if(!Objects.isNull(source.getTasks()))
        {
            destination.setTasks(taskRepository.findAllById(source.getTasks()));
        }
        else
        {
            destination.setTasks(Collections.emptyList());
        }
        if(!Objects.isNull(source.getOwner()))
        {
            destination.setOwner(userRepository.getById(source.getOwner()));
        }
        else
        {
            destination.setOwner(null);
        }
    }

    @Override
    protected void mapSpecificFields(Board source, BoardDTO destination) {
        destination.setOwner(source.getOwner().getId());
        destination.setTasks(getIds(source));
    }



    @Override
    protected List<Long> getIds(Board source) {
        return Objects.isNull(source) || Objects.isNull(source.getTasks())
                ? Collections.emptyList()
                : source.getTasks()
                .stream().map(GenericModel::getId)
                .collect(Collectors.toList());
    }
}
