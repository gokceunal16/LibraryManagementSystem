-- genres
create table genres
(
    id          serial
        constraint genres_pk
            primary key,
    name        varchar not null,
    description varchar
);

create unique index genres_name_uindex
    on genres (name);


-- users
create table users
(
    id          serial
        constraint users_pk
            primary key,
    created_at  timestamp with time zone not null,
    updated_at  timestamp with time zone not null,
    deleted_at  timestamp with time zone,
    first_name  varchar                  not null,
    last_name   varchar                  not null,
    email       varchar                  not null,
    password    varchar                  not null,
    phone       varchar                  not null,
    city        varchar                  not null,
    street      varchar                  not null,
    postal_code int                      not null,
    role_id     int                      not null

);

create unique index users_email_uindex
    on users (email);

create unique index users_phone_uindex
    on users (phone);


-- user_roles
create table user_roles
(
    id   serial
        constraint user_roles_pk
            primary key,
    name varchar not null
);


-- time_slots
create table time_slots
(
    id         serial
        constraint time_slots_pk
            primary key,
    start_time time not null,
    end_time   time not null
);


-- rooms
create table rooms
(
    id       serial
        constraint rooms_pk
            primary key,
    name     varchar not null,
    capacity int     not null,
    location varchar not null
);

create unique index rooms_name_uindex
    on rooms (name);


-- reservations
create table reservations
(
    id           serial
        constraint reservations_pk
            primary key,
    created_at   timestamp with time zone not null,
    updated_at   timestamp with time zone not null,
    deleted_at   timestamp with time zone,
    user_id      int                      not null,
    time_slot_id int                      not null,
    room_id      int                      not null,
    date         date
);

create index reservations_date_index
    on reservations (date);

create unique index reservations_room_id_time_slot_id_date_uindex
    on reservations (room_id, time_slot_id, date);

create index reservations_user_id_index
    on reservations (user_id);


-- publication_available_notification_requests
create table publication_available_notification_requests
(
    user_id        int not null,
    publication_id int not null
);

create unique index publication_available_notification_requests_publication_id_user
    on publication_available_notification_requests (publication_id, user_id);


-- borrowings
create table borrowings
(
    id             serial
        constraint borrowings_pk
            primary key,
    user_id        int                      not null,
    publication_id int                      not null,
    loan_date      timestamp with time zone not null,
    return_date    timestamp with time zone
);

create index borrowings_user_id_index
    on borrowings (user_id);

create index borrowings_publication_id_index
    on borrowings (publication_id);

create unique index borrowings_publication_id_uindex
    on borrowings (publication_id)
    where (return_date IS NULL);

-- ratings
create table ratings
(
    user_id        int not null,
    publication_id int not null,
    score          int,
    date           timestamptz
);

create index ratings_publication_id_index
    on ratings (publication_id);

create unique index ratings_user_id_publication_id_uindex
    on ratings (user_id, publication_id);


-- reviews
create table reviews
(
    id             serial
        constraint reviews_pk
            primary key,
    created_at     timestamp with time zone not null,
    updated_at     timestamp with time zone not null,
    deleted_at     timestamp with time zone,
    user_id        int                      not null,
    publication_id int                      not null,
    comment        varchar                  not null
);

create index reviews_publication_id_index
    on reviews (publication_id);


-- languages
create table languages
(
    id   serial
        constraint languages_pk
            primary key,
    name varchar not null
);

create unique index languages_name_uindex
    on languages (name);


-- publications
create table publications
(
    id           serial
        constraint publications_pk
            primary key,
    title        varchar not null,
    genre_id     int     not null,
    publisher_id int     not null,
    language_id  int     not null,
    translator   varchar,
    publish_date date,
    description  varchar
);

alter table publications
    add image_name varchar;

alter table publications
    add image_name varchar;

create index publications_genre_id_index
    on publications (genre_id);

create index publications_language_id_index
    on publications (language_id);

create index publications_publisher_id_index
    on publications (publisher_id);

create index publications_title_index
    on publications (title);


-- publishers
create table publishers
(
    id            serial
        constraint publishers_pk
            primary key,
    name          varchar not null,
    local_address varchar,
    city          varchar,
    country       varchar,
    phone         varchar,
    email         varchar
);

