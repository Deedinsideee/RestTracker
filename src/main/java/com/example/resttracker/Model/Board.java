package com.example.resttracker.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "boards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "users_sequence",allocationSize = 1)
public class Board  extends GenericModel{


    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "owner_id",foreignKey = @ForeignKey(name = "FK_BOARDS_USERS"))
    private User owner;

    @OneToMany(mappedBy = "board")

    private List<Task> tasks;


}
