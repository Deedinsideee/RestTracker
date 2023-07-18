package com.example.resttracker.Service;

import com.example.resttracker.DTO.BoardDTO;
import com.example.resttracker.Mapper.BoardMapper;
import com.example.resttracker.Mapper.GenericMapper;
import com.example.resttracker.Model.Board;
import com.example.resttracker.Repository.BoardRepository;
import com.example.resttracker.Repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class BoardService extends GenericService<Board, BoardDTO>{

    public BoardService(BoardRepository boardRepository, BoardMapper boardMapper) {
        super(boardRepository,boardMapper);
    }
}
