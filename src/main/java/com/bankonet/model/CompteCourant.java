package com.bankonet.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {

	@NotNull
	private float debitAut;

	public CompteCourant() {
		super();
	}

	public CompteCourant(float debitAut) {
		super();
		this.debitAut = debitAut;
	}

	public float getDebitAut() {
		return debitAut;
	}

	public void setDebitAut(float debitAut) {
		this.debitAut = debitAut;
	}

}
