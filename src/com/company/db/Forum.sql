--
-- Файл сгенерирован с помощью SQLiteStudio v3.3.3 в Вт ноя 23 16:57:18 2021
--
-- Использованная кодировка текста: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Таблица: chat
CREATE TABLE chat (mes_id INTEGER PRIMARY KEY AUTOINCREMENT, user_id CHAR NOT NULL, message CHAR NOT NULL, time CHAR NOT NULL);
INSERT INTO chat (mes_id, user_id, message, time) VALUES (1, '1', ':-)', '2021-07-07 22:40:32');
INSERT INTO chat (mes_id, user_id, message, time) VALUES (2, '2', '??', '2021-07-07 22:46:37');
INSERT INTO chat (mes_id, user_id, message, time) VALUES (3, '1', 'привет, я тут новенький. что тут и как???', '2021-07-10 19:06:07');
INSERT INTO chat (mes_id, user_id, message, time) VALUES (4, '3', 'привет. честно говоря, я и сам не знаю)', '2021-07-10 19:06:54');

-- Таблица: topic
CREATE TABLE topic (topic_id INTEGER PRIMARY KEY AUTOINCREMENT, title CHAR NOT NULL, description CHAR NOT NULL, date CHAR NOT NULL, user_id CHAR NOT NULL);
INSERT INTO topic (topic_id, title, description, date, user_id) VALUES (1, 'Заголовок', 'Описание', '2021-07-12 17:57:53', '2');
INSERT INTO topic (topic_id, title, description, date, user_id) VALUES (2, 'Вторая тема', 'Описание второй темы', '2021-07-12 21:50:40', '1');

-- Таблица: topic_answ
CREATE TABLE topic_answ (answ_id INTEGER PRIMARY KEY AUTOINCREMENT, topic_id CHAR NOT NULL, message CHAR NOT NULL, mes_time CHAR NOT NULL, user_id CHAR NOT NULL);
INSERT INTO topic_answ (answ_id, topic_id, message, mes_time, user_id) VALUES (1, '1', 'ответ', '2021-07-12 21:50:40', '1');
INSERT INTO topic_answ (answ_id, topic_id, message, mes_time, user_id) VALUES (2, '2', 'второй ответ', '2021-07-12 21:50:40', '2');

-- Таблица: users
CREATE TABLE users (user_id INTEGER PRIMARY KEY AUTOINCREMENT, login CHAR NOT NULL, username CHAR NOT NULL, password CHAR NOT NULL);
INSERT INTO users (user_id, login, username, password) VALUES (1, 'qwerty@mail.ru', 'qwerty', '$2y$10$k2afAFVUVNOawcitwg8IuODeNBu1MHV8SX0T3IL2QzazU7ZtUb.pu');
INSERT INTO users (user_id, login, username, password) VALUES (2, 'Kazakh@mail.ru', 'Kazakh', '$2y$10$ECn4t57vOnnEBH1qV0zxHuDk6S3UvtreXEh3N6RkuD9EIjAK2HAHa');
INSERT INTO users (user_id, login, username, password) VALUES (3, 'user@mail.ru', 'user', '$10$gqsu/CaSiUqdQu58jrhhUOpvbg0Pv0D8mKA2HzFgjJ93OWpbLoMo2');

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
