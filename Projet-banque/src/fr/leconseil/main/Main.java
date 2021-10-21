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
//		for (TypeDeCompte typeCompte : Requetes.getAllTypeDeCompte()) {
//			System.out.println(typeCompte);
//		}
		
		
//		Requetes.createCompte(new Compte(10010,2, 1002, 6400.00f));
//		for (Compte compte : Requetes.getAllComptes()) {
//		System.out.println(compte);
//		}
		//Noreddine
		Requetes.updateCompte(new Compte(10010,1,1004,8600.00f));
		Requetes.updateTitulaire(new Titulaire(1005,"Jon","Carter","20 Rue de barbess",75020));
		Requetes.updateTypeDeCompte(new TypeDeCompte(5,"PEA"));
	
		
			
	}

}
