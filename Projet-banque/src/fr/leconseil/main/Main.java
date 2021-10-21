package fr.leconseil.main;

import java.sql.SQLException;

import fr.leconseil.accesbd.AccesBD;
import fr.leconseil.model.Compte;
import fr.leconseil.model.Requetes;

public class Main extends AccesBD implements Requetes{

	public static void main(String[] args) throws SQLException {
		for (Compte compte : Requetes.getAllComptes()) {
			System.out.println(compte);
		}
	}

}
