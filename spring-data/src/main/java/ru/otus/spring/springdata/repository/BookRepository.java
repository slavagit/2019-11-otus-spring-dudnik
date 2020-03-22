package ru.otus.spring.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.springdata.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
