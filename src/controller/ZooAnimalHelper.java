/***************************************************************
 * Name : ZooAnimalHelper.java
 * Author: Devin Baack 
 * Created : 02/11/2021 
 * Course: CIS 175 - Java II
 * Version: 10.15.7 
 * OS: macOS Catalina 
 * IDE: Eclipse 2020-06
 * Copyright : This is my own original work based on specifications 
 * issued by our instructor 
 * Description : This program contains all of the implementation and logic for Zoo Animal.
 * Academic Honesty: I attest that this is my original work. I have
 * not used unauthorized source code, either modified or unmodified. 
 * I have not given other fellow student(s) access to my program.
 ***************************************************************
 */
 
package controller;

/**
 * @author Devin Baack - dfbaack
 * CIS175 - Spring 2021
 * Feb 11, 2021
 */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ZooAnimal;

public class ZooAnimalHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ZooAnimals");

	public void insertAnimal(ZooAnimal za) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(za);
		em.getTransaction().commit();
		em.close();
	}

	public List<ZooAnimal> showAllAnimals(){
		EntityManager em = emfactory.createEntityManager();
		List<ZooAnimal> allItems = em.createQuery("SELECT z FROM ZooAnimal z").getResultList();
		return allItems;
	}
	
	public void deleteAnimal(ZooAnimal toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ZooAnimal> typedQuery = em.createQuery("select za from ZooAnimal za where za.id = :selectedID", ZooAnimal.class);
	
		typedQuery.setParameter("selectedID", toDelete.getId());
	
		typedQuery.setMaxResults(1);
		
		ZooAnimal result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();;
		em.close();
	}
	
	public void updateAnimal(ZooAnimal toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();

	}
	
	/**
	 * @param idToEdit
	 * @return
	 */
	public ZooAnimal searchForAnimalById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ZooAnimal found = em.find(ZooAnimal.class, idToEdit);
		em.close();
		return found;

	}
	
	/**
	 * @param animal
	 * @return
	 */
	public List<ZooAnimal> searchForAnimalByAnimal(String animal) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ZooAnimal> typedQuery = em.createQuery("select za from ZooAnimal za where za.animal = :selectedAnimal", ZooAnimal.class);
		typedQuery.setParameter("selectedAnimal", animal);
		
		List<ZooAnimal> foundAnimals = typedQuery.getResultList();
		em.close();
		return foundAnimals;
	}

	/**
	 * @param gender
	 * @return
	 */
	public List<ZooAnimal> searchForAnimalByGender(String gender) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ZooAnimal> typedQuery = em.createQuery("select za from ZooAnimal za where za.gender = :selectedGender", ZooAnimal.class);
		typedQuery.setParameter("selectedGender", gender);

		List<ZooAnimal> foundAnimals = typedQuery.getResultList();
		em.close();
		return foundAnimals;

	}
	
	public List<ZooAnimal> searchForAnimalByAge(int age) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ZooAnimal> typedQuery = em.createQuery("select za from ZooAnimal za where za.age = :selectedAge", ZooAnimal.class);
		typedQuery.setParameter("selectedAge", age);

		List<ZooAnimal> foundAnimals = typedQuery.getResultList();
		em.close();
		return foundAnimals;

	}
	
	public void cleanUp(){
		emfactory.close();
	}
}
