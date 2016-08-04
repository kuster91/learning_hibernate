package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Employee;

public class FindAndModify {
	public static void main(String[] args){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		Employee employee = entityManager.find(Employee.class, 1L);
		System.out.println("First name:" + employee.getFirstName()+", last name: "+employee.getLastName()+", salary:"+employee.getSalary());
		employee.setSalary(666);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
}
