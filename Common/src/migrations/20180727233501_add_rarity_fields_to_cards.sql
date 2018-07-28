ALTER TABLE character_cards
ADD rarity_id int(11) NOT NULL,
ADD rarity_weight int(11) NOT NULL DEFAULT 100,
ADD FOREIGN KEY (rarity_id) REFERENCES rarities(id);

ALTER TABLE equipment_cards
ADD rarity_id int(11) NOT NULL,
ADD rarity_weight int(11) NOT NULL DEFAULT 100,
ADD FOREIGN KEY (rarity_id) REFERENCES rarities(id);

ALTER TABLE gambit_cards
ADD rarity_id int(11) NOT NULL,
ADD rarity_weight int(11) NOT NULL DEFAULT 100,
ADD FOREIGN KEY (rarity_id) REFERENCES rarities(id);

ALTER TABLE item_cards
ADD rarity_id int(11) NOT NULL,
ADD rarity_weight int(11) NOT NULL DEFAULT 100,
ADD FOREIGN KEY (rarity_id) REFERENCES rarities(id);