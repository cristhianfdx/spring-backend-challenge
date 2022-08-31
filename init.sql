CREATE DATABASE IF NOT EXISTS banks;

CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `document_number` varchar(20) NOT NULL UNIQUE,
  `full_name` varchar(50) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `banks` (
  `code` varchar(255) NOT NULL UNIQUE,
  `name` varchar(50) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`code`),
  FOREIGN KEY (`user_id`) REFERENCES `users`(`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- challenge_banks.debts definition

CREATE TABLE IF NOT EXISTS `debts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `balance` decimal(19,2) NOT NULL,
  `quote_number` int(11) NOT NULL,
  `term` int(11) NOT NULL,
  `total_amount` decimal(19,2) NOT NULL,
  `bank_code` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`bank_code`) REFERENCES `banks`(`bank_code`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO users (document_number, full_name, phone_number) VALUES('123456789', 'Pedro Perez', '3001234567');
INSERT INTO banks (code, name, user_id) VALUES('B1', 'Banco Test', 1);
INSERT INTO debts (balance, quote_number, term, total_amount, bank_code, status) VALUES(166667.00, 1, 6, 200000.00, 'B1', 'OPEN');
INSERT INTO debts (balance, quote_number, term, total_amount, bank_code, status) VALUES(250000.00, 1, 2, 500000.00, 'B1', 'OPEN');
INSERT INTO debts (balance, quote_number, term, total_amount, bank_code, status) VALUES(0.00, 2, 2, 100000.00, 'B1', 'PAID');


