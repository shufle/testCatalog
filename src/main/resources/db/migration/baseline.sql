create table  if not exists books
(
  id         serial       not null
    constraint books_pk
      primary key,
  book_title varchar(255) not null,
  au_fio     varchar(255) not null
);

comment on table books is 'catalog of books and authors';

alter table books
  owner to postgres;

INSERT INTO schema.books (id, book_title, au_fio) VALUES (1, 'Война и мир', 'Толстой Л.Н.');
INSERT INTO schema.books (id, book_title, au_fio) VALUES (2, 'Капитанская дочка', 'Пушкин А. С.');
INSERT INTO schema.books (id, book_title, au_fio) VALUES (3, 'Пророк', 'Пушкин А. С.');
INSERT INTO schema.books (id, book_title, au_fio) VALUES (4, 'Анна Каренина', 'Толстой Л.Н.');
INSERT INTO schema.books (id, book_title, au_fio) VALUES (5, 'Пророк', 'Лермонтов М. Ю.');
INSERT INTO schema.books (id, book_title, au_fio) VALUES (6, 'Зов предков', 'Джек Лондон');
INSERT INTO schema.books (id, book_title, au_fio) VALUES (7, 'Юность', 'Толстой Л.Н.');