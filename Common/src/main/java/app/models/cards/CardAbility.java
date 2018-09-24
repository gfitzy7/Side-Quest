package app.models.cards;

import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;

public class CardAbility extends Model {

    public static LazyList<CardAbility> findAll(){
        return CardAbility.find("ORDER BY name ASC");
    }

    public String getName(){
        return getString("name");
    }

    public String getDescription() {
        return getString("description");
    }

    public Integer getMaxLevel() {
        return getInteger("max_level");
    }

}
