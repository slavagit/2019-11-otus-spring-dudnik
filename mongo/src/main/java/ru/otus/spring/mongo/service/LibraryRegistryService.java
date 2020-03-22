package ru.otus.spring.mongo.service;

import ru.otus.spring.mongo.domain.Genre;
import ru.otus.spring.mongo.exception.DaoException;
import ru.otus.spring.mongo.domain.Author;

import java.util.Optional;

public interface LibraryRegistryService {
    Optional<Genre> addNewGenre(String genreName);

    void removeGenre(String genreId) throws DaoException;

    Optional<Author> addAuthor(String authorName);

    void removeAuthor(String authorId) throws DaoException;
}
