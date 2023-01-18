package br.com.course.spring3rest.controller;

import br.com.course.spring3rest.dto.PersonDTO;
import br.com.course.spring3rest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping
    public PersonDTO create(@RequestBody PersonDTO person) {
        return personService.create(person);
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable(value = "id") Long id) {
        return personService.findById(id);
    }

    @GetMapping
    public List<PersonDTO> findAll() {
        return personService.findAll();
    }

    @PutMapping
    public PersonDTO update(@RequestBody PersonDTO person) {
        return personService.update(person);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
