package com.example.BookMyShow.Controller;

import com.example.BookMyShow.RequestDTOs.UserDTO;
import com.example.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO){
        try{
            String result = userService.addUser(userDTO);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>("User couldn't be added.", HttpStatus.BAD_REQUEST);
    }
}
