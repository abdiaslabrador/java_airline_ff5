-- Insert data
INSERT INTO roles (id_role, name) VALUES (DEFAULT, 'ROLE_USER');
INSERT INTO roles (id_role, name) VALUES (DEFAULT, 'ROLE_ADMIN');

INSERT INTO roles (id_role, name) VALUES (DEFAULT, 'ADMIN_CREATE_AIRPORTS'); --3
INSERT INTO roles (id_role, name) VALUES (DEFAULT, 'ADMIN_READ_AIRPORTS'); --4
INSERT INTO roles (id_role, name) VALUES (DEFAULT, 'ADMIN_UPDATE_AIRPORTS'); --5
INSERT INTO roles (id_role, name) VALUES (DEFAULT, 'ADMIN_DELETE_AIRPORTS'); --6

INSERT INTO roles (id_role, name) VALUES (DEFAULT, 'ADMIN_READ_FLIGHTS'); --7
INSERT INTO roles (id_role, name) VALUES (DEFAULT, 'ADMIN_CREATE_FLIGHTS'); --8
INSERT INTO roles (id_role, name) VALUES (DEFAULT, 'ADMIN_UPDATE_FLIGHTS'); --9
INSERT INTO roles (id_role, name) VALUES (DEFAULT, 'ADMIN_DELETE_FLIGHTS'); --10

INSERT INTO users (id_user, username, password) VALUES (default, 'pepe', '$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO');
INSERT INTO users (id_user, username, password) VALUES (default, 'pepa', '$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO');


INSERT INTO profiles (id_profile, first_name, last_name, dni, img, email, user_id) VALUES (DEFAULT, 'Abdias', 'Labrador', '123456789', 'laptop.png', 'abdiaslabrador@gmail.com', 1);
INSERT INTO profiles (id_profile, first_name, last_name, dni, img, email, user_id) VALUES (DEFAULT,  'Daniel', 'Perez', '234567891', 'cell_phone.png', 'danielperez@gmail.com', 2);

INSERT INTO roles_users (role_id, user_id) VALUES (1, 1);
INSERT INTO roles_users (role_id, user_id) VALUES (3, 1);
INSERT INTO roles_users (role_id, user_id) VALUES (4, 1);
INSERT INTO roles_users (role_id, user_id) VALUES (5, 1);
INSERT INTO roles_users (role_id, user_id) VALUES (6, 1);
INSERT INTO roles_users (role_id, user_id) VALUES (7, 1);
INSERT INTO roles_users (role_id, user_id) VALUES (8, 1);
INSERT INTO roles_users (role_id, user_id) VALUES (9, 1);
INSERT INTO roles_users (role_id, user_id) VALUES (10, 1);
INSERT INTO roles_users (role_id, user_id) VALUES (3, 2);

INSERT INTO airports (name, city, code) VALUES ('Aeropuerto Internacional de Dallas/Fort Worth', 'Dallas', 'DFW');
INSERT INTO airports (name, city, code) VALUES ('Aeropuerto Internacional John F. Kennedy', 'Nueva York', 'JFK');
INSERT INTO airports (name, city, code) VALUES ('Aeropuerto Internacional de Los Ángeles', 'Los Ángeles', 'LAX');
INSERT INTO airports (name, city, code) VALUES ('Aeropuerto Internacional O´Hare', 'Chicago', 'ORD');
INSERT INTO airports (name, city, code) VALUES ('Aeropuerto Internacional de Miami', 'Miami', 'MIA');
INSERT INTO airports (name, city, code) VALUES ('Aeropuerto Internacional de San Francisco', 'San Francisco', 'SFO');
INSERT INTO airports (name, city, code) VALUES ('Aeropuerto Internacional de Seattle-Tacoma', 'Seattle', 'SEA');
INSERT INTO airports (name, city, code) VALUES ('Aeropuerto Internacional de Denver', 'Denver', 'DEN');
INSERT INTO airports (name, city, code) VALUES ('Aeropuerto Internacional Hartsfield-Jackson', 'Atlanta', 'ATL');
INSERT INTO airports (name, city, code) VALUES ('Aeropuerto Internacional de Houston-George Bush', 'Houston', 'IAH');
INSERT INTO airports (name, city, code) VALUES ('Aeropuerto Internacional de Orlando', 'Orlando', 'MCO');
INSERT INTO airports (name, city, code) VALUES ('Aeropuerto Internacional de Las Vegas-McCarran', 'Las Vegas', 'LAS');
INSERT INTO airports (name, city, code) VALUES ('Aeropuerto Internacional de Boston-Logan', 'Boston', 'BOS');
INSERT INTO airports (name, city, code) VALUES ('Aeropuerto Internacional de Washington-Dulles', 'Washington D.C.', 'IAD');
INSERT INTO airports (name, city, code) VALUES ('Aeropuerto Internacional de Phoenix Sky Harbor', 'Phoenix', 'PHX');
INSERT INTO airports (name, city, code) VALUES ('Aeropuerto Internacional de Detroit Metropolitan Wayne County', 'Detroit', 'DTW');

INSERT INTO flights (departure_date_time, arrival_date_time, code, state, max_seats, seats_occupied, company_name, blocking_time, airport_origin_id, airport_dest_id)
VALUES 
('2025-01-30 08:00:00', '2025-01-30 12:30:00', 'AA1234', true, 200, 150, 'American Airlines', '2025-01-30 07:30:00', (SELECT id FROM airports WHERE code = 'DFW'), (SELECT id FROM airports WHERE code = 'JFK')),
('2025-01-30 10:15:00', '2025-01-30 13:45:00', 'UA5678', true, 180, 120, 'United Airlines', '2025-01-30 09:45:00', (SELECT id FROM airports WHERE code = 'LAX'), (SELECT id FROM airports WHERE code = 'ORD')),
('2025-01-30 14:30:00', '2025-01-30 18:45:00', 'DL9012', true, 220, 200, 'Delta Airlines', '2025-01-30 14:00:00', (SELECT id FROM airports WHERE code = 'ATL'), (SELECT id FROM airports WHERE code = 'MIA')),
('2025-01-31 07:00:00', '2025-01-31 10:30:00', 'SW3456', true, 150, 100, 'Southwest Airlines', '2025-01-31 06:30:00', (SELECT id FROM airports WHERE code = 'DEN'), (SELECT id FROM airports WHERE code = 'PHX')),
('2025-01-31 11:45:00', '2025-01-31 14:15:00', 'JB7890', true, 160, 140, 'JetBlue Airways', '2025-01-31 11:15:00', (SELECT id FROM airports WHERE code = 'BOS'), (SELECT id FROM airports WHERE code = 'MCO')),
('2025-01-31 16:20:00', '2025-01-31 19:50:00', 'AS2345', true, 190, 170, 'Alaska Airlines', '2025-01-31 15:50:00', (SELECT id FROM airports WHERE code = 'SEA'), (SELECT id FROM airports WHERE code = 'SFO')),
('2025-02-01 09:30:00', '2025-02-01 13:00:00', 'F91234', true, 210, 180, 'Frontier Airlines', '2025-02-01 09:00:00', (SELECT id FROM airports WHERE code = 'LAS'), (SELECT id FROM airports WHERE code = 'IAH'));
-- ('2025-02-01 13:15:00', '2025-02-01 16:45:00', 'NK5678', true, 170, 130, 'Spirit Airlines', '2025-02-01 12:45:00', (SELECT id FROM airports WHERE code = 'DTW'), (SELECT id FROM airports WHERE code = 'IAD'));
