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
	
	//Noreddine 
	
	public static void updateCompte(Compte compte) throws SQLException {
		PreparedStatement prepareStatement = AccesBD.getConnection().prepareStatement("UPDATE compte SET codeTypeCompte = ? , codeTitulaire = ? , solde = ? WHERE numero = ? ");
		prepareStatement.setInt(1,compte.getCodeTypeCompte());
		prepareStatement.setInt(2,compte.getCodeTitulaire());
		prepareStatement.setFloat(3,compte.getSolde());
		prepareStatement.setInt(4,compte.getNumero());
		
		prepareStatement.executeUpdate();
		
	}
	
	//Noreddine
	
	public static void updateTitulaire(Titulaire titulaire) throws SQLException {
		PreparedStatement prepareStatement = AccesBD.getConnection().prepareStatement("UPDATE titulaire SET prenom = ? , nom = ? , adresse = ?, codePostal = ? WHERE code = ? ");
		prepareStatement.setString(1,titulaire.getNom());
		prepareStatement.setString(2,titulaire.getPrenom());
		prepareStatement.setString(3,titulaire.getAdresse());
		prepareStatement.setInt(4,titulaire.getCodePostal());
		prepareStatement.setInt(5,titulaire.getCode());
		
		prepareStatement.executeUpdate();
		
	}
	

	//Noreddine
	
	public static void updateTypeDeCompte(TypeDeCompte typeDeCompte) throws SQLException {
		PreparedStatement prepareStatement = AccesBD.getConnection().prepareStatement("UPDATE typecompte SET intitule = ? WHERE code = ? ");
		prepareStatement.setString(1,typeDeCompte.getIntitule());
		prepareStatement.setInt(2,typeDeCompte.getCode());
		
		prepareStatement.executeUpdate();
		
	}

	
}
