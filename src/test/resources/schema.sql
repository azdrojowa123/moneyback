CREATE TABLE loans (
 id INTEGER PRIMARY KEY AUTO_INCREMENT,
 from_who varchar(33) NOT NULL,
 for_who varchar(20) NOT NULL,
 how_much int DEFAULT NULL,
 date_loan date NOT NULL,
 description varchar(150) DEFAULT NULL,);
