-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Фев 22 2022 г., 17:06
-- Версия сервера: 8.0.19
-- Версия PHP: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `forum_db`
--
CREATE DATABASE IF NOT EXISTS `forum_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `forum_db`;

-- --------------------------------------------------------

--
-- Структура таблицы `chat`
--

CREATE TABLE `chat` (
  `mes_id` int NOT NULL,
  `user_id` text NOT NULL,
  `message` text NOT NULL,
  `mes_time` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `chat`
--

INSERT INTO `chat` (`mes_id`, `user_id`, `message`, `mes_time`) VALUES
(1, '1', ':-)', '2021-07-07 22:40:32'),
(2, '2', '??', '2021-07-07 22:46:37'),
(3, '1', 'ghbbdtn???', '2021-07-10 19:06:07'),
(22, '3', 'Привет. как дела?)', '2021-07-10 19:06:54'),
(23, '3', 'Привет. как дела?)', '2021-07-10 19:06:54'),
(24, '3', 'Привет. как дела?)', '2021-07-10 19:06:54');

-- --------------------------------------------------------

--
-- Структура таблицы `topic`
--

CREATE TABLE `topic` (
  `topic_id` int NOT NULL,
  `title` text NOT NULL,
  `topic_description` text NOT NULL,
  `topic_date` text NOT NULL,
  `user_id` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `topic`
--

INSERT INTO `topic` (`topic_id`, `title`, `topic_description`, `topic_date`, `user_id`) VALUES
(1, 'Заголовок', 'Описание', '2021-07-12 17:57:53', '2'),
(2, 'Вторая тема', 'Описание второй темы', '2021-07-12 21:50:40', '1');

-- --------------------------------------------------------

--
-- Структура таблицы `topic_answ`
--

CREATE TABLE `topic_answ` (
  `answ_id` int NOT NULL,
  `topic_id` text NOT NULL,
  `message` text NOT NULL,
  `mes_time` text NOT NULL,
  `user_id` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `topic_answ`
--

INSERT INTO `topic_answ` (`answ_id`, `topic_id`, `message`, `mes_time`, `user_id`) VALUES
(1, '1', 'ответ', '2021-07-12 21:50:40', '1'),
(2, '2', 'второй ответ', '2021-07-12 21:50:40', '2');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `user_id` int NOT NULL,
  `login` text NOT NULL,
  `username` text NOT NULL,
  `pass` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`user_id`, `login`, `username`, `pass`) VALUES
(1, 'qwerty@mail.ru', 'qwerty', 'qwerty'),
(2, 'Kazakh@mail.ru', 'Kazakh', 'Kazakh'),
(3, 'user@mail.ru', 'user', 'user');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `chat`
--
ALTER TABLE `chat`
  ADD PRIMARY KEY (`mes_id`);

--
-- Индексы таблицы `topic`
--
ALTER TABLE `topic`
  ADD PRIMARY KEY (`topic_id`);

--
-- Индексы таблицы `topic_answ`
--
ALTER TABLE `topic_answ`
  ADD PRIMARY KEY (`answ_id`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `chat`
--
ALTER TABLE `chat`
  MODIFY `mes_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT для таблицы `topic`
--
ALTER TABLE `topic`
  MODIFY `topic_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `topic_answ`
--
ALTER TABLE `topic_answ`
  MODIFY `answ_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
