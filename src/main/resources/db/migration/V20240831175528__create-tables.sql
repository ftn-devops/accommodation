CREATE TABLE IF NOT EXISTS users
(
    id            INT NOT NULL PRIMARY KEY,
    first_name    VARCHAR(255),
    last_name     VARCHAR(255),
    username      VARCHAR(255),
    email         VARCHAR(255),
    address       VARCHAR(255),
    average_grade FLOAT
);


CREATE TABLE IF NOT EXISTS accommodations
(
    id               INT          NOT NULL PRIMARY KEY,
    created_at       DATE         NOT NULL,
    created_by       INT          NULL,
    updated_at       DATE         NOT NULL,
    updated_by       INT          NULL,
    name             VARCHAR(255) NOT NULL,
    address          VARCHAR(255),
    description      TEXT,
    min_guest_number INTEGER,
    max_guest_number INTEGER,
    average_grade    FLOAT,
    host_id          INTEGER      NOT NULL,

    CONSTRAINT fk_host FOREIGN KEY (host_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS accommodation_grades
(
    id               INT  NOT NULL PRIMARY KEY,
    created_at       DATE NOT NULL,
    created_by       INT  NULL,
    updated_at       DATE NOT NULL,
    updated_by       INT  NULL,
    grade            INT,
    reviewer_id      INT  NOT NULL,
    accommodation_id INT  NOT NULL,
    FOREIGN KEY (reviewer_id) REFERENCES users (id),
    FOREIGN KEY (accommodation_id) REFERENCES accommodations (id)
);

CREATE TABLE IF NOT EXISTS availabilities
(
    id                  INT     NOT NULL PRIMARY KEY,
    created_at          DATE    NOT NULL,
    created_by          INT     NULL,
    updated_at          DATE    NOT NULL,
    updated_by          INT     NULL,
    start_date          DATE    NOT NULL,
    end_date            DATE    NOT NULL,
    price               FLOAT,
    is_price_for_person BOOLEAN,
    auto_confirm        BOOLEAN,
    accommodation_id    INTEGER NOT NULL,

    CONSTRAINT fk_accommodation FOREIGN KEY (accommodation_id) REFERENCES accommodations (id)
);

CREATE TABLE IF NOT EXISTS reservation
(
    id                 INT          NOT NULL PRIMARY KEY,
    created_at         DATE         NOT NULL,
    created_by         INT          NULL,
    updated_at         DATE         NOT NULL,
    updated_by         INT          NULL,
    start_date         DATE         NOT NULL,
    end_date           DATE         NOT NULL,
    price              FLOAT,
    number_of_persons  INTEGER,
    reservation_status VARCHAR(255) NOT NULL,
    user_id            INTEGER      NOT NULL,
    accommodation_id   INTEGER      NOT NULL,

    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_accommodation FOREIGN KEY (accommodation_id) REFERENCES accommodations (id)
);

CREATE TABLE IF NOT EXISTS images
(
    id               INT          NOT NULL PRIMARY KEY,
    created_at       DATE         NOT NULL,
    created_by       INT          NULL,
    updated_at       DATE         NOT NULL,
    updated_by       INT          NULL,
    path             VARCHAR(255) NOT NULL,
    accommodation_id INTEGER      NOT NULL,

    CONSTRAINT fk_accommodation FOREIGN KEY (accommodation_id) REFERENCES accommodations (id)
);

