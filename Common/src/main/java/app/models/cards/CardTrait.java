package app.models.cards;

import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;

/**
 * @author shanef on 9/24/18.
 */
public class CardTrait extends Model {

    public static LazyList<CardTrait> findByCard(Long cardId) {
        return CardTrait.find("card_id = ?", cardId);
    }

    public CardTrait setLevel(Integer level) {
        return set("level", level);
    }

    public Long getAbilityId() {
        return getLong("card_ability_id");
    }

    public Integer getMaxLevel() {
        return parent(CardAbility.class).getMaxLevel();
    }

    public String getAbilityName() {
        return parent(CardAbility.class).getName();
    }

}
