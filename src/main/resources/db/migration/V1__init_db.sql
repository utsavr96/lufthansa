CREATE TABLE bookings
(
    id              BINARY(16) NOT NULL,
    booking_time    datetime   NULL,
    number_of_seats INT        NOT NULL,
    total_price     DOUBLE     NOT NULL,
    flight_id       BINARY(16) NULL,
    user_id         BINARY(16) NULL,
    CONSTRAINT pk_bookings PRIMARY KEY (id)
);

CREATE TABLE flights
(
    id              BINARY(16)   NOT NULL,
    flight_number   VARCHAR(255) NULL,
    origin          VARCHAR(255) NULL,
    destination     VARCHAR(255) NULL,
    departure_time  datetime     NULL,
    arrival_time    datetime     NULL,
    available_seats INT          NOT NULL,
    CONSTRAINT pk_flights PRIMARY KEY (id)
);

CREATE TABLE users
(
    id           BINARY(16)   NOT NULL,
    email        VARCHAR(255) NULL,
    password     VARCHAR(255) NULL,
    nationality  VARCHAR(255) NULL,
    address      VARCHAR(255) NULL,
    phone_number VARCHAR(255) NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE users
    ADD CONSTRAINT uc_users_phone_number UNIQUE (phone_number);

ALTER TABLE bookings
    ADD CONSTRAINT FK_BOOKINGS_ON_FLIGHT FOREIGN KEY (flight_id) REFERENCES flights (id);

ALTER TABLE bookings
    ADD CONSTRAINT FK_BOOKINGS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);