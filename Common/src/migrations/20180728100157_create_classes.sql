CREATE TABLE IF NOT EXISTS classes (
  id      INT(11) NOT NULL AUTO_INCREMENT,
  name    VARCHAR(64) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO classes (name) VALUES ('Archon');

INSERT INTO classes (name) VALUES ('Assassin');

INSERT INTO classes (name) VALUES ('Samurai');

INSERT INTO classes (name) VALUES ('Elementalist');

INSERT INTO classes (name) VALUES ('Thaumaturge');

INSERT INTO classes (name) VALUES ('Sage');