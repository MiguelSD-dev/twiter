package com.ceica.twiter.repository;

import com.ceica.twiter.model.Twit;
import com.ceica.twiter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TwitRepository extends JpaRepository<Twit, Integer> {
    List<Twit> findByUserOrderByDateDesc(User user);
}

