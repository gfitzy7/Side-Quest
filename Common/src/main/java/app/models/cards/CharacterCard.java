package app.models.cards;

import org.javalite.activejdbc.annotations.Table;

@Table("character_cards")
public class CharacterCard extends Card {

    @Override
    public CardType getCardType() {
        return CardType.CHARACTER;
    }

}
