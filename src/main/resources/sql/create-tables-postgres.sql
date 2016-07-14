DROP TABLE IF EXISTS user_app;
DROP TABLE IF EXISTS native_language;
DROP TABLE IF EXISTS practicing_language;

CREATE TABLE app_user (
  id SERIAL PRIMARY KEY NOT NULL ,
  age int NOT NULL,
  city varchar(255) DEFAULT NULL,
  confirmed_password varchar(255) NOT NULL,
  country varchar(255) NOT NULL,
  description varchar(255) DEFAULT NULL,
  email varchar(255) NOT NULL,
  facebook_link varchar(255) DEFAULT NULL,
  first_name varchar(10) NOT NULL,
  gender varchar(255) NOT NULL,
  google_link varchar(255) DEFAULT NULL,
  instagram_link varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  linkedin_link varchar(255) DEFAULT NULL,
  password varchar(20) NOT NULL,
  role varchar(255) DEFAULT NULL,
  twitter_link varchar(255) DEFAULT NULL,
  vkontakte_link varchar(255) DEFAULT NULL
);

CREATE TABLE native_language (
  id SERIAL PRIMARY KEY NOT NULL,
  name varchar(255) DEFAULT NULL,
  user_id int DEFAULT NULL,
  FOREIGN KEY (user_id) REFERENCES app_user (id)
);

CREATE TABLE practicing_language (
  id SERIAL PRIMARY KEY NOT NULL,
  name varchar(255) DEFAULT NULL,
  user_id int DEFAULT NULL,
  FOREIGN KEY (user_id) REFERENCES app_user (id)
);

INSERT INTO app_user (first_name, last_name, email, role, password, confirmed_password, age, city, country, gender, description) VALUES ('Eugene', 'Deyneka','admin@gmail.com', 'ROLE_ADMIN', 'admin', 'admin', 23, 'Kiev', 'Ukraine', 'Male', 'London is a capital of Great Britain!');



