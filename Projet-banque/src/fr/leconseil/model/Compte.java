package fr.leconseil.model;

public class Compte {
	private int numero;
	private TypeDeCompte codeTypeCompte;
	private Titulaire codeTitulaire;
	private float solde;
	
	public Compte(int numero, TypeDeCompte codeTypeCompte, Titulaire codeTitulaire, float solde) {
		super();
		this.numero = numero;
		this.codeTypeCompte = codeTypeCompte;
		this.codeTitulaire = codeTitulaire;
		this.solde = solde;
	}
	
	public Compte(int numero) {
		this.numero = numero;
	}
	
	public Compte() {
		this.codeTitulaire = new Titulaire();
		this.codeTypeCompte = new TypeDeCompte();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public TypeDeCompte getCodeTypeCompte() {
		return codeTypeCompte;
	}

	public void setCodeTypeCompte(int codeTypeCompte) {
		this.codeTypeCompte.setCode(codeTypeCompte);
	}

	public Titulaire getCodeTitulaire() {
		return codeTitulaire;
	}

	public void setCodeTitulaire(int codeTitulaire) {
		this.codeTitulaire.setCode(codeTitulaire);
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", codeTypeCompte=" + codeTypeCompte + ", codeTitulaire=" + codeTitulaire
				+ ", solde=" + solde + "]";
	}
	
	
}
