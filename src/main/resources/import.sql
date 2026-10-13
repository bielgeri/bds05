INSERT INTO tb_user (name, email, password) VALUES ('Bob Brown',  'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Ana Sigma',  'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_VISITOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_MEMBER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_genre (name) VALUES ('Animação');
INSERT INTO tb_movie (genre_id, title, sub_Title, movie_year, img_Url, synopsis) VALUES (1, 'Carros', 'Eu sou a velocidade', 2003, 'https://ingresso-a.akamaihd.net/b2b/production/uploads/article/image/5492/b01e6be8ad35d90adc8ae9a3fa0ab394.jpg', 'Filme do McQueen');
INSERT INTO tb_review (movie_id, user_id, text) VALUES (1, 1,'Teste de review');

