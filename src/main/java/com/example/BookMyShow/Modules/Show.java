package com.example.BookMyShow.Modules;

import com.example.BookMyShow.Enumerates.ShowType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "show_db")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private ShowType showType;


    private LocalDate showDate;
    private LocalTime showTime;

    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;

    @JoinColumn
    @ManyToOne
    private Movie movie;

    @JoinColumn
    @ManyToOne
    private Theatre theatre;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    List<Ticket> ticketList = new ArrayList<>();

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    List<ShowSeat> showSeatList = new ArrayList<>();

}
