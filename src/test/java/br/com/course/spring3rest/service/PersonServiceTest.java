package br.com.course.spring3rest.service;

import br.com.course.spring3rest.exception.RequiredObjectNullException;
import br.com.course.spring3rest.repository.PersonRepository;
import br.com.course.spring3rest.units.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    MockPerson input;

    @InjectMocks
    private PersonService service;

    @Mock
    PersonRepository repository;

    @BeforeEach
    void setUp() {
        input = new MockPerson();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create() {
        var person = input.mockEntity(1);
        var persisted = person;
        persisted.setId(1L);

        var dto = input.mockVO(1);
        dto.setKey(1L);

        when(repository.save(person)).thenReturn(persisted);
        var result = service.create(dto);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        System.out.println(result.toString());
        //assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=]"));
        assertEquals("Addres Test1", result.getAddress());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Female", result.getGender());
    }

    @Test
    void createWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectNullException.class, () -> {
            service.create(null);
        });

        var excpectedMessage = "Not found object required.";
        var actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(excpectedMessage));
    }

    @Test
    void createV2() {
    }

    @Test
    void findById() {
        var person = input.mockEntity(1);
        person.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(person));

        var result = service.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        System.out.println(result.toString());
        //assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=]"));
        assertEquals("Addres Test1", result.getAddress());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Female", result.getGender());

    }


    @Test
    void findAll() {
        var listPersons = input.mockEntityList();

        when(repository.findAll()).thenReturn(listPersons);

        var result = service.findAll();
        assertNotNull(result);
    }

    @Test
    void update() {
        var person = input.mockEntity(1);
        person.setId(1L);
        var persisted = person;
        persisted.setId(1L);

        var dto = input.mockVO(1);
        dto.setKey(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(person));
        when(repository.save(person)).thenReturn(persisted);

        var result = service.update(dto);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        System.out.println(result.toString());
        assertEquals("Addres Test1", result.getAddress());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Female", result.getGender());
    }

    @Test
    void delete() {
        var person = input.mockEntity(1);
        person.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(person));

        service.delete(1L);
    }


}