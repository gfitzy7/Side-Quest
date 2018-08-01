package app.models.cards;

import org.javalite.activejdbc.annotations.Table;

@Table("equipment_cards")
public class EquipmentCard extends Card {

    public enum Slot{
        WEAPON("Weapon"), ARMOR("Armor"), ACCESSORY("Accessory");

        private String displayName;

        Slot(String displayName){
            this.displayName = displayName;
        }

        public String getDisplayName(){
            return displayName;
        }
    }

    @Override
    public CardType getCardType() {
        return CardType.EQUIPMENT;
    }

    @Override
    public Long getCardId() {
        return parent(Card.class).getLongId();
    }

    public Integer getBonusDamage(){
        return getInteger("bonus_damage");
    }

    public Integer getBonusArmor(){
        return getInteger("bonus_armor");
    }

    public Integer getBonusHealth(){
        return getInteger("bonus_health");
    }

    public Integer getBonusSpellDamage(){
        return getInteger("bonus_spell_damage");
    }

    public Boolean isBattleReady(){
        return getBoolean("is_battle_ready");
    }

    public Boolean isBurdensome(){
        return getBoolean("is_burdensome");
    }

    public Boolean isArtifact(){
        return getBoolean("is_artifact");
    }

    public String getSlot(){
        return getString("slot");
    }
}
