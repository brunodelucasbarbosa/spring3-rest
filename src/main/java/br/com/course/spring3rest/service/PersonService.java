package br.com.course.spring3rest.service;

import br.com.course.spring3rest.config.mapper.DozerMapper;
import br.com.course.spring3rest.config.mapper.custom.PersonMapper;
import br.com.course.spring3rest.dto.PersonDTO;
import br.com.course.spring3rest.dto.PersonDTOV2;
import br.com.course.spring3rest.exception.ResourceNotFoundException;
import br.com.course.spring3rest.model.Person;
import br.com.course.spring3rest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper mapper;

    public PersonDTO create(PersonDTO person) {
        logger.info("Creating person: " + person);
        var entity = DozerMapper.parseObject(person, Person.class);
        return DozerMapper.parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public PersonDTOV2 createV2(PersonDTOV2 person) {
        logger.info("Creating person: " + person);
        var entity = mapper.convertDTOToEntity(person);
        return mapper.convertEntityToDTO(personRepository.save(entity));
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding person by id: " + id);

        var person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        return DozerMapper.parseObject(person, PersonDTO.class);
    }

    public List<PersonDTO> findAll() {
        logger.info("Finding all persons");
        return DozerMapper.parseListObjects(personRepository.findAll(), PersonDTO.class);
    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Updating person");

        var personExists = personRepository.findById(person.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Person not found"));

        personExists.setFirstName(person.getFirstName() != null ? person.getFirstName() : personExists.getFirstName());
        personExists.setLastName(person.getLastName() != null ? person.getLastName() : personExists.getLastName());
        personExists.setAddress(person.getAddress() != null ? person.getAddress() : personExists.getAddress());
        personExists.setGender(person.getGender() != null ? person.getGender() : personExists.getGender());

        return DozerMapper.parseObject(personRepository.save(personExists), PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting person");
        var personExists = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        personRepository.delete(personExists);
    }
}
