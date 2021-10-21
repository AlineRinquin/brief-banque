package fr.leconseil.main;

import java.sql.SQLException;

import fr.leconseil.accesbd.AccesBD;
import fr.leconseil.model.Compte;
import fr.leconseil.model.Requetes;
import fr.leconseil.model.Titulaire;
import fr.leconseil.model.TypeDeCompte;

public class Main extends AccesBD implements Requetes{

	public static void main(String[] args) throws SQLException {
//		for (Compte compte : Requetes.getAllComptes()) {
//			System.out.println(compte);
//		}
//		for (Titulaire titulaire : Requetes.getAllTitulaire()) {
//			System.out.println(titulaire);
//		}
		for (TypeDeCompte typeCompte : Requetes.getAllTypeDeCompte()) {
			System.out.println(typeCompte);
		}
		
	}

}
