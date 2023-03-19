package com.example.BookMyShow.Converters;

import com.example.BookMyShow.Modules.Ticket;
import com.example.BookMyShow.RequestDTOs.TicketDTOs;

public class TicketConverter {

    public static Ticket dtoToTicket(TicketDTOs ticketDTOs){
        return  new Ticket();
    }
}
