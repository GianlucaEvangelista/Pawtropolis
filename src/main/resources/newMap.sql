WITH new_map AS (
    INSERT INTO maps DEFAULT VALUES
           RETURNING id
),
    game AS (
        INSERT INTO games (player_id, map_id)
            SELECT :playerId, id
            FROM new_map
),
    entrance_id AS (
        INSERT INTO rooms (name, map_id)
            SELECT 'Entrance', id
            FROM new_map
               RETURNING id
),
     bedroom_id AS (
         INSERT INTO rooms (name, map_id)
             SELECT 'Bedroom', id
             FROM new_map
             RETURNING id
),
     kitchen_id AS (
         INSERT INTO rooms (name, map_id)
             SELECT 'Kitchen', id
             FROM new_map
             RETURNING id
),
     living_room_id AS (
         INSERT INTO rooms (name, map_id)
             SELECT 'Living Room', id
             FROM new_map
             RETURNING id
),
     bathroom_id AS (
         INSERT INTO rooms (name, map_id)
             SELECT 'Bathroom', id
             FROM new_map
             RETURNING id
),
    items_insert AS (
        INSERT INTO items_in_room (room_id, item_id)
            SELECT id, 1
            FROM entrance_id
            UNION ALL
            SELECT id, 2
            FROM bedroom_id
            UNION ALL
            SELECT id, 3
            FROM kitchen_id
            UNION ALL
            SELECT id, 4
            FROM living_room_id
            UNION ALL
            SELECT id, 5
            FROM bathroom_id
),
    animals_insert AS (
        INSERT INTO animals_in_room (room_id, animal_id)
            SELECT id, 1
            FROM bedroom_id
            UNION ALL
            SELECT id, 2
            FROM kitchen_id
            UNION ALL
            SELECT id, 3
            FROM living_room_id
),
     entrance_bedroom_door AS (
         INSERT INTO doors (locked, item_id)
             VALUES (false, 1)
             RETURNING id
),
     entrance_kitchen_door AS (
         INSERT INTO doors (locked, item_id)
             VALUES (true, 1)
             RETURNING id
),
     entrance_living_room_door AS (
         INSERT INTO doors (locked, item_id)
             VALUES (false, 4)
             RETURNING id
),
     living_room_bathroom_door AS (
         INSERT INTO doors (locked, item_id)
             VALUES (true, 4)
             RETURNING id
)
INSERT INTO room_links (room_id, direction_id, adjacent_room_id, door_id)
SELECT
    (SELECT id FROM bedroom_id),
    4,
    (SELECT id FROM entrance_id),
    (SELECT id FROM entrance_bedroom_door)
UNION ALL
SELECT
    (SELECT id FROM entrance_id),
    2,
    (SELECT id FROM bedroom_id),
    (SELECT id FROM entrance_bedroom_door)
UNION ALL
SELECT
    (SELECT id FROM kitchen_id),
    3,
    (SELECT id FROM entrance_id),
    (SELECT id FROM entrance_kitchen_door)
UNION ALL
SELECT
    (SELECT id FROM entrance_id),
    1,
    (SELECT id FROM kitchen_id),
    (SELECT id FROM entrance_kitchen_door)
UNION ALL
SELECT
    (SELECT id FROM living_room_id),
    2,
    (SELECT id FROM entrance_id),
    (SELECT id FROM entrance_living_room_door)
UNION ALL
SELECT
    (SELECT id FROM entrance_id),
    4,
    (SELECT id FROM living_room_id),
    (SELECT id FROM entrance_living_room_door)
UNION ALL
SELECT
    (SELECT id FROM bathroom_id),
    1,
    (SELECT id FROM living_room_id),
    (SELECT id FROM living_room_bathroom_door)
UNION ALL
SELECT
    (SELECT id FROM living_room_id),
    3,
    (SELECT id FROM bathroom_id),
    (SELECT id FROM living_room_bathroom_door);