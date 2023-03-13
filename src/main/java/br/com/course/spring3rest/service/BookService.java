package br.com.course.spring3rest.service;

import br.com.course.spring3rest.config.mapper.DozerMapper;
import br.com.course.spring3rest.dto.BookDTO;
import br.com.course.spring3rest.exception.RequiredObjectNullException;
import br.com.course.spring3rest.exception.ResourceNotFoundException;
import br.com.course.spring3rest.model.Book;
import br.com.course.spring3rest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BookService {

    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private BookRepository bookRepository;

    public BookDTO create(BookDTO book) {
        if (book == null) throw new RequiredObjectNullException();

        logger.info("Creating book: " + book);
        var entity = DozerMapper.parseObject(book, Book.class);
        var dto = DozerMapper.parseObject(bookRepository.save(entity), BookDTO.class);
        return dto;
    }

    public BookDTO findById(Long id) {
        logger.info("Finding book by id: " + id);

        var book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("book not found"));
        var dto = DozerMapper.parseObject(book, BookDTO.class);

        return dto;
    }

    public List<BookDTO> findAll() {
        logger.info("Finding all books");
        var books = DozerMapper.parseListObjects(bookRepository.findAll(), BookDTO.class);

        return books;
    }

    public BookDTO update(BookDTO book) {
        logger.info("Updating person");

        var bookExists = bookRepository.findById(book.getKey()).orElseThrow(
                () -> new ResourceNotFoundException("Person not found"));

        bookExists.setAuthor(bookExists.getAuthor());
        bookExists.setLaunchDate(bookExists.getLaunchDate());
        bookExists.setPrice(bookExists.getPrice());
        bookExists.setTitle(bookExists.getTitle());

        var dto = DozerMapper.parseObject(bookRepository.save(bookExists), BookDTO.class);
        return dto;
    }

    public void delete(Long id) {
        logger.info("Deleting book by id: " + id);
        var personExists = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        bookRepository.delete(personExists);
    }
}
