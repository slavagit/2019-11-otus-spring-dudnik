package ru.otus.spring.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.mongo.domain.Genre;

import java.util.Optional;

public interface GenreRepository extends MongoRepository<Genre, String> {
    Optional<Genre> findByNameIgnoreCase(String name);

}
