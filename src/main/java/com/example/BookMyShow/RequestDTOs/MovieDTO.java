package com.example.BookMyShow.RequestDTOs;

import com.example.BookMyShow.Enumerates.Genre;
import com.example.BookMyShow.Enumerates.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private String name;
    private double rating;
    private int duration;
    private Genre genre;
    private Language language;
}
