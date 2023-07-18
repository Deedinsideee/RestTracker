package com.example.resttracker.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO extends GenericDTO{



    private String title;
    private Long owner;
    private List<Long> tasks;
}
