package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Modules.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
