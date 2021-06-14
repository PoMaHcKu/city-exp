CREATE TABLE IF NOT EXISTS CITY
(
    ID NUMBER PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS PLACE
(
    ID NUMBER PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR NOT NULL,
    FK_CITY NUMBER REFERENCES CITY (ID)
);

CREATE TABLE IF NOT EXISTS FACT
(
    ID NUMBER PRIMARY KEY AUTO_INCREMENT,
    TEXT VARCHAR NOT NULL,
    FK_PLACE NUMBER REFERENCES PLACE (ID)
);