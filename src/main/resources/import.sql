INSERT INTO role(role_id, name) VALUES (999, 'ROLE_USER')
INSERT INTO role(role_id, name) VALUES (998, 'ROLE_ADMIN')

INSERT INTO game(id, cross_platform, for_age, game_genre, multiplayer, name, single_player) VALUES (99, 'WINDOWS', 12, 'PUZZLE', true, 'pico park', false)
INSERT INTO game(id, cross_platform, for_age, game_genre, multiplayer, name, single_player) VALUES (98, 'WINDOWS', 15, 'SURVIVAL', false, 'fortnite', true)
INSERT INTO game(id, cross_platform, for_age, game_genre, multiplayer, name, single_player) VALUES (97, 'WINDOWS', 15, 'ADVENTURE', false, 'jill of the Jungle', true)

INSERT INTO creator(id, name, nationality) VALUES (81, 'Teco', 'american')
INSERT INTO creator(id, name, nationality) VALUES (82, 'Tim Sweeney', 'american')

INSERT INTO game_creator(creator_id, game_id) VALUES (81, 99)
INSERT INTO game_creator(creator_id, game_id) VALUES (82, 98)
INSERT INTO game_creator(creator_id, game_id) VALUES (82, 97)