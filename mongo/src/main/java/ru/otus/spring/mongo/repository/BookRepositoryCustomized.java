package ru.otus.spring.mongo.repository;

import ru.otus.spring.mongo.domain.Genre;
import ru.otus.spring.mongo.exception.DaoException;
import ru.otus.spring.mongo.domain.Author;

import java.util.List;

public interface BookRepositoryCustomized {
    void removeGenreFromBookByBookId(String bookId, String genreId) throws DaoException;

    List<Genre> findGenresForBookId(String bookId);

    boolean existsByIdAndGenresContains(String bookId, String genreName);

    void removeAuthorFromBookByBookId(String bookId, String authorId) throws DaoException;

    void addAuthorToBook(String bookId, Author author);

    void addGenreToBook(String bookId, Genre genre);

    boolean hasBookWithSingleAuthorId(String authorId);

    boolean hasBookWithSingleGenreId(String genreId);
}
