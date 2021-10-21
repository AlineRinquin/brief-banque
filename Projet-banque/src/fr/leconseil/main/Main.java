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
		
		
		//Requetes.createCompte(new Compte(10010,2, 1002, 6400.00f));
		for (Compte compte : Requetes.getAllComptes()) {
		System.out.println(compte);
		}
		
		Requetes.createTitulaire(new Titulaire(1007, "Aline", "RINQUIN", "65 avenue des requ�tesSQL", 75011));
		Requetes.createTitulaire(new Titulaire(1008, "Noreddine", "KEDDAR", "17 impasse d'Eclipse", 77900));
		Requetes.createTitulaire(new Titulaire(1009, "Julian", "TOMCZYK", "79 rue du  JDK 16", 75011));

		Requetes.createTypeDeCompte(new TypeDeCompte(9, "Compte Bar"));
		
	}

}
