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
  msp_master_id INT UNSIGNED NOT NULL,
  msp_skill_id INT UNSIGNED NOT NULL,
  price INT NOT NULL,
  PRIMARY KEY (msp_master_id, msp_skill_id),
  FOREIGN KEY (msp_master_id) REFERENCES masters(id),
  FOREIGN KEY (msp_skill_id) REFERENCES skills(id)
);

CREATE TABLE master_timetable_rules (
  mtr_master_id INT UNSIGNED NOT NULL,
  workday VARCHAR (250) NOT NULL,
  startTime TIME NOT NULL,
  endTime TIME  NOT NULL,
  PRIMARY KEY (workday, mtr_master_id),
  FOREIGN KEY (mtr_master_id) REFERENCES masters(id)
);

CREATE TABLE order_statuses (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  status VARCHAR (250) NOT NULL,
  PRIMARY KEY (id)
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

INSERT INTO master_skill_prices (msp_master_id, msp_skill_id, price)
VALUES ('1', '1', '30'),
       ('1', '2', '20'),
       ('1', '3', '40'),
       ('2', '4', '55'),
       ('2', '5', '45'),
       ('3', '1', '20');

INSERT INTO master_timetable_rules (mtr_master_id, workday, startTime, endTime)
VALUES ('1', 'monday', '08:00:00', '18:00:00'),
       ('1', 'Tuesday', '07:00:00', '16:00:00'),
       ('1', 'Wednesday', '06:00:00', '15:00:00'),
       ('2', 'monday', '07:00:00', '16:30:00'),
       ('2', 'Tuesday', '10:00:00', '16:00:00'),
       ('3', 'monday', '05:00:00', '14:00:00');

INSERT INTO order_statuses (status)
VALUES ('на рассмотрении'),
       ('принят в работу'),
       ('выполнен');