package com.example.BookMyShow.RequestDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int age;
    private String name;
    private String email;
    private  String mobileNumber;
    private String address;
}
