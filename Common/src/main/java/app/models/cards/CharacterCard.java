package app.models.cards;

import app.models.CharacterClass;
import org.javalite.activejdbc.annotations.Table;

@Table("character_cards")
public class CharacterCard extends Card {

    @Override
    public CardType getCardType() {
        return CardType.CHARACTER;
    }

    @Override
    public Long getCardId() {
        return parent(Card.class).getLongId();
    }

    public CharacterClass getCharacterClass(){
        return parent(CharacterClass.class);
    }

    public Integer getPower(){
        return getInteger("power");
    }

    public Integer getHealth(){
        return getInteger("health");
    }

    public Integer getAttack(){
        return getInteger("attack");
    }

    public Integer getDefense(){
        return getInteger("defense");
    }
}
