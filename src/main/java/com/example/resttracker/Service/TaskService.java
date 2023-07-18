package com.example.resttracker.Service;

import com.example.resttracker.DTO.TaskDTO;
import com.example.resttracker.Mapper.TaskMapper;
import com.example.resttracker.Model.Task;
import com.example.resttracker.Model.TaskStatus;
import com.example.resttracker.Repository.TaskRepository;
import com.example.resttracker.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TaskService  extends GenericService<Task, TaskDTO>{

    private final TaskRepository taskRepository;
    protected final UserRepository userRepository;
    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper, UserRepository userRepository) {
        super(taskRepository, taskMapper);
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public TaskDTO takeTask(Long taskId,Long userId) {

        TaskDTO taskDTO =mapper.toDTO (taskRepository.getById(taskId));
        if(taskDTO.getStatus()==TaskStatus.CLOSED || taskDTO.getStatus()==TaskStatus.INWORK )
        {
            return null;
        }
        else {
            taskDTO.setAssignee(userId);
            taskDTO.setStatus(TaskStatus.INWORK);
            taskRepository.save(mapper.toEntity(taskDTO));
            return taskDTO;
        }




    }

    public TaskDTO closeTask(Long taskId) {

        TaskDTO taskDTO =mapper.toDTO (taskRepository.getById(taskId));
        taskDTO.setStatus(TaskStatus.CLOSED);
        taskRepository.save(mapper.toEntity(taskDTO));
        log.info(taskDTO.getStatus().getGenreTextDisplay());
        return taskDTO;

    }

}
