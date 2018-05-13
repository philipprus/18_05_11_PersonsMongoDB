package telran.persons.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.persons.dao.IPersonsDao;
import telran.persons.dto.Person;
import telran.persons.dto.PersonsApiConstants;
import telran.persons.dto.ServiceUpdateName;

@SpringBootApplication
@ComponentScan(basePackages="telran.persons.dao")
@EnableMongoRepositories("telran.persons.mongo.repo")
@RestController
public class PersonsRestController {
	
	@Autowired
	IPersonsDao persons;
//	@GetMapping("/")
//	String onlyForTest() {
//		persons.addPerson(new Person(123, "Petr", LocalDate.of(1970, 1, 20)));
//		return "OK";
//	}
	
	@GetMapping(value = PersonsApiConstants.GET_PERSON)
	Person getPerson(int id) {
		Person person = persons.getPerson(id);
		return person;
	}
	
	@PostMapping(value = PersonsApiConstants.REMOVE_PERSON)
	Boolean removePerson(@RequestBody int id){
		return persons.removePerson(id);
	}
	
	
	@PostMapping(value = PersonsApiConstants.ADD_PERSON)
	Boolean addPerson(@RequestBody Person person){
		return persons.addPerson(person);
	}
	
	
	@PostMapping(value = PersonsApiConstants.UPDATE_NAME)
	Boolean updateName(@RequestBody ServiceUpdateName sun){
		return persons.updateName(sun.getId(), sun.getNewName());
	}
	
	

	public static void main(String[] args) {
		
		SpringApplication.run(PersonsRestController.class, args);
		
		

	}

}
