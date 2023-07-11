CREATE DATABASE pawtropolisDB;

CREATE TABLE bags
(
    id SERIAL PRIMARY KEY,
    available_slots INT NOT NULL
);

CREATE TABLE players
(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    life_points INT NOT NULL,
    bag_id INTEGER NOT NULL,
    FOREIGN KEY (bag_id) REFERENCES bags (id)
);

CREATE TABLE items
(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    description TEXT NOT NULL,
    required_slots INT NOT NULL
);

CREATE TABLE maps
(
    id SERIAL PRIMARY KEY
);

CREATE TABLE games
(
    id SERIAL PRIMARY KEY,
    player_id INTEGER NOT NULL,
    map_id INTEGER NOT NULL,
    FOREIGN KEY (player_id) REFERENCES  players (id),
    FOREIGN KEY (map_id) REFERENCES maps (id)
);

CREATE TABLE items_in_bag
(
    bag_id INTEGER NOT NULL,
    item_id INTEGER NOT NULL,
    PRIMARY KEY (bag_id, item_id),
    FOREIGN KEY (bag_id) REFERENCES bags (id),
    FOREIGN KEY (item_id) REFERENCES items (id)
);

CREATE TABLE rooms
(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    map_id INTEGER NOT NULL,
    FOREIGN KEY (map_id) REFERENCES maps (id)
);

CREATE TABLE items_in_room
(
    room_id INTEGER NOT NULL,
    item_id INTEGER NOT NULL,
    PRIMARY KEY (room_id, item_id),
    FOREIGN KEY (room_id) REFERENCES rooms (id),
    FOREIGN KEY (item_id) REFERENCES items (id)
);

CREATE TABLE doors
(
    id SERIAL PRIMARY KEY,
    locked BOOLEAN NOT NULL,
    item_id INTEGER,
    FOREIGN KEY (item_id) REFERENCES items (id)
);

CREATE TABLE directions
(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE room_links
(
    id SERIAL PRIMARY KEY,
    room_id INTEGER NOT NULL,
    direction_id INTEGER NOT NULL,
    adjacent_room_id INTEGER NOT NULL,
    door_id INTEGER NOT NULL,
    FOREIGN KEY (room_id) REFERENCES rooms (id),
    FOREIGN KEY (direction_id) REFERENCES directions (id),
    FOREIGN KEY (adjacent_room_id) REFERENCES rooms (id),
    FOREIGN KEY (door_id) REFERENCES doors (id)
);

CREATE TABLE species
(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE animals
(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    favourite_food TEXT NOT NULL,
    age INT NOT NULL,
    arrival_date DATE NOT NULL,
    weight DECIMAL(8, 3) NOT NULL,
    height DECIMAL(5, 2) NOT NULL,
    tail_length DECIMAL(5, 2),
    wingspan DECIMAL(5, 2),
    species_id INTEGER NOT NULL,
    FOREIGN KEY (species_id) REFERENCES species (id)
);

CREATE TABLE animals_in_room
(
    animal_id INTEGER NOT NULL,
    room_id INTEGER NOT NULL,
    PRIMARY KEY (animal_id, room_id),
    FOREIGN KEY (animal_id) REFERENCES animals (id),
    FOREIGN KEY (room_id) REFERENCES rooms (id)
);

INSERT INTO species (name)
VALUES
    ('Tiger'),
    ('Lion'),
    ('Eagle');

WITH default_map AS (
    INSERT INTO maps DEFAULT VALUES
        RETURNING id
)

INSERT INTO rooms (name, map_id)
SELECT 'Entrance', id
FROM default_map;

INSERT INTO directions (name)
VALUES
    ('north'),
    ('east'),
    ('south'),
    ('west');