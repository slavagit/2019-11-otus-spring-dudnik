package ru.otus.spring.mongo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.spring.mongo.domain.Author;
import ru.otus.spring.mongo.domain.Book;
import ru.otus.spring.mongo.domain.Genre;
import ru.otus.spring.mongo.exception.DaoException;
import ru.otus.spring.mongo.repository.AuthorRepository;
import ru.otus.spring.mongo.repository.BookRepository;
import ru.otus.spring.mongo.repository.GenreRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest(classes = LibraryStorageServiceImpl.class)
@DisplayName(" сервис управления книгами в библиотеке должен ")
class LibraryStorageServiceImplTest {

    private final static String BOOK_NAME = "TestBook";
    private final static String GENRE_NAME = "TestGenre";

    private final static String EXISTING_AUTHOR_ID = "EXISTING_ID";
    private final static String EXISTING_GENRE_ID = "EXISTING_GENRE_ID";
    private final static String MISSING_ON_BOOK_GENRE_ID = "MISSING_ON_BOOK_GENRE_ID";
    private final static String MISSING_AUTHOR_ID = "MISSING_ID";

    @Mock
    private Author testAuthor;
    @Mock
    private Book testBook;
    @Mock
    private Genre testGenre;

    @MockBean
    private BookRepository bookRepository;
    @MockBean
    private AuthorRepository authorRepository;
    @MockBean
    private GenreRepository genreRepository;
    @Autowired
    private LibraryStorageService libraryStorageService;

    @BeforeEach
    void setUp() {
        given(authorRepository.findById(eq(EXISTING_AUTHOR_ID))).willReturn(Optional.of(testAuthor));
        given(authorRepository.findById(eq(MISSING_AUTHOR_ID))).willReturn(Optional.empty());
        given(genreRepository.findByNameIgnoreCase(anyString())).willReturn(Optional.of(testGenre));
        given(bookRepository.save(any())).willReturn(testBook);
        given(bookRepository.findById(anyString())).willReturn(Optional.of(testBook));
        given(authorRepository.save(any())).willReturn(testAuthor);
        given(authorRepository.existsByNameEqualsIgnoreCase(EXISTING_AUTHOR_ID)).willReturn(true);
        given(bookRepository.hasBookWithSingleGenreId(EXISTING_GENRE_ID)).willReturn(true);
        given(bookRepository.hasBookWithSingleAuthorId(EXISTING_AUTHOR_ID)).willReturn(true);
    }

    @Test
    @DisplayName(" корректно добавлять книгу в библиотеку при вводе верных данных")
    void addNewBookCorrect() throws DaoException {
        final Optional<Book> bookGenericDaoResult = libraryStorageService.addNewBook(BOOK_NAME, EXISTING_AUTHOR_ID, GENRE_NAME);
        assertThat(bookGenericDaoResult)
                .isPresent()
                .get()
                .isEqualTo(testBook);
    }

    @Test
    @DisplayName(" выкидывать исключение об отстутвии автора добавления книги  в библиотеку при вводе несуществующего автора")
    void addNewBookAuthorInCorrect() {
        assertThrows(DaoException.class, () -> libraryStorageService.addNewBook(BOOK_NAME, MISSING_AUTHOR_ID, GENRE_NAME));
    }

    @Test
    @DisplayName(" выкидывать исключение  добавления книги в библиотеку при вводе некорректного жанра")
    void addNewBookGenreInCorrect() {
        assertThrows(DaoException.class, () -> libraryStorageService.addNewBook(BOOK_NAME, EXISTING_AUTHOR_ID, null));
    }

    @Test
    @DisplayName(" корректно удалять книгу из библиотеки")
    void deleteBook() {
        final boolean deleteBook = libraryStorageService.deleteBook("ANY_ID");
        assertTrue(deleteBook);
    }

    @Test
    @DisplayName(" корректно добавлять автора в библиотеку")
    void addNewAuthorCorrect() throws DaoException {
        final Optional<Author> author = libraryStorageService.addNewAuthor("Some author");
        assertThat(author).isPresent()
                .get()
                .isEqualTo(testAuthor);
    }

    @Test
    @DisplayName(" выдавать исключение при попытке добавить существующего автора в библиотеку")
    void addNewAuthorInCorrect() throws DaoException {
        assertThrows(DaoException.class, () -> libraryStorageService.addNewAuthor(EXISTING_AUTHOR_ID));
    }

    @Test
    @DisplayName(" выдавать исключение при попытке удалять жанр из библиотеки, если он привязан к книгам")
    void deleteGenreInCorrect() throws DaoException {
        assertThrows(DaoException.class, () -> libraryStorageService.deleteGenre(EXISTING_GENRE_ID));
    }

    @Test
    @DisplayName(" выдавать исключение при попытке удалять автора из библиотеки, если он привязан к книгам как единственный автор")
    void deleteAuthorInCorrect() throws DaoException {
        assertThrows(DaoException.class, () -> libraryStorageService.deleteAuthor(EXISTING_AUTHOR_ID));
    }

}