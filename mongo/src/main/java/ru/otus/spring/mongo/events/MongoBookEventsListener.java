package ru.otus.spring.mongo.events;

import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.stereotype.Component;
import ru.otus.spring.mongo.domain.Book;
import ru.otus.spring.mongo.repository.BookCommentRepository;

@Component
@RequiredArgsConstructor
public class MongoBookEventsListener extends AbstractMongoEventListener<Book> {
    private final BookCommentRepository commentRepository;

    @Override
    public void onAfterDelete(AfterDeleteEvent<Book> event) {
        super.onAfterDelete(event);
        final Document source = event.getSource();
        final String id = source.get("_id").toString();
        commentRepository.removeCommentsForBookWithId(id);
    }
}
