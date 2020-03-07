package ru.otus.spring.springdata.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.springdata.domain.Author;
import ru.otus.spring.springdata.domain.Book;
import ru.otus.spring.springdata.domain.Genre;
import ru.otus.spring.springdata.exception.DaoException;
import ru.otus.spring.springdata.repository.AuthorRepository;
import ru.otus.spring.springdata.repository.BookRepository;
import ru.otus.spring.springdata.repository.GenreRepository;

import java.util.Objects;
import java.util.Optional;

@Service
public class LibraryStorageServiceImpl implements LibraryStorageService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;

    public LibraryStorageServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository, GenreRepository genreRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    @Transactional(rollbackFor = DaoException.class)
    public Optional<Book> addNewBook(String name, long authorId, String genreName) throws DaoException {
        if (Objects.isNull(genreName)) {
            throw new DaoException("Genre name cannot be null");
        }
        final Optional<Author> authorOptional = authorRepository.findById(authorId);
        final Optional<Genre> genreInfo = genreRepository.findByNameIgnoreCase(genreName);

        final Author author = authorOptional.orElseThrow(() -> new DaoException("Author not found"));
        final Genre genre = genreInfo.orElseGet(() -> genreRepository.save(new Genre(genreName)));
        return Optional.of(bookRepository.save(new Book(name, author, genre)));
    }

    @Override
    @Transactional
    public boolean deleteBook(long bookId) {
        final Optional<Book> book = bookRepository.findById(bookId);
        book.ifPresent(bookRepository::delete);
        return book.isPresent();
    }
}
