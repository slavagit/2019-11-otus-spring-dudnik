package ru.otus.spring.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.springdata.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
