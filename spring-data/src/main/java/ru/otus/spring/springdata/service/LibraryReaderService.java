package ru.otus.spring.springdata.service;

import ru.otus.spring.springdata.domain.Book;
import ru.otus.spring.springdata.domain.BookComment;
import ru.otus.spring.springdata.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface LibraryReaderService {
    List<Book> getAllBooks();

    Optional<Book> getBookById(long id);

    List<BookComment> getBookComments(long bookId);

    Optional<BookComment> commentBook(long bookId, String comment) throws DaoException;
}
