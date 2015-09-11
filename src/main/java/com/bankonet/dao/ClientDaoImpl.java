package com.bankonet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.model.Client;

//@Repository("dao")
public class ClientDaoImpl implements IClientDao {

	// TP6 - Exercice 6.6 : Injection du PersistenceContext par annotation
	@PersistenceContext
	private  EntityManager  entityManager;
	

	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	// --- Gestion des transactions et des exceptions dans addClient ---
	// Commenter/décommenter les lignes pour lever l'exception checked ou unchecked
	// ATTENTION : si présence d'un aspect Aroud qui gère les exceptions levée,
	// le rollback ne sera pas possible car l'exception sera interceptée par l'aspect ! --> commenter l'aspect
	
	@Transactional(propagation=Propagation.MANDATORY)
	public void addClient(Client c) {
	//public void addClient(Client c) throws Exception {
	//public void addClient(Client c) throws RuntimeException {
		
		entityManager.persist(c);
		
		//throw new RuntimeException("Erreur unchecked!");
		//throw new Exception("Erreur checked!");
	}

	@Transactional(readOnly=true, propagation=Propagation.MANDATORY)
	public List<Client> listClients() {
		
		Query req=entityManager.createQuery("select c from Client c");
		return  req.getResultList();
	}

	@Transactional(propagation=Propagation.MANDATORY)
	public void deleteClient(int idClient) {
		Client c=entityManager.find(Client.class,idClient);
		entityManager.remove(c);
	}

	@Transactional(readOnly=true, propagation=Propagation.MANDATORY)
	public Client editClient(int idClient) {
		Client c=entityManager.find(Client.class,idClient);
		return c;
	}

	@Transactional(propagation=Propagation.MANDATORY)
	public void updateClient(Client c) {
		entityManager.merge(c);
		
	}

	@Transactional(readOnly=true, propagation=Propagation.MANDATORY)
	public List<Client> chercherClients(String motCle) {
		Query req=entityManager.createQuery("select c from Client c  where c.nom like :x or c.prenom like :x");
		req.setParameter("x",  "%"+motCle+"%");
		return  req.getResultList();
	}

}
