package com.example.BookMyShow.Converters;

import com.example.BookMyShow.Modules.Theatre;
import com.example.BookMyShow.RequestDTOs.TheatreDTO;

public class TheatreConverter {

    public static Theatre dtoToTheatre(TheatreDTO theatreDTO){
        Theatre theatre = Theatre.builder()
                .name(theatreDTO.getName())
                .location(theatreDTO.getLocation())
                .build();
        return theatre;
    }
}
