package ru.otus.spring.mongo.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.mongo.domain.Genre;
import ru.otus.spring.mongo.exception.DaoException;
import ru.otus.spring.mongo.domain.Author;

import java.util.Optional;

@Service
public class LibraryRegistryServiceImpl implements LibraryRegistryService {
    @Override
    public Optional<Genre> addNewGenre(String genreName) {
        return Optional.empty();
    }

    @Override
    public void removeGenre(String genreId) throws DaoException {

    }

    @Override
    public Optional<Author> addAuthor(String authorName) {
        return Optional.empty();
    }

    @Override
    public void removeAuthor(String authorId) throws DaoException {

    }
}
