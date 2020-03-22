package ru.otus.spring.mongo.service;


import ru.otus.spring.mongo.domain.BookComment;
import ru.otus.spring.mongo.domain.Genre;
import ru.otus.spring.mongo.exception.DaoException;
import ru.otus.spring.mongo.domain.Author;
import ru.otus.spring.mongo.domain.Book;

import java.util.List;
import java.util.Optional;

public interface LibraryReaderService {
    List<Author> findAllAuthors();

    List<Genre> findAllGenres();

    List<Book> getAllBooksSortedByName();

    List<Book> getBooksByNameLike(String name);

    List<BookComment> getBookComments(String bookId);

    Optional<BookComment> commentBook(String bookId, String comment) throws DaoException;
}
