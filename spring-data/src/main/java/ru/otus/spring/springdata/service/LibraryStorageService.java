package ru.otus.spring.springdata.service;

import ru.otus.spring.springdata.domain.Book;
import ru.otus.spring.springdata.exception.DaoException;

import java.util.Optional;

public interface LibraryStorageService {
    Optional<Book> addNewBook(String name, long authorId, String genreName) throws DaoException;

    boolean deleteBook(long bookId);
}
