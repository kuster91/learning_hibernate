package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Employee;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Employee emp = new Employee();
		emp.setFirstName("Jan");
		emp.setLastName("Kowalski");
		emp.setSalary(2000);

		entityManager.getTransaction().begin();
		entityManager.persist(emp);
		entityManager.getTransaction().commit();

		entityManager.clear();
		entityManagerFactory.close();
	}
}
