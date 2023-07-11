INSERT INTO animals (name, favourite_food, age, arrival_date, weight, height, tail_length, wingspan, species_id)
VALUES
    ('Arya', 'salad', 10, '2020-07-11', 260.00, 94.00, 86.50, null, 1),
    ('Argo', 'mushrooms', 9, '2020-06-23', 192.10, 116.80, 92.10, null, 2),
    ('Sky', 'chips', 3, '2021-04-20', 4.50, 81.20, null, 210.10, 3);

INSERT INTO items (name, description, required_slots)
VALUES
    ('flute', 'instrument to open doors', 5),
    ('mushrooms', 'food for Argo', 3),
    ('chips', 'food for Sky', 1),
    ('violin', 'instrument to open doors', 7),
    ('salad', 'food for Arya', 2);

INSERT INTO rooms (name, map_id)
VALUES
    ('Bedroom', 1),
    ('Kitchen', 1),
    ('Living room', 1),
    ('Bathroom', 1);

INSERT INTO doors (locked, item_id)
VALUES
    (false, 1),
    (true, 1),
    (false, 4),
    (true, 4);

INSERT INTO room_links (room_id, direction_id, adjacent_room_id, door_id)
VALUES
    (2, 4, 1, 1),
    (1, 2, 2, 1),
    (3, 3, 1, 2),
    (1, 1, 3, 2),
    (4, 2, 1, 3),
    (1, 4, 4, 3),
    (5, 1, 4, 4),
    (4, 3, 5, 4);

INSERT INTO items_in_room (room_id, item_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);

INSERT INTO animals_in_room (room_id, animal_id)
VALUES
    (2, 1),
    (3, 2),
    (4, 3);