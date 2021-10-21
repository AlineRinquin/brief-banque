package fr.leconseil.model;

public class TypeDeCompte {

	private int code;
	private String intitule;
	public TypeDeCompte(int code, String intitule) {
		super();
		this.code = code;
		this.intitule = intitule;
	}
	
	
	public TypeDeCompte() {
		
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getIntitule() {
		return intitule;
	}


	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	
	

	@Override
	public String toString() {
		return "TypeDeCompte [code=" + code + ", intitule=" + intitule + "]";
	}
	
	
}
