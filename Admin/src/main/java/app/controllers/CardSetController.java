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

    @GET
    public void newCard(){
        CardSet cardSet = CardSet.findById(getId());
        List<String> rarityNames = Rarity.getAllFromMostToLeastCommonWithPrefix();
        List<CharacterClass> classes = CharacterClass.findAll();
        List<CardAbility> abilities = CardAbility.findAll();
        EquipmentCard.Slot[] equipmentSlots = EquipmentCard.Slot.values();

        view("set_id", getId());
        view("set_name", cardSet.getName());
        view("rarity_names", rarityNames);
        view("classes", classes);
        view("abilities", abilities);
        view("equipmentSlots", equipmentSlots);

        view("header", "Add a card to set " + cardSet.getName());
        view("form_action", "create_new_card");
        view("form_submit_btn_text", "Create");

        render("card_view");
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

            createParentCard(namesAndValues);

            CharacterCard.createIt(namesAndValues.toArray());
        }
        else if(cardType == Card.CardType.EQUIPMENT){
            namesAndValues.add("slot");
            namesAndValues.add(param("equipmentSlot"));
            namesAndValues.add("bonus_damage");
            namesAndValues.add(param("bonus_damage"));
            namesAndValues.add("bonus_armor");
            namesAndValues.add(param("bonus_armor"));
            namesAndValues.add("bonus_health");
            namesAndValues.add(param("bonus_health"));
            namesAndValues.add("bonus_spell_damage");
            namesAndValues.add(param("bonus_spell_damage"));
            namesAndValues.add("is_battle_ready");
            namesAndValues.add(exists("is_battle_ready") ? "1" : "0");
            namesAndValues.add("is_burdensome");
            namesAndValues.add(exists("is_burdensome") ? "1" : "0");
            namesAndValues.add("is_artifact");
            namesAndValues.add(exists("is_artifact") ? "1" : "0");

            createParentCard(namesAndValues);

            EquipmentCard.createIt(namesAndValues.toArray());
        }
        else if(cardType == Card.CardType.GAMBIT){
            namesAndValues.add("use_variable_mana_cost");
            namesAndValues.add(exists("useVariableManaCost") ? "1" : "0");
            namesAndValues.add("variable_mana_cost");
            namesAndValues.add(param("variableManaCost"));

            createParentCard(namesAndValues);

            GambitCard.createIt(namesAndValues.toArray());
        }
        else if(cardType == Card.CardType.ITEM){
            createParentCard(namesAndValues);

            ItemCard.createIt(namesAndValues.toArray());
        }

        redirect(CardSetController.class, "overview", param("set_id"));
    }

    private void createParentCard(ArrayList<Object> namesAndValues) {
        Card card = Card.createIt();
        namesAndValues.add("card_id");
        namesAndValues.add(card.getId());
    }

    @GET
    public void refreshOrder(){
        CardSet cardSet = CardSet.findById(getId());
        cardSet.refreshCardSetOrder();

        redirectToReferrer();
    }

    @GET
    public void deleteCard(){
        Card.findById(getId()).delete();

        redirectToReferrer();
    }

    @GET
    public void editCard(){
        Card card = Card.findById(getId());
        List<String> rarityNames = Rarity.getAllFromMostToLeastCommonWithPrefix();
        List<CharacterClass> classes = CharacterClass.findAll();

        view("card_id", card.getCardId());
        view("card_type", card.getType());
        view("card_name", card.getName());
        view("card_description", card.getString("description"));
        view("card_rarity", card.getRarityName());
        view("card_rarity_weight", card.getInteger("rarity_weight"));
        view("card_mana_cost", card.getInteger("mana_cost"));
        view("card_deck_limit", card.getInteger("deck_limit"));

        if(card.getCardType() == Card.CardType.CHARACTER){
            CharacterCard characterCard = (CharacterCard) card;
            view("character_class", characterCard.getCharacterClass().getName());
            view("character_power", characterCard.getPower());
            view("character_health", characterCard.getHealth());
            view("character_attack", characterCard.getAttack());
            view("character_defense", characterCard.getDefense());
        }
        else if(card.getCardType() == Card.CardType.EQUIPMENT){
            EquipmentCard equipmentCard = (EquipmentCard) card;
            view("equipment_slot", equipmentCard.getSlot());
            view("equipmentSlots", EquipmentCard.Slot.values());
            view("bonus_damage", equipmentCard.getBonusDamage());
            view("bonus_armor", equipmentCard.getBonusArmor());
            view("bonus_health", equipmentCard.getBonusHealth());
            view("bonus_spell_damage", equipmentCard.getBonusSpellDamage());
            view("is_battle_ready", equipmentCard.isBattleReady());
            view("is_burdensome", equipmentCard.isBurdensome());
            view("is_artifact", equipmentCard.isArtifact());
        }
        else if(card.getCardType() == Card.CardType.GAMBIT){
            GambitCard gambitCard = (GambitCard) card;
            view("gambit_use_variable_mana_cost", gambitCard.getUseVariableManaCost());
            view("gambit_variable_mana_cost", gambitCard.getVariableManaCost());
        }

        view("set_id", card.getInteger("card_set_id"));
        view("rarity_names", rarityNames);
        view("classes", classes);
        view("isEdit", "true");

        view("header", "Edit Card");
        view("form_action", "save_card");
        view("form_submit_btn_text", "Save");

        render("card_view");
    }

    @POST
    public void saveCard(){
        Card card = Card.findById(getId());
        Rarity rarity = Rarity.findByName(param("rarity"));

        card.set("name", param("cardName"));
        card.set("description", param("cardDescription"));
        card.set("rarity_id", rarity.getId());
        card.set("rarity_weight", param("rarityWeight"));
        card.set("mana_cost", param("manaCost"));

        if(exists("deckLimit")){
            card.set("deck_limit", param("deckLimit"));
        }
        else{
            card.set("deck_limit", -1);
        }

        if(card.getCardType() == Card.CardType.CHARACTER){
            card.set("class_id", CharacterClass.findByName(param("class")).getId());
            card.set("power", param("power"));
            card.set("health", param("health"));
            card.set("attack", param("attack"));
            card.set("defense", param("defense"));
        }
        if(card.getCardType() == Card.CardType.EQUIPMENT){
            card.set("slot", EquipmentCard.Slot.valueOf(param("equipmentSlot")).name());
            card.set("bonus_damage", param("bonus_damage"));
            card.set("bonus_armor", param("bonus_armor"));
            card.set("bonus_health", param("bonus_health"));
            card.set("bonus_spell_damage", param("bonus_spell_damage"));
            card.set("is_battle_ready", exists("is_battle_ready") ? "1" : "0");
            card.set("is_burdensome", exists("is_burdensome") ? "1" : "0");
            card.set("is_artifact", exists("is_artifact") ? "1" : "0");
        }
        if(card.getCardType() == Card.CardType.GAMBIT){
            if(exists("useVariableManaCost") && exists("variableManaCost")){
                card.set("use_variable_mana_cost", 1);
                card.set("variable_mana_cost", param("variableManaCost"));
            }
            else{
                card.set("use_variable_mana_cost", 0);
                card.set("variable_mana_cost", null);
            }
        }

        card.saveIt();

        redirect(CardSetController.class, "overview", param("set_id"));
    }

    private ArrayList<Object> getCommonNamesAndValues(){
        CardSet set = CardSet.findById(param("set_id"));
        List<CardAbility> abilities = CardAbility.findAll();

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
        namesAndValues.add("abilities");
        namesAndValues.add(abilities);

        if(exists("useDeckLimit")){
            namesAndValues.add("deck_limit");
            namesAndValues.add(param("deckLimit"));
        }

        return namesAndValues;
    }

}
