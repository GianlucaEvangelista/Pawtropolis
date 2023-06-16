CREATE DATABASE pawtropolisDB;

CREATE TABLE bags
(
    id SERIAL PRIMARY KEY,
    available_slots INT NOT NULL
);

CREATE TABLE players
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    life_points INT NOT NULL,
    bag_id SERIAL NOT NULL,
    FOREIGN KEY (bag_id) REFERENCES bags (id)
);

CREATE TABLE items
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    required_slots INT NOT NULL
);

CREATE TABLE items_in_bag
(
    id SERIAL PRIMARY KEY,
    bag_id SERIAL NOT NULL,
    item_id SERIAL NOT NULL,
    FOREIGN KEY (bag_id) REFERENCES bags (id),
    FOREIGN KEY (item_id) REFERENCES items (id)
);

CREATE TABLE rooms
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE items_in_room
(
    id SERIAL PRIMARY KEY,
    room_id SERIAL NOT NULL,
    item_id SERIAL NOT NULL,
    FOREIGN KEY (room_id) REFERENCES rooms (id),
    FOREIGN KEY (item_id) REFERENCES items (id)
);

CREATE TABLE doors
(
    id SERIAL PRIMARY KEY,
    locked BOOLEAN NOT NULL,
    item_id SERIAL NOT NULL,
    FOREIGN KEY (item_id) REFERENCES items (id)
);

CREATE TABLE directions
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE room_links
(
    id SERIAL PRIMARY KEY,
    room_id SERIAL NOT NULL,
    direction_id SERIAL NOT NULL,
    adjacent_room_id SERIAL NOT NULL,
    door_id SERIAL NOT NULL,
    FOREIGN KEY (room_id) REFERENCES rooms (id),
    FOREIGN KEY (direction_id) REFERENCES directions (id),
    FOREIGN KEY (adjacent_room_id) REFERENCES rooms (id),
    FOREIGN KEY (door_id) REFERENCES doors (id)
);

CREATE TABLE species
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE animals
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)  NOT NULL,
    favourite_food VARCHAR(255)  NOT NULL,
    age INT NOT NULL,
    arrival_date DATE NOT NULL,
    weight DECIMAL(8, 3) NOT NULL,
    height DECIMAL(5, 2) NOT NULL,
    species_id SERIAL NOT NULL,
    FOREIGN KEY (species_id) REFERENCES species (id)
);

CREATE TABLE tailed
(
    id SERIAL PRIMARY KEY,
    tail_length DECIMAL(5, 2) NOT NULL,
    animal_id SERIAL NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES animals (id)
);

CREATE TABLE winged
(
    id SERIAL PRIMARY KEY,
    wingspan DECIMAL(5, 2) NOT NULL,
    animal_id SERIAL NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES animals (id)
);

CREATE TABLE animals_in_room
(
    id SERIAL PRIMARY KEY,
    animal_id SERIAL NOT NULL,
    room_id SERIAL NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES animals (id),
    FOREIGN KEY (room_id) REFERENCES rooms (id)
);