create unique index publishers_email_uindex
    on publishers (email);

create unique index publishers_phone_uindex
    on publishers (phone);


-- physical_publications
create table physical_publications
(
    id             serial
        constraint physical_publications_pk
            primary key,
    floor_number   int not null,
    section_number int not null,
    shelf_number   int not null,
    publication_id int not null
);

create unique index physical_publications_publication_id_uindex
    on physical_publications (publication_id);


-- electronic_publications
create table electronic_publications
(
    id             serial
        constraint electronic_publications_pk
            primary key,
    link           varchar,
    size           int,
    publication_id int not null
);

create unique index electronic_publications_publication_id_uindex
    on electronic_publications (publication_id);


-- materials
create table materials
(
    id                      serial
        constraint materials_pk
            primary key,
    physical_publication_id int not null,
    format                  varchar
);

create unique index materials_physical_publication_id_uindex
    on materials (physical_publication_id);


-- newspapers
create table newspapers
(
    id                      serial
        constraint newspapers_pk
            primary key,
    physical_publication_id int not null,
    publication_frequency   varchar,
    circulation             varchar
);

create unique index newspapers_physical_publication_id_uindex
    on newspapers (physical_publication_id);


-- physical_books
create table physical_books
(
    id                      serial
        constraint physical_books_pk
            primary key,
    physical_publication_id int not null,
    book_origin_id          int not null,
    page_number             int
);

create index physical_books_book_origin_id_index
    on physical_books (book_origin_id);

create unique index physical_books_physical_publication_id_uindex
    on physical_books (physical_publication_id);


-- audio_books
create table audio_books
(
    id                        serial
        constraint audio_books_pk
            primary key,
    electronic_publication_id int not null,
    book_origin_id            int not null,
    narrator                  varchar,
    duration                  int
);

create index audio_books_book_origin_id_index
    on audio_books (book_origin_id);

create unique index audio_books_electronic_publication_id_uindex
    on audio_books (electronic_publication_id);


-- e_books
create table e_books
(
    id                        serial
        constraint e_books_pk
            primary key,
    electronic_publication_id int not null,
    book_origin_id            int not null
);

create index e_books_book_origin_id_index
    on e_books (book_origin_id);

create unique index e_books_electronic_publication_id_uindex
    on e_books (electronic_publication_id);


-- book_origins
create table book_origins
(
    id        serial
        constraint book_origins_pk
            primary key,
    author_id int,
    name      varchar not null
);

create index book_origins_name_index
    on book_origins (name);


-- authors
create table authors
(
    id            serial
        constraint authors_pk
            primary key,
    first_name    varchar not null,
    last_name     varchar,
    date_of_birth date,
    nationality   varchar,
    biography     varchar
);

-- INSERT PROCEDURES
-- time_slots
CREATE PROCEDURE fill_time_slots()
    language plpgsql
AS
$$
BEGIN
    INSERT INTO time_slots (start_time, end_time)
    SELECT date_trunc('hour', generate_series)::time                     AS start_time,
           date_trunc('hour', generate_series)::time + interval '1 hour' AS end_time
    FROM generate_series('2023-04-22 00:00:00'::timestamp, '2023-04-22 23:59:00'::timestamp,
                         '1 hour') AS generate_series;
END;
$$;


-- insert user
CREATE PROCEDURE insert_user(_first_name varchar, _last_name varchar, _email varchar, _password varchar,
                             _phone varchar, _city varchar, _street varchar, _postal_code int, _role_id int)
    language plpgsql
AS
$$
BEGIN
    INSERT INTO users (created_at, updated_at, first_name, last_name, email, password, phone, city, street, postal_code, role_id)
    VALUES (NOW(), NOW(), _first_name, _last_name, _email, _password, _phone, _city, _street, _postal_code, _role_id);
END;
$$;


-- insert user_role
CREATE PROCEDURE insert_user_role(_name varchar)
    language plpgsql
AS
$$
BEGIN
    INSERT INTO user_roles (name)
    VALUES (_name);
END;
$$;

-- insert room
CREATE PROCEDURE insert_room(_name varchar, _capacity int, _location int)
    language plpgsql
AS
$$
BEGIN
    INSERT INTO rooms (name, capacity, location)
    VALUES (_name, _capacity, _location);
