package app.models.cards;

import app.models.packs.Rarity;
import org.javalite.activejdbc.Model;

import java.lang.reflect.Method;
import java.util.List;

public class Card extends Model implements Comparable<Card> {

    public enum CardType{
        CHARACTER(CharacterCard.class, "character_cards", "Character", 1),
        EQUIPMENT(EquipmentCard.class, "equipment_cards", "Equipment", 2),
        GAMBIT(GambitCard.class, "gambit_cards", "Gambit", 3),
        ITEM(ItemCard.class, "item_cards", "Item", 4);

        private Class cardClass;
        private String tableName;
        private String displayName;
        private int sortPriority;

        CardType(Class<? extends Card> cardClass, String tableName, String displayName, int sortPriority) {
            this.cardClass = cardClass;
            this.tableName = tableName;
            this.displayName = displayName;
            this.sortPriority = sortPriority;
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

        public String toString(){
            return displayName;
        }

        public Integer getSortPriority() {
            return sortPriority;
        }
    }

    public CardType getCardType(){
        return null;
    }

    public Long getCardId(){
        return getLongId();
    };

    public static Card findById(Object id){
        try{
            for(CardType type : CardType.values()){
                Method m = (type.getCardClass()).getMethod("find", String.class, Object[].class);
                List<Card> cards = (List<Card>) m.invoke(type.getCardClass(), "card_id = ?", new Object[]{id});
                if(cards.size() > 0){
                    return cards.get(0);
                }
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return null;
    }

    public Rarity getRarity(){
        return parent(Rarity.class);
    }

    public String getRarityName() {
        return parent(Rarity.class).getName();
    }

    public String getType(){
        return getCardType().toString();
    }

    public String getName(){
        return get("name").toString();
    }

    public Integer getSetCardNumber(){
        return getInteger("card_set_card_number");
    }

    @Override
    public int compareTo(Card otherCard){
        return this.getSetCardNumber() - otherCard.getSetCardNumber();
    }

}
