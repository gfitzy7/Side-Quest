ALTER TABLE item_cards
ADD COLUMN card_set_id int NOT NULL,
ADD COLUMN card_set_card_number int NOT NULL,
ADD COLUMN name varchar(64) NOT NULL,
ADD COLUMN description varchar(256),
ADD COLUMN mana_cost int NOT NULL DEFAULT 0,
ADD COLUMN deck_limit int NOT NULL DEFAULT -1,
ADD FOREIGN KEY (card_set_id) REFERENCES card_sets(id);

ALTER TABLE equipment_cards
ADD COLUMN card_set_id int NOT NULL,
ADD COLUMN card_set_card_number int NOT NULL,
ADD COLUMN name varchar(64) NOT NULL,
ADD COLUMN description varchar(256),
ADD COLUMN mana_cost int NOT NULL DEFAULT 0,
ADD COLUMN deck_limit int NOT NULL DEFAULT -1,
ADD FOREIGN KEY (card_set_id) REFERENCES card_sets(id);

ALTER TABLE gambit_cards
ADD COLUMN card_set_id int NOT NULL,
ADD COLUMN card_set_card_number int NOT NULL,
ADD COLUMN name varchar(64) NOT NULL,
ADD COLUMN description varchar(256),
ADD COLUMN mana_cost int NOT NULL DEFAULT 0,
ADD COLUMN deck_limit int NOT NULL DEFAULT -1,
ADD FOREIGN KEY (card_set_id) REFERENCES card_sets(id);

ALTER TABLE character_cards
ADD COLUMN card_set_id int NOT NULL,
ADD COLUMN card_set_card_number int NOT NULL,
ADD COLUMN name varchar(64) NOT NULL,
ADD COLUMN description varchar(256),
ADD COLUMN mana_cost int NOT NULL DEFAULT 0,
ADD COLUMN deck_limit int NOT NULL DEFAULT -1,
ADD FOREIGN KEY (card_set_id) REFERENCES card_sets(id);