END;
$$;


-- insert review
CREATE PROCEDURE insert_review(_user_id int, _publication_id int, _comment varchar)
    language plpgsql
AS
$$
BEGIN
    INSERT INTO reviews (created_at, updated_at, user_id, publication_id, comment)
    VALUES (NOW(), NOW(), _user_id, _publication_id, _comment);
END;
$$;


-- insert reservation
CREATE PROCEDURE insert_reservation(_user_id int, _time_slot_id int, _room_id int, _date text)
    language plpgsql
AS
$$
BEGIN
    INSERT INTO reservations (created_at, updated_at, user_id, time_slot_id, room_id, date)
    VALUES (NOW(), NOW(), _user_id, _time_slot_id, _room_id, _date::date);
END;
$$;

-- insert rating
CREATE PROCEDURE insert_rating(_user_id int, _publication_id int, _score int, _date text)
    language plpgsql
AS
$$
BEGIN
    INSERT INTO ratings (user_id, publication_id, score, date)
    VALUES (_user_id, _publication_id, _score, _date::date);
END;
$$;

-- insert publisher
CREATE PROCEDURE insert_publisher(_name varchar, _local_address varchar, _city varchar, _country varchar,
                                  _phone varchar, _email varchar)
    language plpgsql
AS
$$
BEGIN
    INSERT INTO publishers (name, local_address, city, country, phone, email)
    VALUES (_name, _local_address, _city, _country, _phone, _email);
END;
$$;


-- insert publication
CREATE PROCEDURE insert_publication(_title varchar, _genre_id int, _publisher_id int, _language_id int,
                                    _translator varchar, _publish_date text, _description varchar)
    language plpgsql
AS
$$
BEGIN
    INSERT INTO publications (title, genre_id, publisher_id, language_id, translator, publish_date, description)
    VALUES (_title, _genre_id, _publisher_id, _language_id, _translator, _publish_date::date, _description);
END;
$$;


--insert audio_book
CREATE PROCEDURE insert_audio_book(_electronic_publication_id int, _book_origin_id int, _narrator varchar,
                                   _duration int)
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO audio_books (electronic_publication_id, book_origin_id, narrator, duration)
    VALUES (_electronic_publication_id, _book_origin_id, _narrator, _duration);
END;
$$;

--insert authors
CREATE PROCEDURE insert_author(_first_name varchar, _last_name varchar, _date_of_birth text, _nationality varchar,
                               _biography varchar)
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO authors (first_name, last_name, date_of_birth, nationality, biography)
    VALUES (_first_name, _last_name, _date_of_birth::date, _nationality, _biography);
END;
$$;

--insert book_origins
CREATE PROCEDURE insert_book_origin(_author_id int, _name varchar)
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO book_origins (author_id, name)
    VALUES (_author_id, _name);
END;
$$;

--insert borrowings
CREATE PROCEDURE insert_borrowing(_user_id int, _publication_id int, _loan_date text, _return_date text)
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO borrowings (user_id, publication_id, loan_date, return_date)
    VALUES (_user_id, _publication_id, _loan_date::timestamptz, _return_date::timestamptz);
END;
$$;

--insert e_books
CREATE PROCEDURE insert_e_book(_electronic_publication_id int, _book_origin_id int)
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO e_books (electronic_publication_id, book_origin_id)
    VALUES (_electronic_publication_id, _book_origin_id);
END;
$$;

-- insert procedure for electronic_publications
CREATE PROCEDURE insert_electronic_publication(_link varchar, _size int, _publication_id int)
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO electronic_publications (link, size, publication_id)
    VALUES (_link, _size, _publication_id);
END;
$$;

-- insert procedure for genres
CREATE PROCEDURE insert_genre(_name varchar, _description varchar)
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO genres (name, description)
    VALUES (_name, _description);
END;
$$;

-- insert procedure for languages
CREATE PROCEDURE insert_language(_name varchar)
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO languages (name)
    VALUES (_name);
END;
$$;

-- insert procedure for materials
CREATE PROCEDURE insert_material(_physical_publication_id int, _format varchar)
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO materials (physical_publication_id, format)
    VALUES (_physical_publication_id, _format);
END;
$$;

