CREATE TABLE app_user (
  id SERIAL PRIMARY KEY,
  age int NOT NULL,
  city varchar(255) DEFAULT NULL,
  confirmed_password varchar(255) NOT NULL,
  country varchar(255) NOT NULL,
  description varchar(255) DEFAULT NULL,
  email varchar(255) NOT NULL UNIQUE,
  facebook_link varchar(255) DEFAULT NULL,
  first_name varchar(10) NOT NULL,
  gender varchar(255) NOT NULL,
  google_link varchar(255) DEFAULT NULL,
  instagram_link varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  linkedin_link varchar(255) DEFAULT NULL,
  password varchar(255) NOT NULL,
  role varchar(255) DEFAULT NULL,
  twitter_link varchar(255) DEFAULT NULL,
  vkontakte_link varchar(255) DEFAULT NULL
);

CREATE TABLE native_language (
  id SERIAL PRIMARY KEY,
  name varchar(255) DEFAULT NULL,
  user_id int DEFAULT NULL,
  FOREIGN KEY (user_id) REFERENCES app_user (id)
);

CREATE TABLE practicing_language (
  id SERIAL PRIMARY KEY,
  name varchar(255) DEFAULT NULL,
  user_id int DEFAULT NULL,
  FOREIGN KEY (user_id) REFERENCES app_user (id)
);

