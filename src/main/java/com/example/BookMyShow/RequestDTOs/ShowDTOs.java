package com.example.BookMyShow.RequestDTOs;

import com.example.BookMyShow.Enumerates.ShowType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowDTOs {
    private LocalDate showDate;
    private LocalTime showTime;
    private ShowType showType;
    private int movieId;
    private int theatreId;

    private int classicSeatPrice;
    private int premiumSeatPrice;

}
