CREATE TABLE IF NOT EXISTS bus_route (
  id BIGSERIAL PRIMARY KEY,
  route_name TEXT NOT NULL,
  seat_count INTEGER NOT NULL CHECK (seat_count > 0)
);

CREATE TABLE IF NOT EXISTS seat (
  bus_route_id BIGINT NOT NULL
    REFERENCES bus_route(id) ON DELETE CASCADE,
  seat_number INTEGER NOT NULL,
  is_bookable BOOLEAN NOT NULL DEFAULT TRUE,
  PRIMARY KEY (bus_route_id, seat_number)
);

CREATE TABLE IF NOT EXISTS booking (
  bus_route_id BIGINT    NOT NULL,
  seat_number  INTEGER   NOT NULL,
  passenger_first_name TEXT NOT NULL,
  passenger_last_name  TEXT NOT NULL,
  booked_at    TIMESTAMPTZ NOT NULL DEFAULT now(),
  PRIMARY KEY (bus_route_id, seat_number),
  FOREIGN KEY (bus_route_id, seat_number)
    REFERENCES seat(bus_route_id, seat_number)
    ON DELETE CASCADE
);
