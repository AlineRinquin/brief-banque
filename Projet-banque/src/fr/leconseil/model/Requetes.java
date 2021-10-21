package fr.leconseil.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.leconseil.accesbd.AccesBD;

public interface Requetes {
	
	//Julian
	public static ArrayList<Compte> getAllComptes() throws SQLException {
		ArrayList<Compte> comptes = new ArrayList<Compte>();
		String requete = "SELECT * FROM compte";
		ResultSet resultat = AccesBD.executerQuery(requete);
		
		while(resultat.next()) {
			Compte compte = new Compte();
			compte.setNumero(resultat.getInt("numero"));
			compte.setCodeTypeCompte(resultat.getInt("codeTypeCompte"));
			compte.setCodeTitulaire(resultat.getInt("codeTitulaire"));
			compte.setSolde(resultat.getFloat("solde"));
			comptes.add(compte);
		}
		
		return comptes;
	}
	
	//Noreddine
	public static ArrayList<Titulaire> getAllTitulaire() throws SQLException {
		ArrayList<Titulaire> titulaires = new ArrayList<Titulaire>();
		String requete = "SELECT * FROM titulaire";
		ResultSet resultat = AccesBD.executerQuery(requete);
		
		while(resultat.next()) {
			Titulaire titulaire = new Titulaire();
			titulaire.setCode(resultat.getInt("code"));
			titulaire.setPrenom(resultat.getString("prenom"));
			titulaire.setNom(resultat.getString("nom"));
			titulaire.setAdresse(resultat.getString("adresse"));
			titulaire.setCodePostal(resultat.getInt("codePostal"));
			titulaires.add(titulaire);
		}
		
		return titulaires;
	}
	
	//Aline
	public static ArrayList<TypeDeCompte> getAllTypeDeCompte() throws SQLException {
		ArrayList<TypeDeCompte> typeDeComptes = new ArrayList<TypeDeCompte>();
		String requete = "SELECT * FROM typecompte";
		ResultSet resultat = AccesBD.executerQuery(requete);
		
		while(resultat.next()) {
			TypeDeCompte typeDeCompte = new TypeDeCompte();
			typeDeCompte.setCode(resultat.getInt("code"));
			typeDeCompte.setIntitule(resultat.getString("intitule"));
			typeDeComptes.add(typeDeCompte);
		}
		
		return typeDeComptes;
	}
	
	//Romain
	public static void createCompte(Compte compte) throws SQLException {
		
		PreparedStatement PreparedStatement = AccesBD.getConnection().prepareStatement("INSERT INTO compte VALUES (?, ?, ?, ?)");
		PreparedStatement.setInt(1, compte.getNumero());
		//PreparedStatement.setInt(2, compte.getCodeTypeCompte());
		//PreparedStatement.setInt(3, compte.getCodeTitulaire());
		PreparedStatement.setFloat(4, compte.getSolde());
		
		PreparedStatement.executeUpdate();
		
	}
	
	//Aline
	public static void deleteCompte(Compte compte) throws SQLException {
		
		PreparedStatement PreparedStatement = AccesBD.getConnection().prepareStatement("DELETE FROM Compte WHERE numero=?");
		PreparedStatement.setInt(1, compte.getNumero());
		PreparedStatement.executeUpdate();
	}
	
	//Aline
	public static void deleteTitulaire(Titulaire titulaire) throws SQLException {
		
		PreparedStatement PreparedStatement = AccesBD.getConnection().prepareStatement("DELETE FROM Titulaire WHERE code=?");
		PreparedStatement.setInt(1, titulaire.getCode());
		PreparedStatement.executeUpdate();
	}
	
	//Aline
	public static void deleteTypeDeCompte(TypeDeCompte typeDeCompte) throws SQLException {
		
		PreparedStatement PreparedStatement = AccesBD.getConnection().prepareStatement("DELETE FROM Typecompte WHERE code=?");
		PreparedStatement.setInt(1, typeDeCompte.getCode());
		PreparedStatement.executeUpdate();
	}
	 
	
	//Aline
	public static ArrayList<Compte> getAllComptesFromTitulaire (Titulaire titulaire) throws SQLException {
		

		ArrayList<Compte> comptes=new ArrayList<Compte>();
		String requete = "select compte.numero, compte.codeTypeCompte, compte.codeTitulaire, compte.solde, titulaire.* from compte inner join titulaire on compte.codeTitulaire = titulaire.code and titulaire.code ="+ titulaire.getCode();
		ResultSet resultat = AccesBD.executerQuery(requete);
		while(resultat.next()) {
			Compte compte = new Compte();
			compte.setNumero(resultat.getInt("numero"));
			compte.setCodeTypeCompte(resultat.getInt("codeTypeCompte"));
			compte.setCodeTitulaire(resultat.getInt("codeTitulaire"));
			compte.setSolde(resultat.getInt("solde"));
			compte.getCodeTitulaire().setCode(resultat.getInt("code"));
			compte.getCodeTitulaire().setPrenom(resultat.getString("prenom"));
			compte.getCodeTitulaire().setNom(resultat.getString("nom"));
			compte.getCodeTitulaire().setAdresse(resultat.getString("adresse"));
			compte.getCodeTitulaire().setCodePostal(resultat.getInt("codePostal"));
			
			comptes.add(compte);
		}
		return comptes;
		
		

	
	}
	
}
