package com.example.BookMyShow.Service;

import com.example.BookMyShow.Enumerates.SeatType;
import com.example.BookMyShow.Modules.Theatre;
import com.example.BookMyShow.Modules.TheatreSeat;
import com.example.BookMyShow.Repository.TheatreRepository;
import com.example.BookMyShow.Repository.TheatreSeatRepository;
import com.example.BookMyShow.RequestDTOs.TheatreDTO;
import com.example.BookMyShow.Converters.TheatreConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {

    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    TheatreSeatRepository theatreSeatRepository;

    public String addTheatre(TheatreDTO theatreDTO){

        Theatre theatre = TheatreConverter.dtoToTheatre(theatreDTO);

        List<TheatreSeat> list = createTheatreList(theatreDTO,theatre);
        theatre.setSeatList(list);

        theatreRepository.save(theatre);

        return "Theatre added successfully.";
    }

    private List<TheatreSeat> createTheatreList(TheatreDTO theatreDTO,Theatre theatre){

        int classicCount = theatreDTO.getClassicSeatCount();
        int premiumCount = theatreDTO.getPremiumSeatCount();

        List<TheatreSeat> seatList = new ArrayList<>();

        // For classic seat
        for (int i = 1; i <= classicCount; i++) {
            TheatreSeat theatreSeat = TheatreSeat.builder()
                    .seatNo(i+"C")
                    .seatType(SeatType.CLASSIC)
                    .theatre(theatre)
                    .build();
            seatList.add(theatreSeat);
        }
        // For Premium seat
        for (int i = 1; i <= premiumCount; i++) {
            TheatreSeat theatreSeat = TheatreSeat.builder()
                    .seatNo(i+"P")
                    .seatType(SeatType.PREMIUM)
                    .theatre(theatre)
                    .build();
            seatList.add(theatreSeat);
        }


        return seatList;
    }
}
