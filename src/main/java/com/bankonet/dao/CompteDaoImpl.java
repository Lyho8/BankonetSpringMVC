package com.bankonet.dao;

import java.util.*;

import javax.persistence.*;

import org.springframework.transaction.annotation.*;

import com.bankonet.model.*;

public class CompteDaoImpl implements ICompteDao {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void addCompte(Compte c) {
		entityManager.persist(c);
	}

	@Transactional(readOnly = true, propagation = Propagation.MANDATORY)
	public List<Compte> listComptes() {
		Query req = entityManager.createQuery("select c from Compte c");
		return req.getResultList();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.MANDATORY)
	public List<Compte> listComptes(int idClient) {
		Query req = entityManager.createQuery("select c from Compte c where c.client.id=:idClient")
				.setParameter("idClient", idClient);
		return req.getResultList();
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void deleteCompte(int idCompte) {
		Compte c = entityManager.find(Compte.class, idCompte);
		entityManager.remove(c);
	}

	@Transactional(readOnly = true, propagation = Propagation.MANDATORY)
	public Compte editCompte(int idCompte) {
		Compte c = entityManager.find(Compte.class, idCompte);
		return c;
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void updateCompte(Compte c) {
		entityManager.merge(c);

	}

	@Transactional(readOnly = true, propagation = Propagation.MANDATORY)
	public List<Compte> chercherComptes(String motCle) {
		Query req = entityManager
				.createQuery("select c from Compte c  where c.libelle like :x");
		req.setParameter("x", "%" + motCle + "%");
		return req.getResultList();
	}

}
