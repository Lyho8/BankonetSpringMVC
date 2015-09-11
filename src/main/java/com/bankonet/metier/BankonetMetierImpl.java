package com.bankonet.metier;

import java.util.ArrayList;
import java.util.List;










import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.dao.IClientDao;
import com.bankonet.model.Client;

//@Service("metier")
public class BankonetMetierImpl implements IBankonetMetier {

	//@Resource(name="dao")
	private  IClientDao	dao;
	
	public  void  setDao(IClientDao	dao)  { 
		this.dao= dao;
	}

	@Transactional
	public void addClient(Client c) {
			dao.addClient(c);
	}

	@Transactional(readOnly=true)
	public List<Client> listClients() {
		return  dao.listClients();
	}

	@Transactional
	public void deleteClient(int idClient) {
		dao.deleteClient(idClient);
	}

	@Transactional(readOnly=true)
	public Client editClient(int idClient) {
		return dao.editClient(idClient);
	}

	@Transactional
	public void updateClient(Client c) {
		dao.updateClient(c);
		
	}

	@Transactional(readOnly=true)
	public List<Client> chercherClients(String motCle) {
		List<Client> mylist = new ArrayList<Client>();
		mylist = dao.chercherClients(motCle);
		return mylist;
	}

	@Transactional
	public List<Client> SupprimerClientDontLeNomContient(String mot_cle) {
		
		for (Client c : dao.chercherClients(mot_cle)) {
			dao.deleteClient(c.getId());
		}
		return dao.listClients();
		
	}
	
}
