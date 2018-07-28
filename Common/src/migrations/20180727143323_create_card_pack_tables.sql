CREATE TABLE IF NOT EXISTS card_packs (
  id            int(11) NOT NULL AUTO_INCREMENT,
  name          varchar(64) NOT NULL,
  description   varchar(1024),
  card_set_id   int(11) NOT NULL,
  cost          int(11) NOT NULL DEFAULT 50,
  num_cards     int(11) NOT NULL DEFAULT 8,
  PRIMARY KEY (id),
  FOREIGN KEY (card_set_id) REFERENCES card_sets(id)
);

CREATE TABLE IF NOT EXISTS rarities (
  id          int(11) NOT NULL AUTO_INCREMENT,
  name        varchar(32) NOT NULL,
  priority    int(11) NOT NULL UNIQUE,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS pack_configs (
  id          int(11) NOT NULL AUTO_INCREMENT,
  pack_id     int(11) NOT NULL,
  rarity_id   int(11) NOT NULL,
  num         int(11) NOT NULL,
  frequency   int(11) NOT NULL DEFAULT 100,
  PRIMARY KEY (id),
  FOREIGN KEY (pack_id) REFERENCES card_packs(id),
  FOREIGN KEY (rarity_id) REFERENCES rarities(id)
);