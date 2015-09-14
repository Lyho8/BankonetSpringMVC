 package com.bankonet.model;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.eclipse.persistence.annotations.*;
import org.springframework.beans.factory.annotation.*;

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
	
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	@PrivateOwned
	private List<Compte> comptes;	

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

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
  
}