-- insert procedure for newspapers
CREATE PROCEDURE insert_newspaper(_physical_publication_id int, _publication_frequency varchar, _circulation varchar)
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO newspapers (physical_publication_id, publication_frequency, circulation)
    VALUES (_physical_publication_id, _publication_frequency, _circulation);
END;
$$;

-- insert procedure for physical_books
CREATE PROCEDURE insert_physical_book(_physical_publication_id int, _book_origin_id int, _page_number int)
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO physical_books (physical_publication_id, book_origin_id, page_number)
    VALUES (_physical_publication_id, _book_origin_id, _page_number);
END;
$$;

-- insert physical_publications
CREATE PROCEDURE insert_physical_publication(_floor_number int, _section_number int, _shelf_number int,
                                             _publication_id int)
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO physical_publications (floor_number, section_number, shelf_number, publication_id)
    VALUES (_floor_number, _section_number, _shelf_number, _publication_id);
END;
$$;

-- insert publication_available_notification_requests
CREATE PROCEDURE insert_notification_request(
    _user_id int,
    _publication_id int
)
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO publication_available_notification_requests(user_id, publication_id)
    VALUES (_user_id, _publication_id);
END;
$$;


-- UPDATE PROCEDURES
-- update user
CREATE PROCEDURE update_user(_id int, _first_name varchar, _last_name varchar, _email varchar, _password varchar,
                             _phone varchar, _city varchar, _street varchar, _postal_code int, _role_id int)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE users
    SET updated_at  = NOW(),
        first_name  = COALESCE(_first_name, first_name),
        last_name   = COALESCE(_last_name, last_name),
        email       = COALESCE(_email, email),
        password    = COALESCE(_password, password),
        phone       = COALESCE(_phone, phone),
        city        = COALESCE(_city, city),
        street      = COALESCE(_street, street),
        postal_code = COALESCE(_postal_code, postal_code),
        role_id     = COALESCE(_role_id, role_id)
    WHERE id = _id;
END;
$$;


-- update user_role
CREATE PROCEDURE update_user_role(_id int, _name varchar)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE user_roles
    SET name = _name
    WHERE id = _id;
END;
$$;


-- update room
CREATE PROCEDURE update_room(_id int, _name varchar, _capacity int, _location varchar)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE rooms
    SET name     = COALESCE(_name, name),
        capacity = COALESCE(_capacity, capacity)
    WHERE id = _id;
END;
$$;


-- update review
CREATE PROCEDURE update_review(_id int, _comment varchar)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE reviews
    SET updated_at = NOW(),
        comment    = _comment
    WHERE id = _id;
END;
$$;


-- update reservation
CREATE PROCEDURE update_reservation(_id int, _time_slot_id int, _room_id int, _date text)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE reservations
    SET updated_at   = NOW(),
        time_slot_id = COALESCE(_time_slot_id, time_slot_id),
        room_id      = COALESCE(_room_id, room_id),
        date         = COALESCE(_date, date)::date
    WHERE id = _id;
END;
$$;



-- update rating
CREATE PROCEDURE update_rating(_user_id int, _publication_id int, _score int)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE ratings
    SET date   = NOW(),
        score = _score
    WHERE user_id = _user_id AND publication_id = _publication_id;
END;
$$;


-- update publisher
CREATE PROCEDURE update_publisher(_id int, _name varchar, _local_address varchar, _city varchar, _country varchar, _phone varchar, _email varchar)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE publishers
    SET name = COALESCE(_name, name),
        local_address = COALESCE(_local_address, local_address),
        city = COALESCE(_city, city),
        country = COALESCE(_country, country),
        phone = COALESCE(_phone, phone),
        email = COALESCE(_email, email)
    WHERE id = _id;
END;
$$;


-- update publication
CREATE PROCEDURE update_publication(_id int, _title varchar, _genre_id int, _publisher_id int, _language_id int, _translator varchar, _publish_date text, _description varchar)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE publications
    SET title = COALESCE(_title, title),
        genre_id = COALESCE(_genre_id, genre_id),
        publisher_id = COALESCE(_publisher_id, publisher_id),
        language_id = COALESCE(_language_id, language_id),
        translator = COALESCE(-_translator, translator),
        publish_date = COALESCE(_publish_date, publish_date)::date,
        description = COALESCE(_description, description)
    WHERE id = _id;
