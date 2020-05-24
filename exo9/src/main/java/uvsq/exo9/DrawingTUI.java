package uvsq.exo9;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * class DrawingTui.
 * 
 * @author koussaila HAMMOUCHE.
 */
public class DrawingTUI {

	/**
	 * liste creer par l'utilisateur.
	 */
	private List<Forme> listeFormes;

	/**
	 * listes creer par l'utilisateur.
	 */
	private List<GroupeForme> listeGroupes;

	/**
	 * constructor DrawingTui.
	 */
	public DrawingTUI() {
		listeFormes = new ArrayList<Forme>();
		listeGroupes = new ArrayList<GroupeForme>();
	}

	/**
	 * getDepFormeCmd.
	 * 
	 * @param chaine entrer .
	 * @return cmd commande .
	 * @throws SQLException
	 */
	public EnregistrerCommande getDepFormeCmd(final String[] chaine) throws SQLException {
		EnregistrerCommande com = null;
		Icommande cmd = null;
		if (chaine.length == 4) {
			Forme forme = getForme(listeFormes, chaine[1]);
			if (forme == null) {
				forme = getGroupe(listeGroupes, chaine[1]);
				if (forme == null) {
					System.err.println("la forme n'existe pas");
				} else {
					int depX = Integer.parseInt(chaine[2]);
					int depY = Integer.parseInt(chaine[3]);

					if (forme instanceof GroupeForme) {

						cmd = new CommandMoveGroup((GroupeForme) forme, depX, depY);
						((CommandMove) cmd).execute();

					}

				}
			} else {
				int depX = Integer.parseInt(chaine[2]);
				int depY = Integer.parseInt(chaine[3]);
				if (forme instanceof Carre) {
					cmd = new CommandMoveCarre(((Carre) forme), depX, depY);
				}
				if (forme instanceof Cercle) {
					cmd = new CommandMoveCercle(((Cercle) forme), depX, depY);
				}
				if (forme instanceof Rectangle) {
					cmd = new CommandMoveRectangle(((Rectangle) forme), depX, depY);
				}
				if (forme instanceof Triangle) {
					cmd = new CommandMoveTriangle(((Triangle) forme), depX, depY);
				}
				((CommandMove) cmd).execute();
				com = new EnregisterCommandeMove(forme);
			}
			return com;
		} else {
			System.out.println("commande non valide");
			return null;
		}
	}

	/**
	 * getDepGroupeCmd.
	 * 
	 * @param chaine entrée par l'utilisateur pour la traiter.
	 */
	public Icommande getDepGroupeCmd(String[] chaine) {
		Icommande cmd = null;
		if (chaine.length == 4) {
			GroupeForme groupe = getGroupe(listeGroupes, chaine[1]);
			if (groupe == null) {
				System.err.println("la forme n'existe pas");
			} else {
				int depX = Integer.parseInt(chaine[2]);
				int depY = Integer.parseInt(chaine[3]);
				cmd = new CommandMoveGroup(groupe, depX, depY);
				((CommandMove) cmd).execute();
			}
			return cmd;
		} else {
			System.err.println("commande non valide");
			return null;
		}
	}

	/**
	 * getCreationCmd.
	 * 
	 * @param chaine entrer par l'utilisateur.
	 * @throws SQLException .
	 */
	public EnregistrerCommande getCreationCmd(String[] chaine) throws SQLException {
		EnregistrerCommande com = null;
		Icommande cmd = null;
		Forme forme = null;
		try {
			switch (chaine[1].toLowerCase()) {
			case "carre":
				if (chaine.length == 5) {
					String nom = chaine[0];
					int px = Integer.parseInt(chaine[2]);
					int py = Integer.parseInt(chaine[3]);
					Double cote = Double.parseDouble(chaine[4]);
					cmd = new CommandCreateCarre(nom, new Point(px, py), cote);
					forme = ((CommandCreateForme<Carre>) cmd).execute();
					this.listeFormes.add((Carre) forme);
					createGroupe((Carre) forme);
					com = new EnregistrerCommandeCreate(forme);
				} else {
					System.err.println("commande non valide");
					return null;
				}
				break;
			case "groupe":
				if (chaine.length >= 2) {
					String nom = chaine[0];
					cmd = new CommadCreateGroup(nom);
					GroupeForme g = ((CommandCreateForme<GroupeForme>) cmd).execute();
					for (int i = 0; i < chaine.length; i++) {
						for (Forme f : listeFormes) {
							if (chaine[i].equals(f.getName())) {
								f.print();
								g.add(f);
							}
						}
					}

					com = new EnregistrerCommandeCreate(g);
					this.listeGroupes.add((GroupeForme) forme);
				} else {
					System.err.println("commande non valide");
					return null;
				}
				break;
			case "cercle":
				if (chaine.length == 5) {
					String nom = chaine[0];
					int px = Integer.parseInt(chaine[2]);
					int py = Integer.parseInt(chaine[3]);
					Double rayon = Double.parseDouble(chaine[4]);
					cmd = new CommandCreateCercle(nom, new Point(px, py), rayon);
					forme = ((CommandCreateForme<Cercle>) cmd).execute();
					com = new EnregistrerCommandeCreate(forme);
					this.listeFormes.add((Cercle) forme);
					createGroupe((Cercle) forme);
				} else {
					System.err.println("commande non valide");
					return null;
				}
				break;
			case "rectangle":
				if (chaine.length == 6) {
					String nom = chaine[0];
					int px = Integer.parseInt(chaine[2]);
					int py = Integer.parseInt(chaine[3]);
					Double lon = Double.parseDouble(chaine[4]);
					Double lar = Double.parseDouble(chaine[5]);
					cmd = new CommandCreateRectangle(nom, new Point(px, py), lon, lar);
					forme = ((CommandCreateForme<Rectangle>) cmd).execute();
					com = new EnregistrerCommandeCreate(forme);
					this.listeFormes.add((Rectangle) forme);
					createGroupe((Rectangle) forme);
				} else {
					System.err.println("commande non valide");
					return null;
				}
				break;
			case "triangle":
				if (chaine.length == 8) {
					String nom = chaine[0];
					int p1x = Integer.parseInt(chaine[2]);
					int p1y = Integer.parseInt(chaine[3]);
					int p2x = Integer.parseInt(chaine[4]);
					int p2y = Integer.parseInt(chaine[5]);
					int p3x = Integer.parseInt(chaine[6]);
					int p3y = Integer.parseInt(chaine[7]);
					cmd = new CommandCreatTriangle(nom, new Point(p1x, p1y), new Point(p2x, p2y), new Point(p3x, p3y));
					forme = ((CommandCreateForme<Triangle>) cmd).execute();
					com = new EnregistrerCommandeCreate(forme);
					this.listeFormes.add((Triangle) forme);
					createGroupe((Triangle) forme);
				} else {
					System.err.println("commande non valide");
					return null;
				}
				break;
			case "exit":
				cmd = new CommandExit();
				((CommandMove) cmd).execute();
				break;
			default:
				System.err.println("commande non valide");
				return null;
			}
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			return null;
		}
		return com;
	}

