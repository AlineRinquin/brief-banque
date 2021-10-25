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
		public static ArrayList<Operation> getAllOperationsFromComptes(int numero) throws SQLException {
			ArrayList<Operation> operations = new ArrayList<Operation>();
			String requete = "SELECT * FROM operations WHERE numeroCompte = " + numero;
			ResultSet resultat = AccesBD.executerQuery(requete);
			
			while(resultat.next()) {
				Operation operation = new Operation();
				operation.setNumero(resultat.getInt("numero"));
				operation.setNumeroCompte(new Compte(numero));
				operation.setDate(resultat.getDate("date"));
				operation.setLibelle(resultat.getString("libelle"));
				operation.setMontant(resultat.getFloat("montant"));
				operation.setTypeOp(resultat.getString("typeop"));
				operations.add(operation);
			}
			
			return operations;
		}
	

	//Noreddine 
	

	public static void updateCompte(int numeroCompte, float solde) throws SQLException {
		PreparedStatement prepareStatement = AccesBD.getConnection().prepareStatement("UPDATE compte SET solde = ? WHERE numero = ? ");
		prepareStatement.setFloat(1,solde);
		prepareStatement.setInt(2,numeroCompte);

		prepareStatement.executeUpdate();
		
	}
	
	

	

	//Noreddine
	
		public static void updateTitulaire(String adresse, int codePostale, int code) throws SQLException {
		PreparedStatement prepareStatement = AccesBD.getConnection().prepareStatement("UPDATE titulaire SET adresse = ?, codePostal = ? WHERE code = ? ");
		prepareStatement.setString(1,adresse);
		prepareStatement.setInt(2,codePostale);
		prepareStatement.setInt(3,code);
		
		prepareStatement.executeUpdate();
	}


	// Romain
	public static void createTypeDeCompte(String intitule) throws SQLException {
		PreparedStatement PreparedStatement = AccesBD.getConnection().prepareStatement("INSERT INTO typecompte (intitule) VALUES (?)");
		PreparedStatement.setString(1, intitule);
		
		PreparedStatement.executeUpdate();
		
	}
	
	
	// Romain
	public static void createTitulaire(int code, String prenom, String nom, String adresse, int codePostal) throws SQLException {
		
		PreparedStatement PreparedStatement = AccesBD.getConnection().prepareStatement("INSERT INTO titulaire VALUES (?, ?, ?, ?, ?)");
		PreparedStatement.setInt(1, code);
		PreparedStatement.setString(2, prenom);
		PreparedStatement.setString(3, nom);
		PreparedStatement.setString(4, adresse);
		PreparedStatement.setInt(5, codePostal);

		PreparedStatement.executeUpdate();
	}

	//Noreddine
	public static void updateTypeDeCompte(String newTypeCompte,int code) throws SQLException {
		PreparedStatement prepareStatement = AccesBD.getConnection().prepareStatement("UPDATE typecompte SET intitule = ? WHERE code = ? ");
		prepareStatement.setString(1,newTypeCompte);
		prepareStatement.setInt(2,code);
		
		prepareStatement.executeUpdate();
	}

	
	//Aline
	public static void deleteCompte(int numeroCompte) throws SQLException {
		
		PreparedStatement PreparedStatement = AccesBD.getConnection().prepareStatement("DELETE FROM Compte WHERE numero=?");
		PreparedStatement.setInt(1, numeroCompte);
		PreparedStatement.executeUpdate();
	}
	
	//Aline
	public static void deleteTitulaire(int codeTitulaire) throws SQLException {
		
		PreparedStatement PreparedStatement = AccesBD.getConnection().prepareStatement("DELETE FROM Titulaire WHERE code=?");
		PreparedStatement.setInt(1, codeTitulaire);
		PreparedStatement.executeUpdate();
	}
	
	//Aline
	public static void deleteTypeDeCompte(int codeTypeDeCompte) throws SQLException {
		
		PreparedStatement PreparedStatement = AccesBD.getConnection().prepareStatement("DELETE FROM Typecompte WHERE code=?");
		PreparedStatement.setInt(1, codeTypeDeCompte);
		PreparedStatement.executeUpdate();
	}
	 
	
	//Aline
	public static ArrayList<Compte> getAllComptesFromTitulaire (int code) throws SQLException {
		
		ArrayList<Compte> comptes=new ArrayList<Compte>();
		String requete = "select compte.numero, compte.codeTypeCompte, compte.codeTitulaire, compte.solde, titulaire.* from compte inner join titulaire on compte.codeTitulaire = titulaire.code and titulaire.code ="+ code;
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
	
	//Julian
	public static Compte getCompte(int numeroCompte) throws SQLException {
		Compte compte = new Compte();
		String requete = "SELECT * FROM compte WHERE compte.numero =" + numeroCompte;
		ResultSet resultat = AccesBD.executerQuery(requete);
		resultat.next();
		compte.setNumero(resultat.getInt("numero"));
		compte.setCodeTypeCompte(resultat.getInt("codeTypeCompte"));
		compte.setCodeTitulaire(resultat.getInt("codeTitulaire"));
		compte.setSolde(resultat.getInt("solde"));
		
		return compte;
	}
	
	//Julian
	public static Titulaire getTitulaire(int code) throws SQLException {
		Titulaire titulaire = new Titulaire();
		String requete = "SELECT * FROM titulaire WHERE titulaire.code =" + code;
		ResultSet resultat = AccesBD.executerQuery(requete);
		resultat.next();
		titulaire.setCode(resultat.getInt("code"));
		titulaire.setPrenom(resultat.getString("prenom"));
		titulaire.setNom(resultat.getString("nom"));
		titulaire.setAdresse(resultat.getString("adresse"));
		titulaire.setCodePostal(resultat.getInt("codePostal"));
		
		return titulaire;
	}
	
	//Julian
	public static void createOperation(int numeroCompte, String libelle, float montant, String typeop) throws SQLException {
		PreparedStatement PreparedStatement = AccesBD.getConnection().prepareStatement
				("INSERT INTO operations(numeroCompte, date, libelle, montant, typeop) VALUES (?, DATE( NOW() ), ?, ?, ?);");
		PreparedStatement.setInt(1, numeroCompte);
		PreparedStatement.setString(2, libelle);
		PreparedStatement.setFloat(3, montant);
		PreparedStatement.setString(4, typeop);
		PreparedStatement.executeUpdate();
		
		Compte compte = getCompte(numeroCompte);
		if(typeop.contains("+")) {
			compte.setSolde(compte.getSolde() + montant);
			updateCompte(numeroCompte, compte.getSolde());
		}
		else if(typeop.contains("-")) {
			compte.setSolde(compte.getSolde() - montant);
			updateCompte(numeroCompte, compte.getSolde());
		}
		else {
			System.out.println("Erreur mauvais opérateur de type");
		}
	}
	
}
