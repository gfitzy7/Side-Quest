CREATE TABLE IF NOT EXISTS cards (
  id int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id)
);

ALTER TABLE character_cards
ADD COLUMN card_id INT(11) NOT NULL,
ADD FOREIGN KEY (card_id) REFERENCES cards(id);

ALTER TABLE equipment_cards
ADD COLUMN card_id INT(11) NOT NULL,
ADD FOREIGN KEY (card_id) REFERENCES cards(id);

ALTER TABLE gambit_cards
ADD COLUMN card_id INT(11) NOT NULL,
ADD FOREIGN KEY (card_id) REFERENCES cards(id);

ALTER TABLE item_cards
ADD COLUMN card_id INT(11) NOT NULL,
ADD FOREIGN KEY (card_id) REFERENCES cards(id);