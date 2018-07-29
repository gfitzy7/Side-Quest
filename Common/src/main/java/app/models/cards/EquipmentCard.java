package app.models.cards;

import org.javalite.activejdbc.annotations.Table;

@Table("equipment_cards")
public class EquipmentCard extends Card {

    @Override
    public CardType getCardType() {
        return CardType.EQUIPMENT;
    }

}
