package com.example.BookMyShow.Controller;

import com.example.BookMyShow.RequestDTOs.ShowDTOs;
import com.example.BookMyShow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    ShowService showService;

    @PostMapping("/addShow")
    public ResponseEntity<String> addShow(@RequestBody ShowDTOs showDTOs){

        try{
            String result = showService.addShow(showDTOs);
            return new ResponseEntity<>(result,HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>("Show was not added.", HttpStatus.BAD_REQUEST);
    }
}
