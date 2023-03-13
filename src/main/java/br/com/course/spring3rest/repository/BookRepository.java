package br.com.course.spring3rest.repository;

import br.com.course.spring3rest.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
