package com.pokeportfolio.controller;

import com.pokeportfolio.entity.Card;
import com.pokeportfolio.service.CardService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/{id}")
    public Card getCardById(@PathVariable Long id) {
        return cardService.getCardById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Card addCard(@RequestBody Card card) {
        return cardService.addCard(card);
    }

    @PutMapping("/{id}")
    public Card updateCard(
            @PathVariable Long id,
            @RequestBody Card card) {
        return cardService.updateCard(id, card);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
    }
}