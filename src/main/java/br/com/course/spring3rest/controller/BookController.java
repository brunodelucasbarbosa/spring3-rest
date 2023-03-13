package br.com.course.spring3rest.controller;

import br.com.course.spring3rest.dto.BookDTO;
import br.com.course.spring3rest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/book")
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    public BookDTO create(@RequestBody BookDTO book) {

        System.out.println("localdate time: " +LocalDateTime.now());
        System.out.println("timestamp: " + new Timestamp(System.currentTimeMillis()));
        return bookService.create(book);
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable(value = "id") Long id) {
        return bookService.findById(id);
    }

    @GetMapping
    public List<BookDTO> findAll() {
        return bookService.findAll();
    }

    @PutMapping
    public BookDTO update(@RequestBody BookDTO book) {
        return bookService.update(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
