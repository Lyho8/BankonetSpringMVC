package com.bankonet.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {

	@NotNull
	private float tauxInt;
	
	@NotNull
	private float plafond;
	
	public CompteEpargne(){
		super();
	}

	public CompteEpargne(float tauxInt, float plafond) {
		super();
		this.tauxInt = tauxInt;
		this.plafond = plafond;
	}

	public float getTauxInt() {
		return tauxInt;
	}

	public void setTauxInt(float tauxInt) {
		this.tauxInt = tauxInt;
	}

	public float getPlafond() {
		return plafond;
	}

	public void setPlafond(float plafond) {
		this.plafond = plafond;
	}
	
	
	
}
