CREATE TABLE IF NOT EXISTS admin_users (id int NOT NULL AUTO_INCREMENT, username varchar(24), password varchar(64), PRIMARY KEY(id));

CREATE TABLE IF NOT EXISTS users (id int NOT NULL AUTO_INCREMENT, username varchar(24), password varchar(64), gold int DEFAULT 0, PRIMARY KEY(id));