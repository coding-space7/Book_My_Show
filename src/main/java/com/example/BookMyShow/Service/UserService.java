package com.example.BookMyShow.Service;

import com.example.BookMyShow.Converters.UserConverter;
import com.example.BookMyShow.RequestDTOs.UserDTO;
import com.example.BookMyShow.Modules.User;
import com.example.BookMyShow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(UserDTO userDTO){
        User user = UserConverter.dtosToUSer(userDTO);
        userRepository.save(user);
        return "Added successfully.";
    }
}
