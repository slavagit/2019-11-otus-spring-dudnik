package ru.otus.spring.jdbc.repository;

import ru.otus.spring.jdbc.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository {
    int count();

    Optional<Genre> getById(long id);

    List<Genre> getAll();

    boolean deleteById(long id);

    Genre insert(String genreName);
}
