package ru.otus.spring.mongo.repository;

public interface BookCommentRepositoryCustomized {
    void removeCommentsForBookWithId(String bookId);
}
