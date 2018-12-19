--
--  application_user
--

CREATE TABLE public.application_user (

  username CHARACTER VARYING,
  password CHARACTER VARYING,
  id INTEGER PRIMARY KEY,
  is_admin BOOLEAN,
  );

-- make a sequence
DROP SEQUENCE public.application_user_id_seq;

-- create the sequence
CREATE SEQUENCE public.application_user_id_seq
INCREMENT BY 100
  MINVALUE 1
  MAXVALUE 928398324798324
START 1
CACHE 100;

--
--  BOOK
--

CREATE TABLE public.book (
  book_id INTEGER PRIMARY KEY,
  book_name CHARACTER VARYING,
  author CHARACTER VARYING,
  book_price DOUBLE,
  isbn INTEGER,
  genre CHARACTER VARYING,
  publish_date DATE,

);

-- make a sequence
DROP SEQUENCE public.book_id_seq;

-- create the sequence
CREATE SEQUENCE public.book_id_seq
INCREMENT BY 100
  MINVALUE 1
  MAXVALUE 928398324798324
START 1
CACHE 100;