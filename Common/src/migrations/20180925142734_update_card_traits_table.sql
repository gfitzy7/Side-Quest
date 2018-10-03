ALTER TABLE card_traits
CHANGE parent_id card_id INT(11),
DROP COLUMN parent_type;