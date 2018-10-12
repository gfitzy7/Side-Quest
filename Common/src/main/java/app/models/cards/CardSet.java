package app.models.cards;

import org.javalite.activejdbc.Model;

import java.lang.reflect.Method;
import java.util.*;

public class CardSet extends Model {

    public static List<CardSet> getAllCardSets(){
        return CardSet.findAll();
    }

    public static List<CardSet> getPublishedCardSets() {
        return CardSet.find("release_date IS NOT NULL");
    }

    public int getNumCardSets(){
        return getAllCardSets().size();
    }

    public String getName(){
        return getString("set_name");
    }

    public List<Card> findAllFromSet(){
        ArrayList<Card> cards = new ArrayList<>();

        try{
            for(Card.CardType cardType : Card.CardType.values()){
                Method m = (cardType.getCardClass()).getMethod("find", String.class, Object[].class);
                cards.addAll((List<Card>) m.invoke(cardType.getCardClass(), "card_set_id = ?", new Object[]{getId()}));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        Collections.sort(cards);

        return cards;
    }

    public int getFirstAvailableSetCardSetNumber(){
        HashSet<Integer> usedSetNumbers = new HashSet();
        for(Card card : findAllFromSet()){
            usedSetNumbers.add(card.getSetCardNumber());
        }

        int i = 1;
        while(usedSetNumbers.contains(i)){
            i++;
        }

        return i;
    }

    public void refreshCardSetOrder(){
        List<Card> cards = findAllFromSet();
        cards.sort((card1, card2) -> {
            int sortByType = card1.getCardType().getSortPriority().compareTo(card2.getCardType().getSortPriority());
            if(sortByType != 0) return sortByType;

            int sortByRarity = card1.getRarity().getPriority().compareTo(card2.getRarity().getPriority());
            if(sortByRarity != 0) return sortByRarity;

            else return card1.getName().compareTo(card2.getName());
        });

        for(int i = 0; i < cards.size(); i++){
            cards.get(i).setString("card_set_card_number", (i + 1)).saveIt();
        }
    }

    public Boolean isPublished() {
        return getDate("release_date") != null;
    }

}
