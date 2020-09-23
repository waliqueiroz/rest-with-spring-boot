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

import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping(produces = { "application/json", "application/xml" })
	public List<PersonVO> findAll() {
		return personService.findAll();
	}

	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
	public PersonVO findById(@PathVariable Long id) {
		return personService.findById(id);
	}

	@PostMapping(consumes = { "application/json", "application/xml" }, produces = { "application/json",
			"application/xml" })
	public PersonVO create(@RequestBody PersonVO person) {
		return personService.create(person);
	}

	@PutMapping(consumes = { "application/json", "application/xml" }, produces = { "application/json",
			"application/xml" })
	public PersonVO update(@RequestBody PersonVO person) {
		return personService.create(person);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		personService.delete(id);
	}

}
