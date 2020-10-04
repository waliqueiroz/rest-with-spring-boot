package br.com.erudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Page<PersonVO> findAll(Pageable pageable) {
        Page<Person> entities = personRepository.findAll(pageable);
        return entities.map(this::convertToPersonVo);
    }

    public Page<PersonVO> findPersonByName(String firstName, Pageable pageable) {
        Page<Person> entities = personRepository.findPersonByName(firstName, pageable);
        return entities.map(this::convertToPersonVo);
    }

    private PersonVO convertToPersonVo(Person person) {
        return DozerConverter.parseObject(person, PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        var entity = DozerConverter.parseObject(person, Person.class);
        var vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO update(PersonVO person) {

        var entity = personRepository.findById(person.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO findById(Long id) {
        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));

        var vo = DozerConverter.parseObject(entity, PersonVO.class);
        return vo;

    }

    public void delete(Long id) {
        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));

        personRepository.delete(entity);
    }

    @Transactional
    public PersonVO disablePerson(Long id) {
        personRepository.disablePerson(id);
        return findById(id);
    }

}
