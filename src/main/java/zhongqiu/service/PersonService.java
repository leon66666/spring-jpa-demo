package zhongqiu.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import zhongqiu.bean.Person;

@Transactional
public class PersonService {
	@PersistenceContext
	private EntityManager em;

	public void save(Person person) {
		em.persist(person);
	}

	public void update(Person person) {
		em.merge(person);
	}

	public void delete(Integer personid) {
		em.remove(em.getReference(Person.class, personid));
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Person getPerson(Integer personid) {
		return em.find(Person.class, personid);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Person> getPersons() {
		return em.createQuery("select o from Person o").getResultList();
	}
}
