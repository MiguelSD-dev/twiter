package com.ceica.twiter.repository;

import com.ceica.twiter.model.Twit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TwitRepository extends JpaRepository<Twit, Integer> {
}
