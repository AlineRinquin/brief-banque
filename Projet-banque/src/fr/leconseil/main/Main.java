package fr.leconseil.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

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
	
	//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
	
	public static void AcquisitionDonnees() throws SQLException {
		System.out.println("------------ Acquisition des données ---------------");
		lesComptes = Requetes.getAllComptes();
		lesTitulaires = Requetes.getAllTitulaire();
		lesTypesDeCompte = Requetes.getAllTypeDeCompte();
		System.out.println("------------ Terminé ---------------");
	}
	
	//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_- Gestion des comptes _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
	
	//Julian
	public static void GetOneCompte() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Numero de compte ?");
		int numero = scanner.nextInt();
		
		System.out.println(Requetes.getCompte(numero));
	}
	
	//Julian
	public static void ListAllComptes() {
		for (Compte compte : lesComptes) {
			System.out.println(compte);
		}
	}
	
	//Julian
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
				codeTitulaire = lesTitulaires.get(index).getCode();	
			}
					
		}
		
		System.out.println("Solde de départ ?");
		float solde = scanner.nextFloat();
		
		Requetes.createCompte(numero, typeDeCompte, codeTitulaire, solde);
	}
	
	//Noreddine	
	public static void UpdateCompte() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("------------ Mise à jour d'un compte ---------------");		
		System.out.println("Numero du compte ?");
		int numeroDeCompte = scanner.nextInt();
		System.out.println("Nouveau Solde ?");
		float solde = scanner.nextFloat();
		

		Requetes.updateCompte(numeroDeCompte, solde);
	}
	
	//Aline
	public static  void DeleteCompte() throws SQLException{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("------------ Supression d'un compte ---------------");
		System.out.println("Numero de compte ?");
		
		int numeroCompte = scanner.nextInt();
		Requetes.deleteCompte(numeroCompte);
	}
	
	//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_- Gestion des titulaires _-_-_-_-_-_-_-_-_-_-_-_-_-
	
	//Julian
		public static void GetOneTitulaire() throws SQLException {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Code titulaire ?");
			int numero = scanner.nextInt();
			
			System.out.println(Requetes.getTitulaire(numero));
		}
	
	//Julian
	public static void ListAllTitulaires() {
		for (Titulaire titulaire : lesTitulaires) {
			System.out.println(titulaire);
		}
	}
	
	//Julian
	public static void CreateTitulaire() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("------------ Création d'un nouveau titulaire ---------------");
		System.out.println("Code titulaire ?");
		int code = scanner.nextInt();
		System.out.println("Prenom ?");
		String prenom = scanner.next();
		System.out.println("Nom ?");
		String nom = scanner.next();
		System.out.println("Adresse ?");
		String adresse = scanner.next();
		System.out.println("Code postal ?");
		int codePostal = scanner.nextInt();
		
		Requetes.createTitulaire(code, prenom, nom, adresse, codePostal);
	}
	
	//Noreddine
	public static void UpdateTitulaire() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("------------ Mise à jour des infos du Titulaire ---------------");
		System.out.println("Code titulaire ? ");
		int code = scanner.nextInt();
		System.out.println("Nouvelle adresse ?");
		String newAdresse = scanner.next();
		System.out.println("Nouveau CodePostal ?");
		int codePostale = scanner.nextInt();
		
		
		Requetes.updateTitulaire(newAdresse, codePostale, code);
	}
	
	//Aline
	public static  void DeleteTitulaire() throws SQLException{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("------------ Supression d'un titulaire ---------------");
		System.out.println("Code du titulaire ?");
		
		int codeTitulaire = scanner.nextInt();
		Requetes.deleteTitulaire(codeTitulaire);
	}
	
	//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_- Gestion des types de compte _-_-_-_-_-_-_-_-_-_-_-_-_-
	
	//Julian
		public static void ListAllTypesCompte() {
			for (TypeDeCompte typeCompte : lesTypesDeCompte) {
				System.out.println(typeCompte);
			}
		}
		
	//Julian
	public static void CreateTypeCompte() throws SQLException {
		Scanner scanner = new Scanner(System.in);
			
		System.out.println("------------ Création d'un nouveau type de compte ---------------");
		System.out.println("Intitulé ?");
		String intitule = scanner.next();
			
		Requetes.createTypeDeCompte(intitule);
	}
		
	//Noreddine
	public static void UpdateTypeCompte() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("------------ Mise à jour d'un type De Compte ---------------");
		System.out.println("Code type de compte ? ");
		int code = scanner.nextInt();
		System.out.println("Nouveau type de compte ?");
		String newTypeCompte = scanner.next();
		
		
		Requetes.updateTypeDeCompte(newTypeCompte,code);
	}
	
	//Aline
	public static void DeleteTypeDeCompte() throws SQLException{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("------------ Supression d'un type de compte ---------------");
		System.out.println("Code type de compte ?");
		int code = scanner.nextInt();
		Requetes.deleteTypeDeCompte(code);
	}
	
	//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_- Gestion des operations _-_-_-_-_-_-_-_-_-_-_-_-_-

	public static void CreateOperation() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("------------ Création d'une opération ---------------");
		System.out.println("Numero de compte ?");
		int numero = scanner.nextInt();
		System.out.println("Libelle ?");
		String libelle = scanner.next();
		System.out.println("Montant ?");
		float montant = scanner.nextFloat();
		System.out.println("Type d'opération ? ('+' ou '-')");
		String typeop = scanner.next();
		
		Requetes.createOperation(numero, libelle, montant, typeop);
	}
	
	public static void ListAllOperationsForOneCompte() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("------------ Toute les opérations pour un compte ---------------");
		System.out.println("Numero de compte ?");
		int numero = scanner.nextInt();
		for (Operation operation : Requetes.getAllOperationsFromComptes(numero)) {
			System.out.println(operation);
		}
	}
	
	public static void ListAllCompteForOneTitulaire() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("------------ Toute les opérations pour un compte ---------------");
		System.out.println("Code titulaire ?");
		int code = scanner.nextInt();
		for (Compte compte : Requetes.getAllComptesFromTitulaire(code)) {
			System.out.println(compte);
		}
	}
		
	//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_- Gestion de l'affichage _-_-_-_-_-_-_-_-_-_-_-_-_-
	
	public static void SelectCompteOption() throws SQLException {
		System.out.println("1 - Afficher un compte");
		System.out.println("2 - Afficher tous les comptes");
		System.out.println("3 - Creer un compte");
		System.out.println("4 - Modifier un compte");
		System.out.println("5 - Supprimer un compte");
		System.out.println("6 - Retour menu principal");
		Scanner scanner = new Scanner(System.in);
		int response = scanner.nextInt();
			switch (response) {
				case 0:
					System.out.println("Erreur, veuillez entrer un choix existant...");
					break;
				case 1:
					GetOneCompte();
					break;
				case 2:
					ListAllComptes();
					break;
				case 3:
					CreateCompte(lesTitulaires);
					break;
				case 4:
					UpdateCompte();
					break;
				case 5:
					DeleteCompte();
					break;
				case 6:
					break;

				default:
					break;
				}
		}
	
	public static void SelectTitulaireOption() throws SQLException {
		System.out.println("1 - Afficher un titulaire");
		System.out.println("2 - Afficher tous les titulaires");
		System.out.println("3 - Creer un titulaire");
		System.out.println("4 - Modifier un titulaire");
		System.out.println("5 - Supprimer un titulaire");
		System.out.println("6 - Retour menu principal");
		Scanner scanner = new Scanner(System.in);
		int response = scanner.nextInt();
			switch (response) {
				case 0:
					System.out.println("Erreur, veuillez entrer un choix existant...");
					break;
				case 1:
					GetOneTitulaire();
					break;
				case 2:
					ListAllTitulaires();
					break;
				case 3:
					CreateTitulaire();
					break;
				case 4:
					UpdateTitulaire();
					break;
				case 5:
					DeleteTitulaire();
					break;
				case 6:
					break;

				default:
					break;
				}
		}
	
	public static void SelectTypeCompteOption() throws SQLException {
		System.out.println("1 - Afficher tous les types de compte");
		System.out.println("2 - Creer un type de compte");
		System.out.println("3 - Modifier un type de compte");
		System.out.println("4 - Supprimer un type de compte");
		System.out.println("5 - Retour menu principal");
		Scanner scanner = new Scanner(System.in);
		int response = scanner.nextInt();
			switch (response) {
				case 0:
					System.out.println("Erreur, veuillez entrer un choix existant...");
					break;
				case 1:
					ListAllTypesCompte();
					break;
				case 2:
					CreateTypeCompte();
					break;
				case 3:
					UpdateTypeCompte();
					break;
				case 4:
					DeleteTypeDeCompte();
					break;
				case 5:
					break;
				default:
					break;
				}
		}
	 
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		int response = 0;
		
		do {
			AcquisitionDonnees();
			System.out.println("1 - Gestion des comptes");
			System.out.println("2 - Gestion des titulaires");
			System.out.println("3 - Gestion des types de compte");
			System.out.println("4 - Creer une opération");
			System.out.println("5 - Afficher toute les opérations d'un compte");
			System.out.println("6 - Afficher tous les comptes d'un titulaire");
			System.out.println("7 - Quitter le programme");
		
			response = scanner.nextInt();
			
			switch (response) {
			case 0:
				
				break;

			case 1:
				SelectCompteOption();
				break;
			case 2:
				SelectTitulaireOption();
				break;
			case 3:
				SelectTypeCompteOption();
				break;
			case 4:
				CreateOperation();
				break;
			case 5:
				ListAllOperationsForOneCompte();
				break;
			case 6:
				ListAllCompteForOneTitulaire();
				break;
			case 7:
				System.out.println("Le programme se ferme...");
				scanner.close();
				System.exit(0);
				break;
			default:
				break;
			}
		} while (true);
	}
}


