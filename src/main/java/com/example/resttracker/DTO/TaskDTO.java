package com.example.resttracker.DTO;

import com.example.resttracker.Model.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO extends GenericDTO{


    private String title;
    private String description;
    private TaskStatus status;
    private Long assignee;
    private Long board;
}
