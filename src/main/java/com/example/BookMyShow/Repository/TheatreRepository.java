package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Modules.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Integer> {
}
