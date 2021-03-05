/**
 * 
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ZooAnimal;
import model.ZooKeeper;

/**
 * @author Devin Baack - dfbaack
 * CIS175 - Spring 2021
 * Mar 4, 2021
 */
public class ZooKeeperHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ZooKeepers");
	
	public void insertZooKeeper(ZooKeeper zk) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(zk);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ZooKeeper> showAllZooKeepers(){
		EntityManager em = emfactory.createEntityManager();
		List<ZooKeeper> allZooKeepers = em.createQuery("SELECT z FROM ZooKeeper z").getResultList();
		return allZooKeepers;
	}
	
	public void deleteZooKeeper(ZooKeeper toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ZooKeeper> typedQuery = em.createQuery("select zk from ZooKeeper zk where zk.id = :selectedID", ZooKeeper.class);
	
		typedQuery.setParameter("selectedID", toDelete.getId());
	
		typedQuery.setMaxResults(1);
		
		ZooKeeper result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();;
		em.close();
	}
	
	public void updateZooKeeper(ZooKeeper toEdit) {
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
	public ZooKeeper searchForZooKeeperById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ZooKeeper found = em.find(ZooKeeper.class, idToEdit);
		em.close();
		return found;

	}
	
	/**
	 * @param name
	 * @return
	 */
	public List<ZooKeeper> searchForZooKeeperByName(String name) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ZooKeeper> typedQuery = em.createQuery("select zk from ZooKeeper zk where zk.name = :selectedName", ZooKeeper.class);
		typedQuery.setParameter("selectedName", name);
		
		List<ZooKeeper> foundAnimals = typedQuery.getResultList();
		em.close();
		return foundAnimals;
	}

	/**
	 * @param department
	 * @return
	 */
	public List<ZooKeeper> searchForZooKeeperByDepartment(String department) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ZooKeeper> typedQuery = em.createQuery("select zk from ZooKeeper zk where zk.department = :selectedDepartment", ZooKeeper.class);
		typedQuery.setParameter("selectedDepartment", department);

		List<ZooKeeper> foundAnimals = typedQuery.getResultList();
		em.close();
		return foundAnimals;

	}
	
	public void cleanUp(){
		emfactory.close();
	}
	
}
