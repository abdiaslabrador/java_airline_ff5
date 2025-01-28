-- Insert data
INSERT INTO roles (id_role, name) VALUES (DEFAULT, 'ROLE_USER');
INSERT INTO roles (id_role, name) VALUES (DEFAULT, 'ROLE_ADMIN');
INSERT INTO roles (id_role, name) VALUES (DEFAULT, 'READ');

INSERT INTO users (id_user, username, password) VALUES (default, 'pepe', '$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO');
INSERT INTO users (id_user, username, password) VALUES (default, 'pepa', '$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO');


INSERT INTO profiles (id_profile, first_name, last_name, dni, img, email, user_id) VALUES (DEFAULT, 'Abdias', 'Labrador', '123456789', 'laptop.png', 'abdiaslabrador@gmail.com', 1);
INSERT INTO profiles (id_profile, first_name, last_name, dni, img, email, user_id) VALUES (DEFAULT,  'Daniel', 'Perez', '234567891', 'cell_phone.png', 'danielperez@gmail.com', 2);

INSERT INTO roles_users (role_id, user_id) VALUES (1, 1);
INSERT INTO roles_users (role_id, user_id) VALUES (2, 1);
INSERT INTO roles_users (role_id, user_id) VALUES (3, 1);
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
