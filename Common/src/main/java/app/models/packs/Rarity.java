package app.models.packs;

import org.javalite.activejdbc.Model;

import java.util.List;

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

    public static List<Rarity> getAllFromMostToLeastCommon(){
        return find("ORDER BY priority ASC");
    }

    public static Rarity findByName(String name){
        if(name.indexOf("]") > -1){
            name = name.substring(name.indexOf("]") + 2);
        }

        return findFirst("name = ?", name);
    }

}
