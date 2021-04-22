SET SCHEMA 'parkshark-test';

CREATE TABLE parking_spot(
    id SERIAL NOT NULL PRIMARY KEY,
    member_id SERIAL NOT NULL,
    parkinglot_id SERIAL NOT NULL ,
    FOREIGN KEY (parkinglot_id) REFERENCES parkinglot(id),
    FOREIGN KEY (member_id) REFERENCES members(id)
)