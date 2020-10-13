package be.abis.exercise.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	PersonService personservice;
	
	@GetMapping("persons/{id}")
	public Person findPersonById(@PathVariable("id") int id) {
		return personservice.findPerson(id);
	}
	
	@PostMapping("persons/login")
	public Person findPersonByMailAndPwd(@RequestBody Login login){
		Person p1 = personservice.findPerson(login.getEmail(), login.getPassword());
		return p1;
	}
	
	@PostMapping("persons")
	public void newPerson(@RequestBody Person person) throws IOException {
		personservice.addPerson(person);
	}
	
	@PutMapping("persons/{id}")
	public void changePW(@PathVariable("id") int id, @RequestBody Person person) throws IOException {
		Person personOld = personservice.findPerson(id);
		String pwd = person.getPassword();
		personservice.changePassword(personOld, pwd);
	}
	
	@PostMapping("persons/delete/{id}")
	public void deletePerson(@PathVariable("id") int id) throws PersonCanNotBeDeletedException {
		personservice.deletePerson(id);
	}
	
	@GetMapping("persons")
	public ArrayList<Person> findAllPersons() {
		return personservice.getAllPersons();
	}
			
	

}
