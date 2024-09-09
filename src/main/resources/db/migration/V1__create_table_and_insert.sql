CREATE TABLE person (
    id             DECIMAL      NOT NULL,
    first_name      VARCHAR(50)  NOT NULL,
    last_name       VARCHAR(50)  NOT NULL,
    date_of_birth  DATE,
    place_of_birth VARCHAR(50),
    CONSTRAINT person_pk PRIMARY KEY (id)
);
CREATE TABLE contact (
    id             DECIMAL      NOT NULL,
    person_id      DECIMAL      NOT NULL,
    contact_type   VARCHAR(25)  DEFAULT 'email' NOT NULL,
    contact_value  VARCHAR(50)  NOT NULL,
    CONSTRAINT contact_pk PRIMARY KEY (id),
    CONSTRAINT contact_fk FOREIGN KEY (person_id) REFERENCES person(id),
    CONSTRAINT contact_check CHECK (contact_type IN ('fixed line', 'mobile', 'email', 'icq', 'skype', 'email'))
);
INSERT INTO person VALUES (1,  'Larry',  'Goldstein', DATE'1970-11-20', 'Dallas');
INSERT INTO person VALUES (2,  'Tom',    'Burton',    DATE'1977-01-22', 'Birmingham');
INSERT INTO person VALUES (3,  'Lisa',   'Hamilton',  DATE'1975-12-23', 'Richland');
INSERT INTO person VALUES (4,  'Kim',    'Goldstein', DATE'2011-06-01', 'Shanghai');
INSERT INTO person VALUES (5,  'James',  'de Winter', DATE'1975-12-23', 'San Francisco');
INSERT INTO person VALUES (6,  'Elias',  'Baker',     DATE'1939-10-03', 'San Francisco');
INSERT INTO person VALUES (7,  'Yorgos', 'Stefanos',  DATE'1975-12-23', 'Athens');
INSERT INTO person VALUES (8,  'John',   'de Winter', DATE'1977-01-22', 'San Francisco');
INSERT INTO person VALUES (9,  'Richie', 'Rich',      DATE'1975-12-23', 'Richland');
INSERT INTO person VALUES (10, 'Victor', 'de Winter', DATE'1979-02-28', 'San Francisco');

INSERT INTO contact VALUES (1,  1,  'fixed line', '555-0100');
INSERT INTO contact VALUES (2,  1,  'email',      'larry.goldstein@acme.xx');
INSERT INTO contact VALUES (3,  1,  'email',      'lg@my_company.xx');
INSERT INTO contact VALUES (4,  1,  'icq',        '12111');
INSERT INTO contact VALUES (5,  4,  'fixed line', '5550101');
INSERT INTO contact VALUES (6,  4,  'mobile',     '10123444444');
INSERT INTO contact VALUES (7,  5,  'email',      'james.dewinter@acme.xx');
INSERT INTO contact VALUES (8,  7,  'fixed line', '+30000000000000');
INSERT INTO contact VALUES (9,  7,  'mobile',     '+30695100000000');
