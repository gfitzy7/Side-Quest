package app.models;

import org.javalite.activejdbc.Model;

import java.util.List;

public class Card extends Model {

    public static List<Card> findBySetId(String setId){
        return Card.find("card_set_id = ?", setId);
    }

}
