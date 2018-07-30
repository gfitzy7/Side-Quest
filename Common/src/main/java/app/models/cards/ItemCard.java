package app.models.cards;

import org.javalite.activejdbc.annotations.Table;

@Table("item_cards")
public class ItemCard extends Card {

    @Override
    public CardType getCardType() {
        return CardType.ITEM;
    }

    @Override
    public Long getCardId() {
        return parent(Card.class).getLongId();
    }
}
