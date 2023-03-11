package com.example.BookMyShow.Modules;

import com.example.BookMyShow.Enumerates.Genre;
import com.example.BookMyShow.Enumerates.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie_db")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false)
    private String name;
    private double rating;
    private int duration;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    @Enumerated(value = EnumType.STRING)
    private Language language;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    List<Show> showsList = new ArrayList<>();

}
