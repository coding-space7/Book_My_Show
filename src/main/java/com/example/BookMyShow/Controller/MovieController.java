package com.example.BookMyShow.Controller;

import com.example.BookMyShow.RequestDTOs.MovieDTO;
import com.example.BookMyShow.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/addMovie")
    public ResponseEntity<String> addMovie(@RequestBody MovieDTO movieDTO){
        try{
            String result = movieService.addMovie(movieDTO);
            return  new ResponseEntity<>(result,HttpStatus.CREATED);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>("Movie Couldn't be created.", HttpStatus.BAD_REQUEST);
    }
}
