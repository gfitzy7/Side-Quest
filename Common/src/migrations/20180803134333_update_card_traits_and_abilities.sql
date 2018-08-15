ALTER TABLE card_traits
DROP FOREIGN KEY `card_traits_ibfk_1`,
DROP INDEX ability_id,
DROP COLUMN ability_id;

DROP TABLE IF EXISTS abilities;

CREATE TABLE IF NOT EXISTS card_abilities (
  id            int(11) NOT NULL AUTO_INCREMENT,
  name          varchar(64) UNIQUE NOT NULL,
  description   varchar(1024),
  max_level     int(11),
  PRIMARY KEY (id)
);

INSERT INTO card_abilities (name) VALUES ('Manaflow');
INSERT INTO card_abilities (name) VALUES ('Parry');
INSERT INTO card_abilities (name) VALUES ('Last Gasp');

ALTER TABLE card_traits
ADD COLUMN card_ability_id INT(11),
ADD FOREIGN KEY (card_ability_id) REFERENCES card_abilities(id);