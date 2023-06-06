INSERT INTO Species (id, name)
VALUES
    (1, 'Tiger'),
    (2, 'Lion'),
    (3, 'Eagle');

INSERT INTO Animals (id, name, favourite_food, age, arrival_date, weight, height, species_id)
VALUES
    (1, 'Arya', 'salad', 10, '2020-07-11', 260.00, 94.00, 1),
    (2, 'Argo', 'mushrooms', 9, '2020-06-23', 192.10, 116.80, 2),
    (3, 'Sky', 'chips', 3, '2021-04-20', 4.50, 81.20, 3);

INSERT INTO Tail_length (id, tail_length, animal_id)
VALUES
    (1, 86.50, 1),
    (2, 92.10, 2);


INSERT INTO Wingspans (id, wingspan, animal_id)
VALUES
    (1, 210.10, 3);

INSERT INTO Items (id, name, description, required_slots)
VALUES
    (1, 'flute', 'instrument to open doors', 5),
    (2, 'mushrooms', 'food for Argo', 3),
    (3, 'chips', 'food for Sky', 1),
    (4, 'violin', 'instrument to open doors', 7),
    (5, 'salad', 'food for Arya', 2);

INSERT INTO Rooms (id, name)
VALUES
    (1, 'Entrance'),
    (2, 'Bedroom'),
    (3, 'Kitchen'),
    (4, 'Living room'),
    (5, 'Bathroom');

INSERT INTO Doors (id, open, item_id)
VALUES
    (1, true, 1),
    (2, false, 1),
    (3, true, 4),
    (4, false, 4);

INSERT INTO Directions (id, name)
VALUES
    (1, 'north'),
    (2, 'east'),
    (3, 'south'),
    (4, 'west');

INSERT INTO Room_links (id, room_id, direction_id, adjacent_room_id, door_id)
VALUES
    (1, 2, 4, 1, 1),
    (2, 1, 2, 2, 1),
    (3, 3, 3, 1, 2),
    (4, 1, 1, 3, 2),
    (5, 4, 2, 1, 3),
    (6, 1, 4, 4, 3),
    (7, 5, 1, 4, 4),
    (8, 4, 3, 5, 4);

INSERT INTO Items_in_room (id, room_id, item_id)
VALUES
    (1, 1, 1),
    (2, 2, 2),
    (3, 3, 3),
    (4, 4, 4),
    (5, 5, 5);

INSERT INTO Animals_in_room (id, room_id, animal_id)
VALUES
    (1, 2, 1),
    (2, 3, 2),
    (3, 4, 3);



