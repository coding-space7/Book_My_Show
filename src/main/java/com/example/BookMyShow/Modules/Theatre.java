package com.example.BookMyShow.Modules;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theatre_db")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    List<TheatreSeat> seatList = new ArrayList<>();

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    List<Show> showsList = new ArrayList<>();
}
