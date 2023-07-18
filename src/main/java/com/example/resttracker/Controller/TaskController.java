package com.example.resttracker.Controller;

import com.example.resttracker.DTO.TaskDTO;
import com.example.resttracker.Model.Task;
import com.example.resttracker.Service.GenericService;
import com.example.resttracker.Service.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/tasks")
@Tag(name="Задачи",description = "Контроллеры для работы с задачами")
public class TaskController extends GenericController<Task, TaskDTO>{


    public TaskController(TaskService taskService) {
        super(taskService);
    }





}
