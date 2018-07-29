package app.models.cards;

import org.javalite.activejdbc.annotations.Table;

@Table("gambit_cards")
public class GambitCard extends Card {

    @Override
    public CardType getCardType() {
        return CardType.GAMBIT;
    }

}
