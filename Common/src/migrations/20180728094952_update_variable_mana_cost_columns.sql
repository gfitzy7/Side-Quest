ALTER TABLE gambit_cards
CHANGE variable_mana_cost use_variable_mana_cost TINYINT(1),
CHANGE variable_mana_cost_interval variable_mana_cost INT(11);