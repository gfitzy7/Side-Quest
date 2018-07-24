package app.controllers;

import app.models.*;
import org.javalite.activejdbc.Paginator;
import org.javalite.activeweb.annotations.GET;
import org.javalite.activeweb.annotations.POST;

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
        view("set_name", cardSet.getName());
        view("page", page);
        view("cards", p.getPage(page));
        view("numCards", cards.size());
    }

    @GET
    public void newSet(){

    }

    @POST
    public void createNewSet(){
        if(param("submit") != null){
            if(param("name").length() == 0 || param("description").length() == 0){

            }
            else{
                CardSet.createIt("set_name", param("name"), "set_description", param("description"));
            }
        }

        redirect();
    }

    @POST
    public void createNewCard(){
        if(param("cardType") != null){
            for(Card.CardType type : Card.CardType.values()){
                if(type.name().equalsIgnoreCase(param("cardType"))){

                }
            }
        }

        CardSet set = CardSet.findById(param("set_id"));
        ItemCard item = ItemCard.createIt("card_id", -1);
        Card card = Card.createIt("card_set_id", param("set_id"), "card_set_card_number", set.getFirstAvailableSetCardSetNumber(), "parent_id", item.getId(), "parent_type", ItemCard.class.getName(),
                "name", param("cardName"), "description", param("cardDescription"), "mana_cost", param("manaCost"));

        item.set("card_id", card.getId()).saveIt();

        redirect(CardSetController.class, "overview", param("set_id"));
    }

    @GET
    public void newCard(){
        CardSet cardSet = CardSet.findById(getId());

        view("set_id", getId());
        view("set_name", cardSet.getName());
    }

}
