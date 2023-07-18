package com.example.resttracker.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task extends GenericModel {


    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Enumerated()
    @Column(name = "status")
    private TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "assignee_id",foreignKey = @ForeignKey(name = "FK_TASKS_USERS"))
    private User assignee;

    @ManyToOne
    @JoinColumn(name = "board_id",foreignKey = @ForeignKey(name = "FK_TASKS_BOARDS") )
    private Board board;

    // Конструкторы, геттеры и сеттеры

    // ...
}
