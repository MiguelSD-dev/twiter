package com.ceica.twiter.service;

import com.ceica.twiter.model.Twit;
import com.ceica.twiter.repository.TwitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TwitService {
    private TwitRepository twitRepository;

    @Autowired
    public TwitService(TwitRepository twitRepository) {
        this.twitRepository = twitRepository;
    }

    public List<Twit> getAllTwits() {
        return twitRepository.findAll();
    }

    public void save(Twit twit1) {
       twitRepository.save(twit1);
    }

    public List<Twit> getTwitsByUserId(Integer user_id) {
        // Implementa la lógica para recuperar los Twits asociados con el usuario por su ID
        return twitRepository.findByUser_idOrderByDateDesc(user_id);
    }
}
