package app.controllers;

import app.models.Card;
import app.models.CardSet;
import org.javalite.activejdbc.Paginator;
import org.javalite.activeweb.annotations.GET;

import java.util.List;

public class CardSetController extends AbstractAppController {

    @GET
    public void index(){
        Paginator p = new Paginator(CardSet.class, 10, "");

        int page = (param("page") == null ? 1 : Integer.parseInt(param("page")));

        view("page", page);
        view("cardSets", p.getPage(page));
        view("numCardSets", CardSet.findAll().size());
    }

    @GET
    public void overview(){
        CardSet cardSet = CardSet.findById(getId());
        List<Card> cards = Card.findBySetId(cardSet.getId().toString());

        Paginator p = new Paginator(Card.class, 10, "card_set_id = ?", cardSet.getId().toString());

        int page = (param("page") == null ? 1 : Integer.parseInt(param("page")));

        view("set_id", cardSet.getId());
        view("page", page);
        view("cards", p.getPage(page));
        view("numCards", cards.size());
    }

    @GET
    public void newCard(){
        CardSet cardSet = CardSet.findById(getId());

        view("set_id", getId());
        view("set_name", cardSet.getName());
    }

}
