package be.abis.exercises.service;

import org.springframework.stereotype.Service;

import be.abis.exercises.model.Person;

@Service
public class AbisPersonService implements PersonService {
	
	@Override
	public Person getPerson(int id) {
		
		return new Person("Peter", "Otto'");
	}

}
