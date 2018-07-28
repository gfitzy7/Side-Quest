package app.models.packs;

import org.javalite.activejdbc.Model;

import java.util.List;

/**
 * @author shanef on 7/27/18.
 */
public class PackConfig extends Model {

    public static List<PackConfig> findAllFromCardPack(Long cardPackId){
        return find("card_pack_id = ?", cardPackId);
    }

    public Integer getNumber(){
        return getInteger("num");
    }

    public Integer getFrequency(){
        return getInteger("frequency");
    }

    public Rarity getRarity(){
        return parent(Rarity.class);
    }

}
