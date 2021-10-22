package fr.leconseil.model;

import java.sql.Date;

public class Operation {
	private int numero;
	private Compte numeroCompte;
	private Date date;
	private String libelle;
	private float montant;
	private String typeOp;
	
	public Operation(int numero, Compte numeroCompte, Date date, String libelle, float montant, String typeOp) {
		super();
		this.numero = numero;
		this.numeroCompte = numeroCompte;
		this.date = date;
		this.libelle = libelle;
		this.montant = montant;
		this.typeOp = typeOp;
	}
	
	public Operation() {
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Compte getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(Compte numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public String getTypeOp() {
		return typeOp;
	}

	public void setTypeOp(String typeOp) {
		this.typeOp = typeOp;
	}

	@Override
	public String toString() {
		return "Operation [numero=" + numero + ", numeroCompte=" + numeroCompte.getNumero() + ", date=" + date + ", libelle="
				+ libelle + ", montant=" + montant + ", typeOp=" + typeOp + "]";
	}
	
	
}
