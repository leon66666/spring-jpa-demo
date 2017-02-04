package zhongqiu.test;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import zhongqiu.bean.Person;
import zhongqiu.service.PersonService;

public class PersonServiceTest {

	private static PersonService personService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/beans.xml");
			personService = (PersonService) context.getBean("personService");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSave() {
		personService.save(new Person("张三"));
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPerson() {
		Person person = personService.getPerson(1);
		System.out.println(person.getName());
	}

	@Test
	public void testGetPersons() {
		List<Person> persons = personService.getPersons();
		for (Person person : persons) {
			System.out.println(person.getName());
		}
	}
}
