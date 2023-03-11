package com.example.BookMyShow.Service;

import com.example.BookMyShow.Converters.ShowConvertor;
import com.example.BookMyShow.Enumerates.SeatType;
import com.example.BookMyShow.Modules.*;
import com.example.BookMyShow.Repository.MovieRepository;
import com.example.BookMyShow.Repository.ShowRepository;
import com.example.BookMyShow.Repository.TheatreRepository;
import com.example.BookMyShow.RequestDTOs.ShowDTOs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    public String addShow(ShowDTOs showDTOs){

        Show show = ShowConvertor.DtoToShow(showDTOs);

        Theatre theatre = theatreRepository.findById(showDTOs.getTheatreId()).get();
        Movie movie = movieRepository.findById(showDTOs.getMovieId()).get();

        show.setShowSeatList(createShowSeatList(showDTOs,show));

        theatre.getShowsList().add(show);
        movie.getShowsList().add(show);

        theatreRepository.save(theatre);
        movieRepository.save(movie);

        return "Show created successfully.";
    }

    private List<ShowSeat> createShowSeatList(ShowDTOs showDTOs,Show show){
        List<ShowSeat> showSeatList = new ArrayList<>();

        List<TheatreSeat> theatreSeatList = show.getTheatre().getSeatList();

        for (TheatreSeat theatreSeat:theatreSeatList) {
            ShowSeat showSeat = ShowSeat.builder()
                    .seatNo(theatreSeat.getSeatNo())
                    .seatType(theatreSeat.getSeatType())
                    .price( theatreSeat.getSeatType() == SeatType.CLASSIC ? showDTOs.getClassicSeatPrice() : showDTOs.getPremiumSeatPrice())
                    .isBooked(false)
                    .show(show)
                    .build();

            showSeatList.add(showSeat);
        }

        return showSeatList;
    }
}
