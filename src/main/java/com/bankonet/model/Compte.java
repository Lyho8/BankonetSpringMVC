package com.bankonet.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Compte {

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String libelle;
	
	@NotNull
	private float solde;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	
	public Compte(){
		super();
	}

	public Compte(int id, String libelle, float solde, Client client) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.solde = solde;
		this.client = client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	

}
