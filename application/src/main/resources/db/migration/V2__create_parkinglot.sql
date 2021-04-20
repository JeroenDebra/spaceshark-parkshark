SET SCHEMA 'parkshark-test';

CREATE TABLE contact_person
(
    id           SERIAL      NOT NULL PRIMARY KEY,
    name         VARCHAR(25) NOT NULL,
    gsm          VARCHAR(25),
    phone_number VARCHAR(25),
    email        VARCHAR(50) NOT NULL
);

CREATE TABLE postal_code
(
    id          SERIAL      NOT NULL PRIMARY KEY,
    pcode VARCHAR(6)  NOT NULL,
    city        VARCHAR(25) NOT NULL
);

CREATE TABLE address
(
    id            SERIAL      NOT NULL PRIMARY KEY,
    street_name   VARCHAR(50) NOT NULL,
    street_number VARCHAR(5)  NOT NULL,
    postal_code_id SERIAL NOT NULL,
    FOREIGN KEY (postal_code_id) REFERENCES postal_code(id)
);

CREATE TABLE parkinglot
(
    id           SERIAL NOT NULL PRIMARY KEY,
    name         VARCHAR(25) NOT NULL,
    category     VARCHAR(25),
    max_capacity INTEGER NOT NULL,
    address_id SERIAL NOT NULL,
    FOREIGN KEY (address_id) REFERENCES address(id),
    contact_person_id SERIAL NOT NULL,
    FOREIGN KEY (contact_person_id) REFERENCES contact_person(id)
)



