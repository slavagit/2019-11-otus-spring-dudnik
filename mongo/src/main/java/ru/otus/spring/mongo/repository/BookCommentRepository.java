package ru.otus.spring.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.mongo.domain.BookComment;

import java.util.List;

public interface BookCommentRepository extends MongoRepository<BookComment, String>,BookCommentRepositoryCustomized{
    List<BookComment> findAllByBook_Id(String bookId);
}
