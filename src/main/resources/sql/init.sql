CREATE DATABASE pawtropolisDB;

CREATE TABLE Bags
(
    id INT PRIMARY KEY,
    available_slots INT NOT NULL
);

CREATE TABLE Players
(
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    life_points INT NOT NULL,
    bag_id INT NOT NULL,
    FOREIGN KEY (bag_id) REFERENCES Bags (id)
);

CREATE TABLE Items
(
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    required_slots INT NOT NULL
);

CREATE TABLE Items_in_bag
(
    id INT PRIMARY KEY,
    bag_id INT NOT NULL,
    item_id INT NOT NULL,
    FOREIGN KEY (bag_id) REFERENCES Bags (id),
    FOREIGN KEY (item_id) REFERENCES Items (id)
);

CREATE TABLE Rooms
(
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE Items_in_room
(
    id INT PRIMARY KEY,
    room_id INT NOT NULL,
    item_id INT NOT NULL,
    FOREIGN KEY (room_id) REFERENCES Rooms (id),
    FOREIGN KEY (item_id) REFERENCES Items (id)
);

CREATE TABLE Doors
(
    id INT PRIMARY KEY,
    open BOOLEAN NOT NULL,
    item_id INT NOT NULL,
    FOREIGN KEY (item_id) REFERENCES Items (id)
);

CREATE TABLE Directions
(
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE Room_links
(
    id INT PRIMARY KEY,
    room_id INT NOT NULL,
    direction_id INT NOT NULL,
    adjacent_room_id INT NOT NULL,
    door_id INT NOT NULL,
    FOREIGN KEY (room_id) REFERENCES Rooms (id),
    FOREIGN KEY (direction_id) REFERENCES Directions (id),
    FOREIGN KEY (adjacent_room_id) REFERENCES Rooms (id),
    FOREIGN KEY (door_id) REFERENCES Doors (id)
);

CREATE TABLE Species
(
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE Animals
(
    id INT PRIMARY KEY,
    name VARCHAR(255)  NOT NULL,
    favourite_food VARCHAR(255)  NOT NULL,
    age INT NOT NULL,
    arrival_date DATE NOT NULL,
    weight DECIMAL(8, 3) NOT NULL,
    height DECIMAL(5, 2) NOT NULL,
    species_id INT NOT NULL,
    FOREIGN KEY (species_id) REFERENCES Species (id)
);

CREATE TABLE Tail_length
(
    id INT PRIMARY KEY,
    tail_length DECIMAL(5, 2) NOT NULL,
    animal_id INT NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES Animals (id)
);

CREATE TABLE Wingspans
(
    id INT PRIMARY KEY,
    wingspan DECIMAL(5, 2) NOT NULL,
    animal_id INT NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES Animals (id)
);

CREATE TABLE Animals_in_room
(
    id INT PRIMARY KEY,
    animal_id INT NOT NULL,
    room_id INT NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES Animals (id),
    FOREIGN KEY (room_id) REFERENCES Rooms (id)
);