package com.example.BookMyShow.Converters;

import com.example.BookMyShow.RequestDTOs.MovieDTO;
import com.example.BookMyShow.Modules.Movie;

public class MovieConvertor {
    public static Movie dtoToMovie(MovieDTO movieDTO){
        Movie movie = Movie.builder()
                .name(movieDTO.getName())
                .genre(movieDTO.getGenre())
                .language(movieDTO.getLanguage())
                .rating(movieDTO.getRating())
                .duration(movieDTO.getDuration())
                .build();

        return movie;
    }
}
