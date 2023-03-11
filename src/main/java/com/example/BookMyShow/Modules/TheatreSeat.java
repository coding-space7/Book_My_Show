package com.example.BookMyShow.Modules;

import com.example.BookMyShow.Enumerates.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "theatre_seat_db")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TheatreSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn
    private Theatre theatre;
}
