SET SCHEMA 'parkshark-test';

CREATE TABLE directors(
                                    id SERIAL NOT NULL PRIMARY KEY,
                                    first_name varchar(25) NOT NULL ,
                                    last_name varchar(25) NOT NULL
);

CREATE TABLE divisions(
                                    id SERIAL NOT NULL PRIMARY KEY ,
                                    name varchar(25) NOT NULL,
                                    original_name varchar(25),
                                    director_id serial,
                                    FOREIGN KEY (director_id) references directors(id)
);
