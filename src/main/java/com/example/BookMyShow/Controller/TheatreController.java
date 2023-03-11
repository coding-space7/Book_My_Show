package com.example.BookMyShow.Controller;

import com.example.BookMyShow.RequestDTOs.TheatreDTO;
import com.example.BookMyShow.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    @PostMapping("/addTheatre")
    public ResponseEntity addTheatre(@RequestBody TheatreDTO theatreDTO){
        try{
            String result = theatreService.addTheatre(theatreDTO);
            return new ResponseEntity<>(result,HttpStatus.CREATED);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>("No able to add theatre.", HttpStatus.BAD_REQUEST);
    }
}
