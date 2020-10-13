package be.abis.exercise.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;

@Service
public class ApiPersonService implements PersonService {
	
	@Autowired
	private RestTemplate rt;
	
	private String baseUri = "http://localhost:8085.exercise/api/persons";


	//@Override
	//public ArrayList<Person> getAllPersons() {
	//	return personRepository.getAllPersons();
	//}

	//@Override
	//public Person findPerson(int id) {
	//	return personRepository.findPerson(id);
	//}

	@Override
	public Person findPerson(String email , String password) {
		Login login = new Login();
		login.setEmail(email);
		login.setPassword(password);
		Person p = rt.postForObject(baseUri + "/login", login, Person.class);
		return p;
	}

	//@Override
	//public void addPerson(Person p) throws IOException {
	//	personRepository.addPerson(p);		
	//}

	//@Override
	//public void deletePerson(int id) throws PersonCanNotBeDeletedException {
	//	personRepository.deletePerson(id);		
	//}

	//@Override
	//public void changePassword(Person p, String newPswd) throws IOException {
	//	personRepository.changePassword(p, newPswd);		
	//}
}
