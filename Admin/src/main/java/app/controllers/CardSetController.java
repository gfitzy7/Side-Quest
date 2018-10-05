package app.controllers;

import app.models.*;
import app.models.cards.*;
import app.models.packs.Rarity;
import app.services.CardService;
import org.javalite.activejdbc.Paginator;
import org.javalite.activeweb.annotations.GET;
import org.javalite.activeweb.annotations.POST;

import java.util.List;

public class CardSetController extends AbstractAppController {

    private static final CardService cardService = new CardService();

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

        view("card_set", cardSet);
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

        loadStaticCardData();

        view("set_id", getId());
        view("set_name", cardSet.getName());
        view("header", "Add a card to set " + cardSet.getName());
        view("form_action", "create_new_card");
        view("form_submit_btn_text", "Create");

        render("card_view");
    }

    @POST
    public void createNewCard(){
        Card.CardType cardType = Card.CardType.getCardType(param("cardType"));
        Card card = cardService.createCard(cardType, params1st());

        if(card != null) {

        }

        redirect(CardSetController.class, "overview", param("set_id"));
    }
    @GET
    public void refreshOrder(){
        CardSet cardSet = CardSet.findById(getId());
        cardSet.refreshCardSetOrder();

        redirectToReferrer();
    }

    @GET
    public void deleteCard(){
        Card card = Card.findById(getId());

        card.deleteCascadeShallow();

        redirectToReferrer();
    }

    @GET
    public void editCard(){
        Card card = Card.findById(getId());
        loadStaticCardData();

        view("card_id", card.getCardId());
        view("card_type", card.getType());
        view("card_name", card.getName());
        view("card_description", card.getString("description"));
        view("card_rarity", card.getRarityName());
        view("card_rarity_weight", card.getInteger("rarity_weight"));
        view("card_mana_cost", card.getInteger("mana_cost"));
        view("card_deck_limit", card.getInteger("deck_limit"));

        List<CardTrait> cardTraits = CardTrait.findByCard(Long.parseLong(getId()));
        view("card_traits", cardTraits);

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
        view("isEdit", "true");

        view("header", "Edit Card");
        view("form_action", "save_card");
        view("form_submit_btn_text", "Save");

        render("card_view");
    }

    @POST
    public void saveCard() {
        Card card = Card.findById(getId());
        cardService.saveCard(card, params1st());

        redirect(CardSetController.class, "overview", param("set_id"));
    }

    @GET
    public void publish() {
        CardSet set = CardSet.findById(getId());

        set.setInteger("num_cards", set.findAllFromSet().size());
        set.setDate("release_date", System.currentTimeMillis());
        set.saveIt();

        redirectToReferrer();
    }

    private void loadStaticCardData() {
        List<String> rarityNames = Rarity.getAllFromMostToLeastCommonWithPrefix();
        List<CharacterClass> classes = CharacterClass.findAll();
        List<CardAbility> abilities = CardAbility.findAll();
        EquipmentCard.Slot[] equipmentSlots = EquipmentCard.Slot.values();
        view("rarity_names", rarityNames);
        view("classes", classes);
        view("abilities", abilities);
        view("equipmentSlots", equipmentSlots);
    }
}
