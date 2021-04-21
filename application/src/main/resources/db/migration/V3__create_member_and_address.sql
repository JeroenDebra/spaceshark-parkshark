SET SCHEMA 'parkshark-test';

CREATE TABLE members(
    id serial NOT NULL PRIMARY KEY,
    firstname varchar(25) NOT NULL,
    lastname varchar(25) NOT NULL,
    phone_number varchar(25) NOT NULL,
    email varchar(35) NOT NULL,
    licence_plate varchar(25) NOT NULL,
    registration_date date NOT NULL,
    address_id serial not null,
    FOREIGN KEY (address_id) references address(id)
)
