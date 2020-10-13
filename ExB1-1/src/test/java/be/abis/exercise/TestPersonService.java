package be.abis.exercise;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;

public class TestPersonService {

PersonService ps;
String email;
String password;
	
	@Before
	public void setUp() {
		this.email = "mjones@abis.be";
		this.password = "abc986";
	}
	
	@Test
	public void idOfPersonReturnedIs3() {
		Person p = ps.findPerson(this.email, this.password);
		
		int id = p.getPersonId();
		System.out.println("Id number : " + id);
		assertEquals(3,id);
	}
	
	
}
