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
	public static void createCompte(int numero, int codeTypeCompte, int codeTitulaire, float solde) throws SQLException {
		
		PreparedStatement PreparedStatement = AccesBD.getConnection().prepareStatement("INSERT INTO compte VALUES (?, ?, ?, ?)");
		PreparedStatement.setInt(1, numero);
		PreparedStatement.setInt(2, codeTypeCompte);
		PreparedStatement.setInt(3, codeTitulaire);
		PreparedStatement.setFloat(4, solde);
		
		PreparedStatement.executeUpdate();
		
	}
	
	//Julian
		public static ArrayList<Operation> getAllOperationsFromComptes(Compte compte) throws SQLException {
			ArrayList<Operation> operations = new ArrayList<Operation>();
			String requete = "SELECT * FROM operations WHERE numeroCompte = " + compte.getNumero();
			ResultSet resultat = AccesBD.executerQuery(requete);
			
			while(resultat.next()) {
				Operation operation = new Operation();
				operation.setNumero(resultat.getInt("numero"));
				operation.setNumeroCompte(compte);
				operation.setDate(resultat.getDate("date"));
				operation.setLibelle(resultat.getString("libelle"));
				operation.setMontant(resultat.getFloat("montant"));
				operation.setTypeOp(resultat.getString("typeop"));
				operations.add(operation);
			}
			
			return operations;
		}
	

	//Noreddine 
	
	public static void updateCompte(Compte compte, int codeTypeCompte, int codeTitulaire, float solde) throws SQLException {
		PreparedStatement prepareStatement = AccesBD.getConnection().prepareStatement("UPDATE compte SET codeTypeCompte = ? , codeTitulaire = ? , solde = ? WHERE numero = ? ");
		prepareStatement.setInt(1,codeTypeCompte);
		prepareStatement.setInt(2,codeTitulaire);
		prepareStatement.setFloat(3,solde);
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


	// Romain
	public static void createTypeDeCompte(String nameType) throws SQLException {
		PreparedStatement PreparedStatement = AccesBD.getConnection().prepareStatement("INSERT INTO typecompte(intitule) VALUES (?);");
		PreparedStatement.setString(1, nameType);
		
		PreparedStatement.executeUpdate();
		
	}
	// Romain
	public static void createTitulaire(Titulaire titulaire) throws SQLException {
		
		PreparedStatement PreparedStatement = AccesBD.getConnection().prepareStatement("INSERT INTO titulaire VALUES (?, ?, ?, ?, ?)");
		PreparedStatement.setInt(1, titulaire.getCode());
		PreparedStatement.setString(2, titulaire.getPrenom());
		PreparedStatement.setString(3, titulaire.getNom());
		PreparedStatement.setString(4, titulaire.getAdresse());
		PreparedStatement.setInt(5, titulaire.getCodePostal());

		
		PreparedStatement.executeUpdate();

		
	}
	


	//Noreddine
	
	public static void updateTypeDeCompte(TypeDeCompte typeDeCompte) throws SQLException {
		PreparedStatement prepareStatement = AccesBD.getConnection().prepareStatement("UPDATE typecompte SET intitule = ? WHERE code = ? ");
		prepareStatement.setString(1,typeDeCompte.getIntitule());
		prepareStatement.setInt(2,typeDeCompte.getCode());
		
		prepareStatement.executeUpdate();
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