END;
$$;


-- update physical_publication
CREATE PROCEDURE update_physical_publication(_id int, _floor_number int, _section_number int, _shelf_number int)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE physical_publications
    SET floor_number = COALESCE(_floor_number, floor_number),
        section_number  = COALESCE(_section_number, section_number),
        shelf_number  = COALESCE(_shelf_number, shelf_number)
    WHERE id = _id;
END;
$$;

-- update physical_book
CREATE PROCEDURE update_physical_book(_id int, _page_number int)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE physical_books
    SET page_number = _page_number
    WHERE id = _id;
END;
$$;


-- update newspaper
CREATE PROCEDURE update_newspaper(_id int, _publication_frequency varchar, _circulation varchar)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE newspapers
    SET publication_frequency = COALESCE(_publication_frequency, publication_frequency),
        circulation = COALESCE(_circulation, circulation)
    WHERE id = _id;
END;
$$;

-- update material
CREATE PROCEDURE update_materials(_id int, _format varchar)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE materials
    SET format = _format
    WHERE id = _id;
END;
$$;

-- update language
CREATE PROCEDURE update_languages(_id int, _name varchar)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE languages
    SET name = _name
    WHERE id = _id;
END;
$$;

-- update genre
CREATE PROCEDURE update_genres(_id int, _name varchar, _description varchar)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE genres
    SET name = COALESCE(_name, name),
        description = COALESCE(_description, description)
    WHERE id = _id;
END;
$$;


-- update electronic_publication
CREATE PROCEDURE update_electronic_publications(_id int, _link varchar, _size int)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE electronic_publications
    SET link = COALESCE(_link, link),
        size = COALESCE(_size, size)
    WHERE id = _id;
END;
$$;


-- update borrowing (return a book)
CREATE PROCEDURE update_borrowings(_id int)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE borrowings
    SET return_date = NOW()
    WHERE id = _id;
END;
$$;

-- update book_origin
CREATE PROCEDURE update_book_origins(_id int, _author_id varchar, _name varchar)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE book_origins
    SET author_id = COALESCE(_author_id, author_id),
        name = COALESCE(_name, name)
    WHERE id = _id;
END;
$$;


-- update author
CREATE PROCEDURE update_authors(_id int, _first_name varchar, _last_name varchar, _date_of_birth text, _nationality varchar, _biography varchar)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE authors
    SET first_name = COALESCE(_first_name, first_name),
        last_name = COALESCE(_last_name, last_name),
        date_of_birth = COALESCE(_date_of_birth, date_of_birth)::date,
        nationality = COALESCE(_nationality, nationality),
        biography = COALESCE(_biography, biography)
    WHERE id = _id;
END;
$$;

-- update audio_book
CREATE PROCEDURE update_audio_books(_id int, _narrator varchar, _duration int)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE audio_books
    SET narrator = COALESCE(_narrator, narrator),
        duration = COALESCE(_duration, duration)
    WHERE id = _id;
END;
$$;

-- DELETE procedures
-- soft delete
CREATE OR REPLACE PROCEDURE soft_delete(_id int, _table_name varchar)
    LANGUAGE plpgsql
AS
$$
DECLARE
    table_exists boolean;
BEGIN
    EXECUTE format('SELECT EXISTS(SELECT 1 FROM information_schema.tables WHERE table_name = %L)', _table_name)
        INTO table_exists;

    IF NOT table_exists THEN
        RAISE EXCEPTION 'Table % does not exist', _table_name;
    END IF;

    EXECUTE format('UPDATE %I SET deleted_at = NOW() WHERE id = %s', _table_name, _id);
END;
$$;


-- hard delete
CREATE OR REPLACE PROCEDURE hard_delete(_id int, _table_name varchar)
    LANGUAGE plpgsql
AS
$$
DECLARE
    table_exists boolean;
BEGIN
    EXECUTE format('SELECT EXISTS(SELECT 1 FROM information_schema.tables WHERE table_name = %L)', _table_name)
        INTO table_exists;

    IF NOT table_exists THEN
        RAISE EXCEPTION 'Table % does not exist', _table_name;
    END IF;

    EXECUTE format('DELETE FROM %I WHERE id = %s', _table_name, _id);
END;
$$;



