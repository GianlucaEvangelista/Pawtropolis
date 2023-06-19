INSERT INTO species (id, name)
VALUES
    (1, 'Tiger'),
    (2, 'Lion'),
    (3, 'Eagle');

INSERT INTO animals (id, name, favourite_food, age, arrival_date, weight, height, tail_length, wingspan, species_id)
VALUES
    (1, 'Arya', 'salad', 10, '2020-07-11', 260.00, 94.00, 86.50, null, 1),
    (2, 'Argo', 'mushrooms', 9, '2020-06-23', 192.10, 116.80, 92.10, null, 2),
    (3, 'Sky', 'chips', 3, '2021-04-20', 4.50, 81.20, null, 210.10, 3);

INSERT INTO items (id, name, description, required_slots)
VALUES
    (1, 'flute', 'instrument to open doors', 5),
    (2, 'mushrooms', 'food for Argo', 3),
    (3, 'chips', 'food for Sky', 1),
    (4, 'violin', 'instrument to open doors', 7),
    (5, 'salad', 'food for Arya', 2);

INSERT INTO rooms (id, name)
VALUES
    (1, 'Entrance'),
    (2, 'Bedroom'),
    (3, 'Kitchen'),
    (4, 'Living room'),
    (5, 'Bathroom');

INSERT INTO doors (id, locked, item_id)
VALUES
    (1, false, 1),
    (2, true, 1),
    (3, false, 4),
    (4, true, 4);

INSERT INTO directions (id, name)
VALUES
    (1, 'north'),
    (2, 'east'),
    (3, 'south'),
    (4, 'west');

INSERT INTO room_links (id, room_id, direction_id, adjacent_room_id, door_id)
VALUES
    (1, 2, 4, 1, 1),
    (2, 1, 2, 2, 1),
    (3, 3, 3, 1, 2),
    (4, 1, 1, 3, 2),
    (5, 4, 2, 1, 3),
    (6, 1, 4, 4, 3),
    (7, 5, 1, 4, 4),
    (8, 4, 3, 5, 4);

INSERT INTO items_in_room (id, room_id, item_id)
VALUES
    (1, 1, 1),
    (2, 2, 2),
    (3, 3, 3),
    (4, 4, 4),
    (5, 5, 5);

INSERT INTO animals_in_room (id, room_id, animal_id)
VALUES
    (1, 2, 1),
    (2, 3, 2),
    (3, 4, 3);



