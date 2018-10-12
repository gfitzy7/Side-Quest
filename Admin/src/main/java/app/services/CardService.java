package app.services;

import app.models.CharacterClass;
import app.models.cards.*;
import app.models.packs.Rarity;

import java.util.*;

/**
 * @author shanef on 10/2/18.
 */
public class CardService {

    public Card createCard(Card.CardType cardType, Map<String, String> params) {
        ArrayList<Object> namesAndValues = getCommonNamesAndValues(params);

        if(cardType == Card.CardType.CHARACTER) {
            namesAndValues.add("power");
            namesAndValues.add(params.get("power"));
            namesAndValues.add("health");
            namesAndValues.add(params.get("health"));
            namesAndValues.add("attack");
            namesAndValues.add(params.get("attack"));
            namesAndValues.add("defense");
            namesAndValues.add(params.get("defense"));
            namesAndValues.add("class_id");
            namesAndValues.add(CharacterClass.findByName(params.get("class")).getLongId());

            Card card = createParentCard(namesAndValues);
            createOrEditAbilities(card, params);

            return CharacterCard.createIt(namesAndValues.toArray());
        }
        else if(cardType == Card.CardType.EQUIPMENT) {
            namesAndValues.add("slot");
            namesAndValues.add(params.get("equipmentSlot"));
            namesAndValues.add("bonus_damage");
            namesAndValues.add(params.get("bonus_damage"));
            namesAndValues.add("bonus_armor");
            namesAndValues.add(params.get("bonus_armor"));
            namesAndValues.add("bonus_health");
            namesAndValues.add(params.get("bonus_health"));
            namesAndValues.add("bonus_spell_damage");
            namesAndValues.add(params.get("bonus_spell_damage"));
            namesAndValues.add("is_battle_ready");
            namesAndValues.add(params.containsKey("is_battle_ready") ? "1" : "0");
            namesAndValues.add("is_burdensome");
            namesAndValues.add(params.containsKey("is_burdensome") ? "1" : "0");
            namesAndValues.add("is_artifact");
            namesAndValues.add(params.containsKey("is_artifact") ? "1" : "0");

            Card card = createParentCard(namesAndValues);
            createOrEditAbilities(card, params);

            return EquipmentCard.createIt(namesAndValues.toArray());
        }
        else if(cardType == Card.CardType.GAMBIT) {
            namesAndValues.add("use_variable_mana_cost");
            namesAndValues.add(params.containsKey("useVariableManaCost") ? "1" : "0");
            namesAndValues.add("variable_mana_cost");
            namesAndValues.add(params.get("variableManaCost"));

            createParentCard(namesAndValues);

            return GambitCard.createIt(namesAndValues.toArray());
        }
        else if(cardType == Card.CardType.ITEM) {
            createParentCard(namesAndValues);

            return ItemCard.createIt(namesAndValues.toArray());
        }
        else {
            return null;
        }
    }

