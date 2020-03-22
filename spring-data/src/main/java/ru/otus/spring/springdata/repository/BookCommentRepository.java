package ru.otus.spring.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.springdata.domain.Book;
import ru.otus.spring.springdata.domain.BookComment;

import java.util.List;

public interface BookCommentRepository extends JpaRepository<BookComment, Long> {
    List<BookComment> getAllByBook(Book book);
}
