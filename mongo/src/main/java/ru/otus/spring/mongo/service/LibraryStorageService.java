package ru.otus.spring.mongo.service;


import ru.otus.spring.mongo.exception.DaoException;
import ru.otus.spring.mongo.domain.Author;
import ru.otus.spring.mongo.domain.Book;

import java.util.Optional;

public interface LibraryStorageService {
    Optional<Book> addNewBook(String name, String authorId, String genreName) throws DaoException;

    Optional<Author> addNewAuthor(String name) throws DaoException;

    boolean deleteBook(String bookId);

    void deleteGenre(String genreId) throws DaoException;

    void deleteAuthor(String authorId) throws DaoException;

    void removeGenreFromBook(String bookId, String genreId) throws DaoException;

    void addGenreToBook(String bookId, String genreName) throws DaoException;

    void removeAuthorFromBook(String bookId, String authorId) throws DaoException;

    void addAuthorToBook(String bookId,String authorId) throws DaoException;

}
