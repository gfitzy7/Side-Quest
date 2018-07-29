package app.controllers;

import app.models.*;
import app.models.cards.*;
import app.models.packs.Rarity;
import org.javalite.activejdbc.Paginator;
import org.javalite.activeweb.annotations.GET;
import org.javalite.activeweb.annotations.POST;

import java.util.ArrayList;
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
        List<Card> cards = cardSet.findAllFromSet();

        view("set_id", cardSet.getId());
        view("set_name", cardSet.getName());
        view("cards", cards);
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
        ArrayList<Object> namesAndValues = getCommonNamesAndValues();

        Card.CardType cardType = Card.CardType.getCardType(param("cardType"));
        if(cardType == Card.CardType.CHARACTER){
            namesAndValues.add("power");
            namesAndValues.add(param("power"));
            namesAndValues.add("health");
            namesAndValues.add(param("health"));
            namesAndValues.add("attack");
            namesAndValues.add(exists("attack") ? "1" : "0");
            namesAndValues.add("defense");
            namesAndValues.add(param("defense"));
            namesAndValues.add("class_id");
            namesAndValues.add(CharacterClass.findByName(param("class")).getLongId());

            CharacterCard.createIt(namesAndValues.toArray());
        }
        else if(cardType == Card.CardType.EQUIPMENT){

        }
        else if(cardType == Card.CardType.GAMBIT){
            namesAndValues.add("use_variable_mana_cost");
            namesAndValues.add(exists("useVariableManaCost") ? "1" : "0");
            namesAndValues.add("variable_mana_cost");
            namesAndValues.add(param("variableManaCost"));

            GambitCard.createIt(namesAndValues.toArray());
        }
        else if(cardType == Card.CardType.ITEM){
            ItemCard.createIt(namesAndValues.toArray());
        }

        redirect(CardSetController.class, "overview", param("set_id"));
    }

    @GET
    public void newCard(){
        CardSet cardSet = CardSet.findById(getId());

        List<Rarity> rarities = Rarity.getAllFromMostToLeastCommon();
        List<String> rarityNames = new ArrayList<>();
        for(Rarity rarity : rarities){
            rarityNames.add("[" + rarity.getPriority() + "] " + rarity.getName());
        }

        List<CharacterClass> classes = CharacterClass.findAll();

        view("set_id", getId());
        view("set_name", cardSet.getName());
        view("rarity_names", rarityNames);
        view("classes", classes);
    }

    @GET
    public void deleteCard(){
        Card.findById(getId()).delete();

        redirectToReferrer();
    }

    @GET
    public void refreshOrder(){
        CardSet cardSet = CardSet.findById(getId());
        cardSet.refreshCardSetOrder();

        redirectToReferrer();
    }

    private ArrayList<Object> getCommonNamesAndValues(){
        CardSet set = CardSet.findById(param("set_id"));

        ArrayList<Object> namesAndValues = new ArrayList<>();

        namesAndValues.add("card_set_id");
        namesAndValues.add(param("set_id"));
        namesAndValues.add("card_set_card_number");
        namesAndValues.add(set.getFirstAvailableSetCardSetNumber());
        namesAndValues.add("name");
        namesAndValues.add(param("cardName"));
        namesAndValues.add("description");
        namesAndValues.add(param("cardDescription"));
        namesAndValues.add("mana_cost");
        namesAndValues.add(param("manaCost"));
        namesAndValues.add("rarity_id");
        namesAndValues.add(Rarity.findByName(param("rarity")).getLongId());
        namesAndValues.add("rarity_weight");
        namesAndValues.add(param("rarityWeight"));

        return namesAndValues;
    }

}
