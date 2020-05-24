package uvsq.exo9;

import java.sql.SQLException;
import java.util.Scanner;

public class DrawingApp {
	/** 
	 * lecture 
	  */
	private Scanner saisie;
	/** 
	 * interpreteur 
	 */
	private DrawingTUI dt;

	/** 
	 * constructeur de la class DrawingApp. 
	 */
	public DrawingApp() {
		dt = new DrawingTUI();
		saisie = new Scanner(System.in);
	}
	/**
	 * application run .
	 * @throws SQLException Exception sql.
	 */
	public void run(String[] args) throws SQLException {
		System.out.println("");
		System.out.println("----------------------------------------------");
		System.out.println("            Drawing App");
		System.out.println("Dessiner une Forme (Carre,Cercle,Rectangle,Triangle)");
		System.out.println("pout quiter entree exit ");
		System.out.println("");
		DrawingTUI dt = new DrawingTUI();
		System.out.println("Entrez une valide commande ou exit pour quitter ");
		String cmd = null;
		while (true) {
			if (saisie.hasNext()) {
				cmd = saisie.nextLine();
				if (saisie.equals("exit")) {
				} else {
					EnregistrerCommande c = dt.nextCommande(cmd);
					if (c != null) {
						c.execute();
					}
					dt.afficheAllFormes();
				}
			}
		}
	}
	/**
	 * le main faire l apple.
	 */
	public static void main(String[] args) {
		try {
			DrawingApp app = new DrawingApp();
			app.run(args);
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
