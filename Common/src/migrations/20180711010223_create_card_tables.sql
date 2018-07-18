CREATE TABLE IF NOT EXISTS card_sets (id int NOT NULL AUTO_INCREMENT, set_name varchar(64) NOT NULL, set_description text(10000), set_logo varchar(64), set_release_date datetime, num_cards int DEFAULT 0 NOT NULL, PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS abilities (id int NOT NULL AUTO_INCREMENT, type enum('MANAFLOW', 'PARRY', 'LAST GASP'), max_level int DEFAULT -1 NOT NULL, PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS card_traits (id int NOT NULL AUTO_INCREMENT, ability_id int NOT NULL, level int, parent_id int NOT NULL, parent_type varchar(64) NOT NULL, PRIMARY KEY (id), FOREIGN KEY (ability_id) REFERENCES abilities(id), INDEX idxTraits (parent_id));

CREATE TABLE IF NOT EXISTS cards (id int NOT NULL AUTO_INCREMENT, card_set_id int NOT NULL, card_set_card_number int NOT NULL, parent_id int NOT NULL, parent_type varchar(64) NOT NULL, name varchar(64) NOT NULL, description varchar(256), mana_cost int NOT NULL DEFAULT 0, deck_limit int NOT NULL DEFAULT -1, PRIMARY KEY (id), FOREIGN KEY (card_set_id) REFERENCES card_sets(id), INDEX idxCards (parent_id));

CREATE TABLE IF NOT EXISTS gambit_cards (id int NOT NULL AUTO_INCREMENT, variable_mana_cost boolean DEFAULT 0 NOT NULL, variable_mana_cost_interval int DEFAULT 0 NOT NULL, PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS item_cards (id int NOT NULL AUTO_INCREMENT, PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS character_cards (id int NOT NULL AUTO_INCREMENT, class enum('ARCHON', 'ASSASSIN', 'SAMURAI', 'THAUMATURGE', 'ELEMENTALIST', 'SAGE') NOT NULL, power int NOT NULL, health int NOT NULL, attack int NOT NULL, defense int NOT NULL, PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS equipment_cards (id int NOT NULL AUTO_INCREMENT, slot enum ('WEAPON', 'ARMOR', 'ACCESSORY') NOT NULL, bonus_damage int, bonus_armor int, bonus_health int, bonus_spell_damage int, is_battle_ready boolean DEFAULT 0, is_burdensome boolean DEFAULT 0, is_legendary boolean DEFAULT 0, soul_quench_level int DEFAULT 0, PRIMARY KEY (id));
