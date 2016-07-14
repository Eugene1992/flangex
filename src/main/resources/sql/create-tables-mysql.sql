DROP TABLE IF EXISTS user_app;
DROP TABLE IF EXISTS native_language;
DROP TABLE IF EXISTS practicing_language;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `confirmed_password` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `facebook_link` varchar(255) DEFAULT NULL,
  `first_name` varchar(10) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `google_link` varchar(255) DEFAULT NULL,
  `instagram_link` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `linkedin_link` varchar(255) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `twitter_link` varchar(255) DEFAULT NULL,
  `vkontakte_link` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `native_language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pp794c6nrkvx2bde6s7tggqd4` (`user_id`),
  CONSTRAINT `FK_pp794c6nrkvx2bde6s7tggqd4` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);

CREATE TABLE `practicing_language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_24bc4coko35wa1hda2bbvu5cw` (`user_id`),
  CONSTRAINT `FK_24bc4coko35wa1hda2bbvu5cw` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);