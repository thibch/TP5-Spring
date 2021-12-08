package fr.ul.cardservice.controller;

import fr.ul.cardservice.dao.ICardDAO;
import fr.ul.cardservice.model.Card;
import fr.ul.cardservice.model.dto.CreateCardDTO;
import fr.ul.cardservice.model.dto.UpdateCardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class CardController {

    @Value("${me}")
    private String me;

    private final ICardDAO dao;

    public CardController(@Autowired ICardDAO dao) {
        this.dao = dao;
    }

    @GetMapping(value="/cards")
    public Iterable<Card> getCards() {
        return dao.findAll();
    }

    @GetMapping(value="/card/{id}")
    public Card getCard(@PathVariable("id") String id) {
        Optional<Card> card = dao.findById(id);
        return card.orElse(new Card());
    }

    @PostMapping(value="/card")
    public Card addCard(@RequestBody CreateCardDTO card) {
        Card newCard = new Card(card.getNiveau(), card.getNom(), card.getType());
        return dao.save(newCard);
    }

    @PutMapping(value="/card/{id}")
    public Card updateCard(@PathVariable("id") String id, @RequestBody UpdateCardDTO updateCard) {
        Optional<Card> optCard = dao.findById(id);
        if (optCard.isPresent()) {
            Card card = optCard.get();
            card.setNiveau(updateCard.getNiveau());
            card.setNom(updateCard.getNom());
            card.setType(updateCard.getType());
            return dao.save(card);
        }
        return new Card();
    }

    @DeleteMapping(value="/card/{id}")
    public void deleteCard(@PathVariable String id) {
        dao.deleteById(id);
    }

    @GetMapping(value="/Cestqui")
    public String getName() {
        return me;
    }
}
