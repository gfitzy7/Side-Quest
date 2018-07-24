package app.models;

import org.javalite.activejdbc.Model;

import java.util.HashSet;
import java.util.List;

public class CardSet extends Model {

    public static List<CardSet> getAllCardSets(){
        return CardSet.findAll();
    }

    public int getNumCardSets(){
        return getAllCardSets().size();
    }

    public String getName(){
        return getString("set_name");
    }

    public int getFirstAvailableSetCardSetNumber(){
        HashSet<Integer> usedSetNumbers = new HashSet();
        for(Card card : Card.findBySetId(getId().toString())){
            usedSetNumbers.add(card.getSetCardNumber());
        }

        int i = 1;
        while(usedSetNumbers.contains(i)){
            i++;
        }

        return i;
    }

}
