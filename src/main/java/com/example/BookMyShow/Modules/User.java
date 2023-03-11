package com.example.BookMyShow.Modules;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_db")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int age;
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private  String mobileNumber;
    private String address;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Ticket> ticketList = new ArrayList<>();
}
