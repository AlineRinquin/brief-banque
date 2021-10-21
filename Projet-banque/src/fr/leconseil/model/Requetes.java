package fr.leconseil.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.leconseil.accesbd.AccesBD;

public interface Requetes {
	
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
}
