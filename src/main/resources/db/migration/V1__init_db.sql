CREATE TABLE clients (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR (50) NOT NULL,
  surname VARCHAR (50) NOT NULL,
  email VARCHAR (50) NOT NULL,
  phone VARCHAR (50) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE masters (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR (50) NOT NULL,
  surname VARCHAR (50) NOT NULL,
  email VARCHAR (50) NOT NULL,
  phone VARCHAR (50) NOT NULL,
  nickname VARCHAR (50) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE skills (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  title VARCHAR (250) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE master_skill_prices (
  master_id INT UNSIGNED NOT NULL,
  skill_id INT UNSIGNED NOT NULL,
  price INT NOT NULL,
  PRIMARY KEY (master_id, skill_id),
  FOREIGN KEY (master_id) REFERENCES masters(id),
  FOREIGN KEY (skill_id) REFERENCES skills(id)
);

INSERT INTO clients (name, surname, email, phone)
VALUES ('Anton', 'Dmitruk', 'Dmi3uk@gmail.com', '+375(29)1655556'),
       ('Yury', 'Klimchuk', 'Klimchuk@gmail.com', '+375(29)1111111'),
       ('Vova', 'Gluhovskij', 'Gluhovskij@gmail.com', '+375(29)2222222');

INSERT INTO masters (name, surname, email, phone, nickName)
VALUES ('Katrin', 'Dmitruk', 'dmitrukate@gmail.com', '+375(29)1111111', 'Katrin'),
       ('Olga', 'Vasichkina', 'Vasichkina@gmail.com', '+375(29)2222222', 'Vasija'),
       ('Diana', 'Monija', 'Monija@gmail.com', '+375(29)3333333', 'Di');

INSERT INTO skills (title)
VALUES ('Окрашивание бровей'),
       ('Коррекция бровей'),
       ('Коррекция и окрашивание бровей'),
       ('Долговременная укладка бровей'),
       ('Боттокс бровей');

INSERT INTO master_skill_prices (master_id, skill_id, price)
VALUES ('1', '1', '30'),
       ('1', '2', '20'),
       ('1', '3', '40'),
       ('2', '4', '55'),
       ('2', '5', '45'),
       ('3', '1', '20');