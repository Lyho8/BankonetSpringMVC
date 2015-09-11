 package com.bankonet.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@DiscriminatorValue("C")
public class Client extends Personne  {
	
	@NotNull
	@Size(max=16,min=2)
	private String login;
	
	@NotNull
	@Size(max=50,min=6)
	private String motDePasse;
	
	@Autowired
	@Embedded
	private Adresse adresse;
	

	public Client() {}

	public Client(Adresse adresse) {
	    this.adresse = adresse;
	}
	

	public Client(String nom, String prenom, String login, String motDePasse, Adresse adresse) {
		super(nom,prenom);
		this.login = login;
		this.motDePasse = motDePasse;
		this.adresse = adresse;
	}

	public String toString() {
		 return " ID  : "+this.getId() +" - "+
		    	" Nom : "+this.getNom()+" - "+
		    	" Prénom : "+this.getPrenom() +" - "+
		    	" login : "+this.getLogin() +" - "+
		    	" Mot de passe : "+this.getMotDePasse() +" - "+
		    	" Adresse : "+this.getAdresse().toString();
		    		
		
	}


	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	

  
}
