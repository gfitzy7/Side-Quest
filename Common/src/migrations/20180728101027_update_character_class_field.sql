ALTER TABLE character_cards
DROP COLUMN class,
ADD COLUMN class_id INT(11) NOT NULL,
ADD FOREIGN KEY (class_id) REFERENCES classes(id);