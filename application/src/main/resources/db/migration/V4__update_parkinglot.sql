SET SCHEMA 'parkshark-test';

ALTER TABLE parkinglot
    ADD price_per_hour money;

ALTER TABLE parkinglot
    ADD currency VARCHAR (3);





