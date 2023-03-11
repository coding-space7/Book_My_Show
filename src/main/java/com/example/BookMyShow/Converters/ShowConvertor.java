package com.example.BookMyShow.Converters;

import com.example.BookMyShow.Modules.Show;
import com.example.BookMyShow.RequestDTOs.ShowDTOs;

public class ShowConvertor {

    public static Show DtoToShow(ShowDTOs showDTOs){
        return Show.builder()
                .showType(showDTOs.getShowType())
                .showDate(showDTOs.getShowDate())
                .showTime(showDTOs.getShowTime())
                .build();
    }
}
