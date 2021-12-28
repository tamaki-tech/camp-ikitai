CREATE TABLE person (
    id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    ${commonColumns},
    CONSTRAINT person_pk PRIMARY KEY (id)
);


CREATE TABLE person_relation (
    self_id INT NOT NULL,
    other_id INT NOT NULL,
    relation_type CHAR(1),
    ${commonColumns},
    CONSTRAINT person_relation_pk PRIMARY KEY (self_id, other_id),
    CONSTRAINT person_fk FOREIGN KEY (self_id) REFERENCES person(id),
    CONSTRAINT person_other_fk FOREIGN KEY (other_id) REFERENCES person(id)
);


CREATE TABLE person_address (
    person_id INT NOT NULL,
    serial_num INT NOT NULL,
    postal_cd CHAR(7),
    city VARCHAR(100),
    ${commonColumns},
    CONSTRAINT person_address_pk PRIMARY KEY (person_id, serial_num),
    CONSTRAINT person_address_fk FOREIGN KEY (person_id) REFERENCES person(id)
);

CREATE TABLE site_type (
    id INT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    display_name varchar(30),
    ${commonColumns}
);

CREATE TABLE prefecture (
    id INT PRIMARY KEY,
    name varchar (30),
    display_name varchar(30),
    ${commonColumns}
);

CREATE TABLE camp_site (
    id INT PRIMARY KEY,
    site_type_id INT REFERENCES site_type,
    site_name varchar(200),
    addition varchar(1000),
    prefecture_id INT REFERENCES prefecture,
    access varchar(100),
    phone_number varchar(30),
    url varchar(100),
    price varchar(200),
    image_path varchar(100),
    latitude varchar(30),
    longitude varchar(30),
    ${commonColumns}
);

CREATE TABLE facility (
    id INT PRIMARY KEY,
    name varchar(30),
    display_name varchar(30),
    ${commonColumns}
);

CREATE TABLE camp_site_facility_rel (
    camp_site_id INT REFERENCES camp_site,
    facility_id INT REFERENCES facility,
    ${commonColumns},
    PRIMARY KEY(camp_site_id, facility_id)
);
