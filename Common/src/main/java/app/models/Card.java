package app.models;

import org.javalite.activejdbc.Model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class Card extends Model {

    public enum CardType{
        CHARACTER(CharacterCard.class, "character_cards"),
        EQUIPMENT(EquipmentCard.class, "equipment_cards"),
        GAMBIT(GambitCard.class, "gambit_cards"),
        ITEM(ItemCard.class, "item_cards");

        private Class cardClass;
        private String tableName;

        CardType(Class<? extends Card> cardClass, String tableName) {
            this.cardClass = cardClass;
            this.tableName = tableName;
        }

        public static Class<? extends Card> getCardClassByType(String cardType){
            for(CardType type : values()){
                if(type.name().equalsIgnoreCase(cardType)){
                    return type.cardClass;
                }
            }

            return null;
        }

        public static CardType getCardType(String cardType){
            for(CardType type : values()){
                if(type.name().equalsIgnoreCase(cardType)){
                    return type;
                }
            }

            return null;
        }

        public Class<? extends Card> getCardClass(){
            return cardClass;
        }

        public String getTableName(){
            return tableName;
        }
    }

    public static List<Card> findBySetId(String setId){
        ArrayList<Card> cards = new ArrayList<>();

        try{
            for(CardType cardType : CardType.values()){
                Method m = (cardType.getCardClass()).getMethod("find", String.class, Object[].class);
                cards.addAll((List<Card>) m.invoke(cardType.getCardClass(), "card_set_id = ?", new Object[]{setId}));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return cards;
    }

    public String getName(){
        return get("name").toString();
    }

    public Integer getSetCardNumber(){
        return getInteger("card_set_card_number");
    }

}
