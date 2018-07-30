package app.models.cards;

import org.javalite.activejdbc.annotations.Table;

@Table("gambit_cards")
public class GambitCard extends Card {

    @Override
    public CardType getCardType() {
        return CardType.GAMBIT;
    }

    @Override
    public Long getCardId() {
        return parent(Card.class).getLongId();
    }

    public Boolean getUseVariableManaCost(){
        return getBoolean("use_variable_mana_cost");
    }

    public Integer getVariableManaCost(){
        return getInteger("variable_mana_cost");
    }
}
