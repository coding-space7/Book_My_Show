package com.example.BookMyShow.Modules;

import com.example.BookMyShow.Enumerates.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "show_seat_db")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int price;
    private boolean isBooked;
    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    @CreationTimestamp
    private Date bookedAt;

    @JoinColumn
    @ManyToOne
    private Show show;
}
