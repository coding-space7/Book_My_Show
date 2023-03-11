package com.example.BookMyShow.Service;

import com.example.BookMyShow.Converters.MovieConvertor;
import com.example.BookMyShow.RequestDTOs.MovieDTO;
import com.example.BookMyShow.Modules.Movie;
import com.example.BookMyShow.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieDTO movieDTO){
        Movie movie = MovieConvertor.dtoToMovie(movieDTO);
        movieRepository.save(movie);
        return "Movie added successfully.";
    }
}
