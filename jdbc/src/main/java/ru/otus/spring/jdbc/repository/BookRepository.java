package ru.otus.spring.jdbc.repository;

import ru.otus.spring.jdbc.model.Author;
import ru.otus.spring.jdbc.model.Book;
import ru.otus.spring.jdbc.model.Genre;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    int count();

    Optional<Book> getById(long id);

    List<Book> getAll();

    boolean deleteById(long id);

    Book insert(String bookName, Author author, Genre genre);
}
