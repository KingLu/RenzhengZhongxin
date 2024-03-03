INSERT INTO users (username, password, enabled) VALUES
                                                    ('zhangsan', '$2a$10$ksfgaPBJL2r5q5uHrJszK.o.fi.GXsErUli/Je0ujsMTJFnEbngzi', TRUE),
                                                    ('lisi', '$2a$10$ksfgaPBJL2r5q5uHrJszK.o.fi.GXsErUli/Je0ujsMTJFnEbngzi', TRUE);

INSERT INTO authorities (username, authority) VALUES
                                                  ('zhangsan', 'ROLE_USER'),
                                                  ('lisi', 'ROLE_USER');
