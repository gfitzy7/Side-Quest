package app.models;

import org.javalite.activejdbc.Model;

import java.util.List;

public class Card extends Model {

    public enum CardType{
        CHARACTER(CharacterCard.class), EQUIPMENT(EquipmentCard.class), GAMBIT(GambitCard.class), ITEM(ItemCard.class);

        private Class cardClass;

        CardType(Class<? extends Card> cardClass) {
            this.cardClass = cardClass;
        }

        public Class<? extends Card> getCardClass(){
            return cardClass;
        }
    }

    public static List<Card> findBySetId(String setId){
        return Card.find("card_set_id = ?", setId);
    }

    public String getName(){
        return get("name").toString();
    }

    public Integer getSetCardNumber(){
        return getInteger("card_set_card_number");
    }

}
