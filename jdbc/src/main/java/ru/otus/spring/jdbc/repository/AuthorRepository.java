package ru.otus.spring.jdbc.repository;

import ru.otus.spring.jdbc.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    int count();

    Optional<Author> getById(long id);

    List<Author> getAll();

    boolean deleteById(long id);

    Author insert(String authorName);

}
