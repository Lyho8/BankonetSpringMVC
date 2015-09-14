package com.bankonet.metier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bankonet.dao.ICompteDao;
import com.bankonet.model.Compte;

public class BankonetCompteMetierImpl implements IBankonetCompteMetier {

	// @Resource(name="danao")
	private ICompteDao danao;

	public void setDanao(ICompteDao danao) {
		this.danao = danao;
	}

	@Transactional
	public void addCompte(Compte c) {
		danao.addCompte(c);
	}

	@Transactional(readOnly = true)
	public List<Compte> listComptes() {
		return danao.listComptes();
	}
	
	@Transactional(readOnly = true)
	public List<Compte> listComptes(int idClient) {
		return danao.listComptes(idClient);
	}

	@Transactional
	public void deleteCompte(int idCompte) {
		danao.deleteCompte(idCompte);
	}

	@Transactional(readOnly = true)
	public Compte editCompte(int idCompte) {
		return danao.editCompte(idCompte);
	}

	@Transactional
	public void updateCompte(Compte c) {
		danao.updateCompte(c);

	}

	@Transactional(readOnly = true)
	public List<Compte> chercherComptes(String motCle) {
		List<Compte> mylist = new ArrayList<Compte>();
		mylist = danao.chercherComptes(motCle);
		return mylist;
	}

}
