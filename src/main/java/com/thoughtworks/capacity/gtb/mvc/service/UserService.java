package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.entity.User;
import com.thoughtworks.capacity.gtb.mvc.entity.UserDTO;
import com.thoughtworks.capacity.gtb.mvc.exception.UserAlreadyExistException;
import com.thoughtworks.capacity.gtb.mvc.exception.UsernameOrPasswordNotCorrectException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final Map<String, UserDTO> userDTOMap = new HashMap<>();

    public void register(User user) {
        UserDTO userDTO = new UserDTO(userDTOMap.size() + 1, user.getUsername(), user.getPassword(), user.getEmail());
        if (userDTOMap.containsKey(user.getUsername())) {
            throw new UserAlreadyExistException("The username has already exist.");
        }
        userDTOMap.put(userDTO.getUsername(), userDTO);
    }

    public UserDTO login(String username, String password) {
        if (!userDTOMap.containsKey(username) || !userDTOMap.get(username).getPassword().equals(password)) {
            throw new UsernameOrPasswordNotCorrectException("The username or password is not correct");
        }
        return userDTOMap.get(username);
    }
}
