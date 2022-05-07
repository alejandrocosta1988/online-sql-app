CREATE SCHEMA onlineSQL;

USE onlineSQL;

CREATE TABLE table_users (
  user_id int NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  PRIMARY KEY (user_id)
);

INSERT INTO table_users (first_name, last_name, email) VALUES ("Alejandro", "Costa", "acosta@ichthyssystems.com");