    public Card saveCard(Card card, Map<String, String> params) {
        Rarity rarity = Rarity.findByName(params.get("rarity"));

        card.set("name", params.get("cardName"));
        card.set("description", params.get("cardDescription"));
        card.set("rarity_id", rarity.getId());
        card.set("rarity_weight", params.get("rarityWeight"));
        card.set("mana_cost", params.get("manaCost"));

        if(params.containsKey("deckLimit")){
            card.set("deck_limit", params.get("deckLimit"));
        }
        else{
            card.set("deck_limit", -1);
        }

        if(card.getCardType() == Card.CardType.CHARACTER){
            card.set("class_id", CharacterClass.findByName(params.get("class")).getId());
            card.set("power", params.get("power"));
            card.set("health", params.get("health"));
            card.set("attack", params.get("attack"));
            card.set("defense", params.get("defense"));

            createOrEditAbilities(card, params);
        }
        if(card.getCardType() == Card.CardType.EQUIPMENT){
            card.set("slot", EquipmentCard.Slot.valueOf(params.get("equipmentSlot")).name());
            card.set("bonus_damage", params.get("bonus_damage"));
            card.set("bonus_armor", params.get("bonus_armor"));
            card.set("bonus_health", params.get("bonus_health"));
            card.set("bonus_spell_damage", params.get("bonus_spell_damage"));
            card.set("is_battle_ready", params.containsKey("is_battle_ready") ? "1" : "0");
            card.set("is_burdensome", params.containsKey("is_burdensome") ? "1" : "0");
            card.set("is_artifact", params.containsKey("is_artifact") ? "1" : "0");

            createOrEditAbilities(card, params);
        }
        if(card.getCardType() == Card.CardType.GAMBIT){
            if(params.containsKey("useVariableManaCost") && params.containsKey("variableManaCost")){
                card.set("use_variable_mana_cost", 1);
                card.set("variable_mana_cost", params.get("variableManaCost"));
            }
            else{
                card.set("use_variable_mana_cost", 0);
                card.set("variable_mana_cost", null);
            }
        }

        card.saveIt();

        return card;
    }

    public HashMap<Rarity, Integer> getRarityCountsInSet(CardSet cardSet) {
        HashMap<Rarity, Integer> hmRarityCount = new HashMap<>();

        List<Card> cards = cardSet.findAllFromSet();
        for(Card card : cards) {
            Rarity cardRarity = card.getRarity();
            Integer count = (hmRarityCount.get(cardRarity) == null ? 0 : hmRarityCount.get(cardRarity));
            hmRarityCount.put(cardRarity, count + 1);
        }

        return hmRarityCount;
    }

    private Card createParentCard(ArrayList<Object> namesAndValues) {
        Card card = Card.createIt();
        namesAndValues.add("card_id");
        namesAndValues.add(card.getId());
        return card;
    }

    private ArrayList<Object> getCommonNamesAndValues(Map<String, String> params){
        CardSet set = CardSet.findById(params.get("set_id"));

        ArrayList<Object> namesAndValues = new ArrayList<>();

        namesAndValues.add("card_set_id");
        namesAndValues.add(params.get("set_id"));
        namesAndValues.add("card_set_card_number");
        namesAndValues.add(set.getFirstAvailableSetCardSetNumber());
        namesAndValues.add("name");
        namesAndValues.add(params.get("cardName"));
        namesAndValues.add("description");
        namesAndValues.add(params.get("cardDescription"));
        namesAndValues.add("mana_cost");
        namesAndValues.add(params.get("manaCost"));
        namesAndValues.add("rarity_id");
        namesAndValues.add(Rarity.findByName(params.get("rarity")).getLongId());
        namesAndValues.add("rarity_weight");
        namesAndValues.add(params.get("rarityWeight"));

        if(params.containsKey("useDeckLimit")){
            namesAndValues.add("deck_limit");
            namesAndValues.add(params.get("deckLimit"));
        }

        return namesAndValues;
    }

    private void createOrEditAbilities(Card card, Map<String, String> params) {
        List<CardTrait> traits = CardTrait.findByCard(card.getCardId());
        HashSet<Long> abilityList = new HashSet<>();

        String delimiter = "ability_";

        for(Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            if(key.startsWith(delimiter)) {
                Long id = Long.parseLong(key.substring(delimiter.length()));

                for(CardTrait trait : traits) {
                    if(trait.getAbilityId() == id) {
                        abilityList.add(id);
                        trait.setLevel(Integer.parseInt(params.get(entry.getKey()))).saveIt();
                        break;
                    }
                }

                if(!abilityList.contains(id)) {
                    abilityList.add(id);
                    CardTrait.createIt("card_ability_id", id, "card_id", card.getCardId(), "level", params.get(key));
                }
            }
        }

        traits = CardTrait.findByCard(card.getCardId());
        for(CardTrait trait : traits) {
            if(!abilityList.contains(trait.getAbilityId())){
                trait.delete();
            }
        }
    }

}
