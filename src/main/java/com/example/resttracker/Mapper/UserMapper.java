package com.example.resttracker.Mapper;

import com.example.resttracker.DTO.UserDTO;
import com.example.resttracker.Model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserMapper extends GenericMapper<User, UserDTO>{

    public UserMapper(ModelMapper modelMapper) {
        super(User.class, UserDTO.class, modelMapper);


    }

    @Override
    protected void mapSpecificFields(UserDTO source, User destination) {

    }

    @Override
    protected void mapSpecificFields(User source, UserDTO destination) {

    }

    @Override
    protected void setupMapper() {

    }

    @Override
    protected List<Long> getIds(User entity) {
        return null;
    }
}
