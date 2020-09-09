package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.entity.User;
import com.thoughtworks.capacity.gtb.mvc.entity.UserDTO;
import com.thoughtworks.capacity.gtb.mvc.exception.UserAlreadyExistException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {

    private final List<UserDTO> userDTOList = new LinkedList<>();

    public void register(User user) {
        UserDTO userDTO = new UserDTO(userDTOList.size() + 1, user.getUsername(), user.getPassword(), user.getEmail());
        if (userDTOList.contains(userDTO)) {
            throw new UserAlreadyExistException("The username has already exist.");
        }
        userDTOList.add(userDTO);
    }
}