	/**
	 * methode nextCommande pour traiter les commandes
	 * 
	 * @param text chiane entrée.
	 * @return commande a executer.
	 * @throws SQLException
	 */
	public EnregistrerCommande nextCommande(String text) throws SQLException {
		text = text.replace(" ", "");
		EnregistrerCommande commande = null;
		String textTraite = text.replaceAll("[()=,;]", " ");
		String[] chaine = textTraite.split("\\s+");
		try {
			switch (chaine[0].toLowerCase()) {
			case "move":
				commande = (EnregistrerCommande) getDepFormeCmd(chaine);
				break;
			default:
				commande = (EnregistrerCommande) getCreationCmd(chaine);
			}
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			return null;
		}
		return commande;
	}

	/**
	 * getForme retrouver une forme dans une liste.
	 * 
	 * @param l        la liste.
	 * @param nomForme nom de la forme.
	 * @return la forme avec le nom chercher.
	 */
	public Forme getForme(final List<Forme> l, final String nomForme) {
		for (Forme f : l) {
			if (f.getName().equals(nomForme)) {
				return f;
			}
		}
		return null;
	}

	/**
	 * getGroupe retrouver un groupe dans une liste.
	 * 
	 * @param l         la liste des groupes.
	 * @param nomGroupe nom du groupe.
	 * @return le groupe rechercher.
	 */
	public GroupeForme getGroupe(final List<GroupeForme> l, final String nomGroupe) {
		for (GroupeForme g : l) {
			if (g.getName().equals(nomGroupe)) {
				return g;
			}
		}
		return null;
	}

	/**
	 * createGroupe pour creation un groupe si il ne existe pas et ajouter la forme
	 * a ce groupe. si le groupe existe on ajoute seulement la forme a ce groupe.
	 * 
	 * @param f forme a ajouter dans le groupe
	 */
	public void createGroupe(final Forme f) {
		Boolean existeG = false;
		for (GroupeForme g : listeGroupes) {
			g.add(f);
			existeG = true;
		}
		if (existeG.equals(false)) {
			GroupeForme gr = new GroupeForme("groupe");
			listeGroupes.add(gr);
			gr.add(f);
		}
	}

	/**
	 * getlistGroupes retourner la liste des groupes créer.
	 * 
	 * @return listeGroupes.
	 */
	public List<GroupeForme> getlistGroupes() {
		return listeGroupes;
	}

	/**
	 * getlistFormes retourner la liste des formes créer.
	 * 
	 * @return listeFormes.
	 */
	public List<Forme> getlistFormes() {
		return listeFormes;
	}

	/**
	 * afficheAllFormesr retourner tous les formes créer.
	 */
	public void afficheAllFormes() {
		for (Forme forme : this.getlistGroupes()) {
			if (forme instanceof Carre) {
				((Carre) forme).print();
			}
			if (forme instanceof Cercle) {
				((Cercle) forme).print();
			}
			if (forme instanceof Rectangle) {
				((Rectangle) forme).print();
			}
			if (forme instanceof Triangle) {
				((Triangle) forme).print();
			}
			if (forme instanceof GroupeForme) {
				((GroupeForme) forme).print();
			}

		}

	}

}
