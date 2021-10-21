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
		PreparedStatement.setInt(2, compte.getCodeTypeCompte());
		PreparedStatement.setInt(3, compte.getCodeTitulaire());
		PreparedStatement.setFloat(4, compte.getSolde());
		
		PreparedStatement.executeUpdate();
		
	}
	
	
}
