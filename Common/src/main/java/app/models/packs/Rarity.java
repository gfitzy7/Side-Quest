package app.models.packs;

import org.javalite.activejdbc.Model;

/**
 * @author shanef on 7/27/18.
 */
public class Rarity extends Model {

    public Integer getPriority(){
        return getInteger("priority");
    }

    public String getName(){
        return getString("name");
    }

}
