drop database proyectoungs;
create database proyectoUngs;
use proyectoUngs;

drop table person;
CREATE TABLE person (
    ID int NOT NULL auto_increment,
    age int NOT NULL,
    dni int NOT NULL,
    name varchar(255)NOT NULL,
    lastname varchar(255)NOT NULL,
    PRIMARY KEY (ID)
);

drop table car;
CREATE TABLE car (
    ID int NOT NULL auto_increment,
    name varchar(255) NOT NULL,
    brand varchar(255)NOT NULL,
    year int NOT NULL,
    PRIMARY KEY (ID)
);

INSERT INTO person (age, dni, name, lastname)
VALUES 
   (25, 37993831, "Nicolas", "Cabral"),
   (23, 39407469, "Jazmin", "Baez"),
   (50, 16112028, "Mario", "Cabral");
   
INSERT INTO car (name,brand,year)
VALUES 
   ("Onix", "Chevrolet", 2020),
   ("Hilux", "Toyota", 2019);


select * from car;
select * from person;