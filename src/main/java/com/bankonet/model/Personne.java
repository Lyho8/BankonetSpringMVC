package com.bankonet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Personne {
  @Id
  @GeneratedValue
  private int id;
  
  @NotNull
  @Size(max=60,min=3)
  private String nom = "";
  
  @Size(max=60,min=3)
  private String prenom = "";
	
  
  public Personne() {
  }
	
  public Personne(String nom,String prenom) {
    this.nom = nom;
    this.prenom = prenom;
  }

  
  
  public Personne(int id, String nom, String prenom) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
}

public int getId() {
    return id;
  }
	
public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}
  
  
  
}
