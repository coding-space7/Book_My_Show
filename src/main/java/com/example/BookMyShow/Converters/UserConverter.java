package com.example.BookMyShow.Converters;

import com.example.BookMyShow.RequestDTOs.UserDTO;
import com.example.BookMyShow.Modules.User;

public class UserConverter {
    public static User dtosToUSer(UserDTO userDTO){
        User user =  User.builder().age(userDTO.getAge()).address(userDTO.getAddress()).email(userDTO.getEmail()).name(userDTO.getName())
                .mobileNumber(userDTO.getMobileNumber()).build();

        return user;
    }
}
