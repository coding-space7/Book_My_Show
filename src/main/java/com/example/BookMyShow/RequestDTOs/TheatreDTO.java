package com.example.BookMyShow.RequestDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheatreDTO {
    private String name;
    private String location;
    private int classicSeatCount;
    private int premiumSeatCount;
}
