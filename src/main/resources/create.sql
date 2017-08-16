CREATE TABLE `Account` (
  `id` int(11) NOT NULL,
  `accountNumber` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `User`(
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `UserTransaction` (
  `id`  int(11) AUTO_INCREMENT NOT NULL,
  `user_id` int(255)  DEFAULT NULL,
  `account_id` int(255) DEFAULT NULL,
  `amount` NUMBER  DEFAULT NULL,
  PRIMARY KEY (`id`)
);