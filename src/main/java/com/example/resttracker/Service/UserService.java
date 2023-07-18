package com.example.resttracker.Service;

import com.example.resttracker.DTO.UserDTO;
import com.example.resttracker.Mapper.GenericMapper;
import com.example.resttracker.Mapper.UserMapper;
import com.example.resttracker.Model.User;
import com.example.resttracker.Repository.GenericRepository;
import com.example.resttracker.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User, UserDTO>{

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        super(userRepository, userMapper);
    }












}
