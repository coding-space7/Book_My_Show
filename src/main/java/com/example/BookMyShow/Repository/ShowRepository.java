package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Modules.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show,Integer> {
}
