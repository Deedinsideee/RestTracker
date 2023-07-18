package com.example.resttracker.Controller;

import com.example.resttracker.DTO.BoardDTO;
import com.example.resttracker.Model.Board;
import com.example.resttracker.Service.BoardService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
@Tag(name="Доски",description = "Контроллеры для работы с досками")
public class BoardController extends GenericController<Board, BoardDTO> {

    protected BoardController(BoardService service)
    {
        super(service);
    }


}
