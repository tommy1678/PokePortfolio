package com.pokeportfolio.service;

import com.pokeportfolio.entity.Card;
import com.pokeportfolio.repository.CardRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card getCardById(Long id) {
        return cardRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Card not found"));
    }

    public Card addCard(Card card) {
        card.setId(null);
        return cardRepository.save(card);
    }

    public Card updateCard(Long id, Card updatedCard) {
        Card existingCard = getCardById(id);

        existingCard.setName(updatedCard.getName());
        existingCard.setSetName(updatedCard.getSetName());
        existingCard.setCardNumber(updatedCard.getCardNumber());
        existingCard.setRarity(updatedCard.getRarity());
        existingCard.setMarketPrice(updatedCard.getMarketPrice());

        return cardRepository.save(existingCard);
    }

    public void deleteCard(Long id) {
        Card card = getCardById(id);
        cardRepository.delete(card);
    }
}