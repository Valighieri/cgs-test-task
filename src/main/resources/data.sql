INSERT INTO bus_route (route_name, seat_count)
VALUES ('Kyiv – Lviv', 10);

INSERT INTO seat (bus_route_id, seat_number)
SELECT currval(pg_get_serial_sequence('bus_route','id')), generate_series(1,10);

INSERT INTO booking (bus_route_id, seat_number, passenger_first_name, passenger_last_name)
VALUES
    (currval(pg_get_serial_sequence('bus_route','id')), 1, 'Alice',   'Johnson'),
    (currval(pg_get_serial_sequence('bus_route','id')), 2, 'Bob',     'Smith'),
    (currval(pg_get_serial_sequence('bus_route','id')), 3, 'Charlie', 'Brown'),
    (currval(pg_get_serial_sequence('bus_route','id')), 4, 'Diana',   'Prince'),
    (currval(pg_get_serial_sequence('bus_route','id')), 5, 'Evan',    'Taylor');