package app.models;

import org.javalite.activejdbc.annotations.Table;

@Table("item_cards")
public class ItemCard extends Card {

    public String getName(){
        return ((Card) parent(Card.class)).get("name").toString();
    }

}
