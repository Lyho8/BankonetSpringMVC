package com.bankonet.metier;

import java.util.List;

import com.bankonet.model.Compte;

public interface IBankonetCompteMetier {
	
	public void addCompte(Compte c); 
	public List<Compte> listComptes();
	public List<Compte> listComptes(int idClient);
	public void	deleteCompte(int idCompte);
	public Compte editCompte(int idCompte);
	public void	updateCompte(Compte c);
	public List<Compte>	chercherComptes(String	motCle);

}
