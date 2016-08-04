package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Employee;

public class Main {
	public static void main(String[] args){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		Employee emp = new Employee();
		
//		emp.setId(1L);
		emp.setFirstName("Jan");
		emp.setLastName("Kowalski");
		emp.setSalary(2000);
		
		Employee emp2 = new Employee();
//		emp.setId(1L);
		emp2.setFirstName("Jan");
		emp2.setLastName("Kowalski");
		emp2.setSalary(2000);
		
		entityManager.getTransaction().begin();
		entityManager.persist(emp);
		entityManager.persist(emp2);
		
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		entityManagerFactory.close();
		
	}
}
