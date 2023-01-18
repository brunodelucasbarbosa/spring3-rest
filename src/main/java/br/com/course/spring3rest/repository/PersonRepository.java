package br.com.course.spring3rest.repository;

import br.com.course.spring3rest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}
