--
-- Create user table
--
CREATE TABLE public.application_user
(
  id integer PRIMARY KEY,
  username character varying,
  password character varying,
  is_admin boolean
);

DROP SEQUENCE public.application_user_id_seq;
CREATE SEQUENCE public.application_user_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

--
-- Create book table
--
CREATE TABLE public.book
(
  id integer PRIMARY KEY,
  title character varying,
  monthPublished integer,
  dayPublished integer,
  yearPublished integer,
  author character varying,
  isbn bigint,
  genre character varying,
  price numeric
);

DROP SEQUENCE public.book_id_seq;
CREATE SEQUENCE public.book_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;