CREATE TABLE Customer(
  id CHAR(33) PRIMARY KEY ,
  name VARCHAR(19) not NULL ,
  sex VARCHAR(6) NOT NULL ,
  birthday VARCHAR(12),
  phoneNumber CHAR(15) NOT NULL ,
  email VARCHAR(40),
  description VARCHAR(200),
  isDelete INT NOT NULL DEFAULT 0
);

INSERT  INTO Customer(id, name, sex, birthday, phoneNumber, email, description)
              VALUES('1324','1213','male','19960512','15012347896','123456789@99.com','no');

SELECT name FROM Customer WHERE id='1324';

UPDATE Customer SET isDelete = 1 WHERE 1=1 AND
