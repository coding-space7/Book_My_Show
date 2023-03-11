package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Modules.TheatreSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreSeatRepository extends JpaRepository<TheatreSeat,Integer> {
}
