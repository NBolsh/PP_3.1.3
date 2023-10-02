INSERT INTO users (age, email, name, password, surname) VALUES (12, 'admin@a', 'ad', '$2a$12$RKQV9cDA4ToZJlNrSd0xmeXdMuUyxR/fTLsWMkTK9/TZMUeJW/abG', 'min');
INSERT INTO users (age, email, name, password, surname) VALUES (13, 'user@u', 'us', '$2a$12$TXG/4MOMX/nf87mT4RhOkeDvpO.53J.SZOoaixMaKkUsUcGCgLvCe', 'er');
INSERT INTO roles (id, role_name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, role_name) VALUES (2, 'ROLE_USER');
INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);