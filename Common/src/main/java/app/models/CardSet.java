package app.models;

import org.javalite.activejdbc.Model;

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

}
