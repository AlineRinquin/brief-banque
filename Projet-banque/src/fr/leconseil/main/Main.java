package fr.leconseil.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import fr.leconseil.accesbd.AccesBD;
import fr.leconseil.model.Compte;
import fr.leconseil.model.Operation;
import fr.leconseil.model.Requetes;
import fr.leconseil.model.Titulaire;
import fr.leconseil.model.TypeDeCompte;

public class Main extends AccesBD implements Requetes{
	
	static ArrayList<Compte> lesComptes = new ArrayList<Compte>();
	static ArrayList<Titulaire> lesTitulaires = new ArrayList<Titulaire>();
	static ArrayList<TypeDeCompte> lesTypesDeCompte = new ArrayList<TypeDeCompte>();
	
	public static void AcquisitionDonnees() throws SQLException {
		System.out.println("------------ Acquisition des données ---------------");
		lesComptes = Requetes.getAllComptes();
		lesTitulaires = Requetes.getAllTitulaire();
		lesTypesDeCompte = Requetes.getAllTypeDeCompte();
		System.out.println("------------ Terminé ---------------");
	}
	
	public static void CreateCompte(ArrayList<Titulaire> lesTitulaires) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("------------ Création d'un nouveau compte ---------------");
		System.out.println("Numero de compte ?");
		int numero = scanner.nextInt();
		System.out.println("Type de compte ?");
		int typeDeCompte = scanner.nextInt();
		System.out.println("Prenom titulaire ?");
		String prenomTitulaire = scanner.next();
		int codeTitulaire = 0;
		
		for(int index = 0; index < lesTitulaires.size(); index++) {
			boolean check = lesTitulaires.get(index).getPrenom().contains(prenomTitulaire);
			if(check)  {
//				System.out.println(prenomTitulaire + " existe et son code est : " + 
//										lesTitulaires.get(index).getCode());
				codeTitulaire = lesTitulaires.get(index).getCode();
				
			}
					
		}
		
		System.out.println("Solde de départ ?");
		float solde = scanner.nextFloat();
		
		Requetes.createCompte(numero, typeDeCompte, codeTitulaire, solde);
	}

	public static void main(String[] args) throws SQLException {
		
		AcquisitionDonnees();
		CreateCompte(lesTitulaires);
		AcquisitionDonnees();
		
		//Requetes.deleteCompte(lesComptes.get(9));
		//Requetes.updateCompte(lesComptes.get(1), 2, lesComptes.get(1).getCodeTitulaire().getCode(), 35000.00f);
		//Requetes.createTypeDeCompte("test2");
		

//		System.out.println("------------ Acquisition des données ---------------");
//		lesComptes = Requetes.getAllComptes();
//		lesTitulaires = Requetes.getAllTitulaire();
//		lesTypesDeCompte = Requetes.getAllTypeDeCompte();
//		System.out.println("------------ Terminé ---------------");
//		
//		
		System.out.println("------------ Tout les comptes ---------------");
		for (Compte compte : lesComptes) {
			System.out.println(compte);
		}
		
//		System.out.println("------------ Tout les titulaires ---------------");
//		for (Titulaire titulaire : lesTitulaires) {
//			System.out.println(titulaire);
//		}
//		
//		System.out.println("------------ Toute les opérations pour un compte ---------------");
//		for (Operation operation : Requetes.getAllOperationsFromComptes(lesComptes.get(1))) {
//			System.out.println(operation);
//		}	
//		
//		System.out.println("------------ Tout les comptes d'un titulaire ---------------");
//		for (Compte compte : Requetes.getAllComptesFromTitulaire(lesTitulaires.get(1))) {
//			System.out.println(compte);
//		}
		
	}

}
