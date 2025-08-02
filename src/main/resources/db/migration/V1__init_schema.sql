-- ===========================
-- 1. USERS
-- ===========================
CREATE TABLE USERS (
                       id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       age INT,
                       address VARCHAR(255),
                       gender VARCHAR(20),
                       mobile_no VARCHAR(20),
                       email_id VARCHAR(255) UNIQUE,
                       password VARCHAR(255),
                       role VARCHAR(100)
);

-- ===========================
-- 2. THEATERS
-- ===========================
CREATE TABLE THEATERS (
                          id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                          name VARCHAR(255),
                          address VARCHAR(255) UNIQUE
);

-- ===========================
-- 3. MOVIES
-- ===========================
CREATE TABLE MOVIES (
                        id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                        movie_name VARCHAR(255) NOT NULL,
                        duration INT,
                        rating NUMERIC(4,2),
                        release_date DATE,
                        genre VARCHAR(50),
                        language VARCHAR(50)
);

-- ===========================
-- 4. SHOWS
-- ===========================
CREATE TABLE SHOWS (
                       show_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       time TIME,
                       date DATE,
                       movie_id INT,
                       theater_id INT,
                       CONSTRAINT fk_show_movie FOREIGN KEY (movie_id) REFERENCES MOVIES(id),
                       CONSTRAINT fk_show_theater FOREIGN KEY (theater_id) REFERENCES THEATERS(id)
);

-- ===========================
-- 5. THEATER_SEATS
-- ===========================
CREATE TABLE THEATER_SEATS (
                               id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                               seat_no VARCHAR(20),
                               seat_type VARCHAR(50),
                               theater_id INT,
                               CONSTRAINT fk_theaterseat_theater FOREIGN KEY (theater_id) REFERENCES THEATERS(id)
);

-- ===========================
-- 6. SHOW_SEATS
-- ===========================
CREATE TABLE SHOW_SEATS (
                            id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                            seat_no VARCHAR(20),
                            seat_type VARCHAR(50),
                            price INT,
                            is_available BOOLEAN,
                            is_food_contains BOOLEAN,
                            show_id INT,
                            CONSTRAINT fk_showseat_show FOREIGN KEY (show_id) REFERENCES SHOWS(show_id)
);

-- ===========================
-- 7. TICKETS
-- ===========================
CREATE TABLE TICKETS (
                         ticket_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                         total_tickets_price INT,
                         booked_seats VARCHAR(255),
                         booked_at DATE DEFAULT CURRENT_DATE,
                         show_id INT,
                         user_id INT,
                         CONSTRAINT fk_ticket_show FOREIGN KEY (show_id) REFERENCES SHOWS(show_id),
                         CONSTRAINT fk_ticket_user FOREIGN KEY (user_id) REFERENCES USERS(id)
);

INSERT INTO USERS (name, age, address, gender, mobile_no, email_id, password, role)
VALUES
    ('Alice Johnson', 28, 'Almaty, Kazakhstan', 'FEMALE', '87001234567', 'alice@mail.com', 'password123', 'ROLE_USER'),
    ('Bob Smith', 35, 'Astana, Kazakhstan', 'MALE', '87007654321', 'bob@mail.com', 'password456', 'ROLE_ADMIN');

INSERT INTO THEATERS (name, address)
VALUES
    ('Cinema Plaza', 'Abay Avenue 45'),
    ('Mega Cinema', 'Satpayev Street 12');

INSERT INTO MOVIES (movie_name, duration, rating, release_date, genre, language)
VALUES
    ('Inception', 148, 8.8, '2010-07-16', 'COMEDY', 'ENGLISH'),
    ('Avatar', 162, 7.9, '2009-12-18', 'ACTION', 'ENGLISH');

INSERT INTO SHOWS (time, date, movie_id, theater_id)
VALUES
    ('18:30', '2025-07-15', 1, 1),
    ('21:00', '2025-07-15', 2, 2);

INSERT INTO THEATER_SEATS (seat_no, seat_type, theater_id)
VALUES
    ('A1', 'PREMIUM', 1),
    ('A2', 'STANDARD', 1),
    ('B1', 'STANDARD', 2),
    ('B2', 'PREMIUM', 2);

INSERT INTO SHOW_SEATS (seat_no, seat_type, price, is_available, is_food_contains, show_id)
VALUES
    ('A1', 'PREMIUM', 2500, TRUE, TRUE, 1),
    ('A2', 'STANDARD', 1800, TRUE, FALSE, 1),
    ('B1', 'STANDARD', 2000, TRUE, FALSE, 2),
    ('B2', 'PREMIUM', 2800, FALSE, TRUE, 2);

INSERT INTO TICKETS (total_tickets_price, booked_seats, booked_at, show_id, user_id)
VALUES
    (4300, 'A1,A2', '2025-07-12', 1, 1),
    (2800, 'B2', '2025-07-12', 2, 2);
