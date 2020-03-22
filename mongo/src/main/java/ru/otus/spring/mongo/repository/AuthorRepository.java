package ru.otus.spring.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.mongo.domain.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {
    boolean existsById(String id);

    boolean existsByNameEqualsIgnoreCase(String name);
}
