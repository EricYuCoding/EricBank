package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.model.Cards;
import com.eazybytes.springsecuritybasic.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    CardsRepository cardsRepository;

    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam int id){

        List<Cards> cards = cardsRepository.findByCustomerId(id);
        if (cards.size() > 0){
            return cards;
        }else {
            return null;
        }
    }
}
