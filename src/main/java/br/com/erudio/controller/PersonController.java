package br.com.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Person;
import br.com.erudio.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping
	public Person create(@RequestBody Person person) {
		return personService.create(person);
	}

	@PutMapping
	public Person update(@RequestBody Person person) {
		return personService.create(person);
	}

	@GetMapping("/{id}")
	public Person findById(@PathVariable Long id) {
		return personService.findById(id);
	}

	@GetMapping
	public List<Person> findAll() {
		return personService.findAll();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		personService.delete(id);
	}

}
