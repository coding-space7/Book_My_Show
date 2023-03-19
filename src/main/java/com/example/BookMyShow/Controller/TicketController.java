package com.example.BookMyShow.Controller;

import com.example.BookMyShow.RequestDTOs.TicketDTOs;
import com.example.BookMyShow.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/addTicket")
    public ResponseEntity<String> addTicket(@RequestBody TicketDTOs ticketDTOs){
        try{
            String result = ticketService.addTicket(ticketDTOs);
            return new ResponseEntity<>(result,HttpStatus.CREATED);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>("Ticket can't be created.", HttpStatus.BAD_REQUEST);
    }
}
