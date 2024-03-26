package com.ceica.twiter.repository;

import com.ceica.twiter.model.Fav;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavRepository extends JpaRepository<Fav, Integer> {
}
