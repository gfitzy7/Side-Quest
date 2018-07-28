package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

@Table("classes")
public class CharacterClass extends Model {

    public static CharacterClass findByName(String name){
        return findFirst("name = ?", name);
    }

    public String getName(){
        return getString("name");
    }

    public String toString(){
        return getName();
    }

}
