package fr.leconseil.main;

import java.sql.SQLException;

import fr.leconseil.accesbd.AccesBD;
import fr.leconseil.model.Compte;
import fr.leconseil.model.Operation;
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
		//Requetes.updateCompte(new Compte(10005));
//		Requetes.updateTitulaire(new Titulaire(1005,"Jon","Carter","20 Rue de barbess",75020));
//		Requetes.updateTypeDeCompte(new TypeDeCompte(5,"PEA"));
	
		
			

		//Requetes.createCompte(new Compte(10010,2, 1002, 6400.00f));
//		for (Compte compte : Requetes.getAllComptes()) {
//		System.out.println(compte);
//		}

		
		for (Operation operation : Requetes.getAllOperationsFromComptes(new Compte(10001, 1, 1001, 100.00f))) {
			System.out.println(operation);
		}
//		
//		Requetes.createTitulaire(new Titulaire(1007, "Aline", "RINQUIN", "65 avenue des requêtesSQL", 75011));
//		Requetes.createTitulaire(new Titulaire(1008, "Noreddine", "KEDDAR", "17 impasse d'Eclipse", 77900));
//		Requetes.createTitulaire(new Titulaire(1009, "Julian", "TOMCZYK", "79 rue du  JDK 16", 75011));
//
//		Requetes.createTypeDeCompte(new TypeDeCompte(9, "Compte Bar"));
//
//
//		
//		for (Compte compte : Requetes.getAllComptesFromTitulaire(new Titulaire(1000, "Philippe", "Bouget", "52 rue de la Java", 75013))) {
//			System.out.println(compte);
//		}
		
	
	}

}
