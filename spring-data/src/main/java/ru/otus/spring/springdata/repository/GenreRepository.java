package ru.otus.spring.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.springdata.domain.Genre;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Optional<Genre> findByNameIgnoreCase(String name);
}
