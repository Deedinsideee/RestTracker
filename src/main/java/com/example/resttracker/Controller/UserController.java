package com.example.resttracker.Controller;

import com.example.resttracker.DTO.TaskDTO;
import com.example.resttracker.DTO.UserDTO;
import com.example.resttracker.Model.User;
import com.example.resttracker.Service.TaskService;
import com.example.resttracker.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
@Tag(name="Пользователи",description = "Контроллеры для работы с пользователями")
public class UserController  extends GenericController<User, UserDTO>{

    private final TaskService taskService;


    protected UserController(UserService userService, TaskService taskService) {
        super(userService);
        this.taskService = taskService;
    }


    @Operation(description = "Взять задачу", method = "take")
    @RequestMapping(value = "/take", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> takeTask (@RequestParam (value = "taskId") Long taskId,
                                             @RequestParam (value = "userId") Long userId)
    {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskService.takeTask(taskId,userId));

    }

    @Operation(description = "Закрыть задачу", method = "close")
    @RequestMapping(value = "/close/{id}", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> closeTask (@PathVariable(value = "id") Long taskId)
    {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskService.closeTask(taskId));

    }






}
