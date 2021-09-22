package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.PuppyItem;

public class ListPuppyHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PuppyList");
	
	public void insertItem(PuppyItem pi) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(pi);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<PuppyItem> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<PuppyItem> allItems = em.createQuery("SELECT i from PuppyItem i").getResultList();
		return allItems;
		
	}

	public void deleteItem(PuppyItem toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PuppyItem> typedQuery = em.createQuery("select pi from PuppyItem pi where pi.puppy = :selectedPuppy and pi.breed = :selectedBreed", PuppyItem.class);
		
		typedQuery.setParameter("selectedPuppy", toDelete.getPuppy());
		typedQuery.setParameter("selectedBreed", toDelete.getBreed());
		
		typedQuery.setMaxResults(1);
		
		PuppyItem result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public PuppyItem searchForBreedById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		PuppyItem found = em.find(PuppyItem.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(PuppyItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<PuppyItem> searchForBreedByPuppy(String puppyName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PuppyItem> typedQuery = em.createQuery("select pi from PuppyItem pi where pi.puppy = :selectedPuppy", PuppyItem.class);
		
		typedQuery.setParameter("selectedPuppy", puppyName);
		
		List<PuppyItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<PuppyItem> searchForBreedByBreed(String breedName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PuppyItem> typedQuery = em.createQuery("select pi from PuppyItem pi where pi.breed = :selectedBreed", PuppyItem.class);
		
		typedQuery.setParameter("selectedBreed", breedName);
		
		List<PuppyItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	
	
	public void cleanUp() {
		emfactory.close();
	}
	
}