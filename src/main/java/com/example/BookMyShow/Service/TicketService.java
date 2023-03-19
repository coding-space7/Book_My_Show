package com.example.BookMyShow.Service;

import com.example.BookMyShow.Converters.TicketConverter;
import com.example.BookMyShow.Modules.Show;
import com.example.BookMyShow.Modules.ShowSeat;
import com.example.BookMyShow.Modules.Ticket;
import com.example.BookMyShow.Modules.User;
import com.example.BookMyShow.Repository.ShowRepository;
import com.example.BookMyShow.Repository.TicketRepository;
import com.example.BookMyShow.Repository.UserRepository;
import com.example.BookMyShow.RequestDTOs.TicketDTOs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    public String addTicket(TicketDTOs ticketDTOs) throws Exception{

        Ticket ticket = TicketConverter.dtoToTicket(ticketDTOs);

        int amount = 0;
        // validation
        if(!validateSeats(ticketDTOs,amount))
             throw new Exception("Not Valid Seats.");

        Show show = showRepository.findById(ticketDTOs.getShowId()).get();
        User user = userRepository.findById(ticketDTOs.getUserId()).get();



        ticket.setTheatreName(show.getTheatre().getName());
        ticket.setShowDate(show.getShowDate());
        ticket.setShowTime(show.getShowTime());
        ticket.setMovieName(show.getMovie().getName());
        ticket.setTotalAmount(amount);
        ticket.setBookedSeats(bookedSeats(ticketDTOs.getRequestedSeats()));


        ticket.setUser(user);
        ticket.setShow(show);

        show.getTicketList().add(ticket);
        user.getTicketList().add(ticket);

        showRepository.save(show);
        userRepository.save(user);

        return "Ticket created successfully.";
    }

    private String bookedSeats(List<String> seats){
        StringBuilder result = new StringBuilder("");

        for (String seat: seats) {
            result.append(seat + " ");
        }
        return result.toString();
    }

    private boolean validateSeats(TicketDTOs ticketDTOs,int amount){
        List<ShowSeat> showSeatList = showRepository.findById(ticketDTOs.getShowId()).get().getShowSeatList();


        for (String seatNumber: ticketDTOs.getRequestedSeats()) {
            boolean isAvaiable = false;
            for(ShowSeat showSeat : showSeatList){
                if(showSeat.getSeatNo() == seatNumber && !showSeat.isBooked()){
                    isAvaiable = true;
                    showSeat.setBooked(true);
                    showSeat.setBookedAt(new Date());
                    amount = amount + showSeat.getPrice();
                    break;
                }
            }
            if (!isAvaiable)
                return false;
        }
        return true;
    }
}
