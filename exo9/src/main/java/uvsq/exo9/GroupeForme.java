package uvsq.exo9;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * class GroupeForme.
 * 
 * @author koussaila HAMMOUCHE.
 *
 */

public class GroupeForme extends Forme {
	/**
	 * formes liste des formes du groupe.
	 */

	private ArrayList<Forme> formes;

	/**
	 * constructeur du GroupeForme.
	 * 
	 * @param nom de groupe.
	 */
	public GroupeForme(final String nom) {
		super(nom);
		this.formes = new ArrayList<Forme>();
	}

	/**
	 * ajouter une forme dans un groupe.
	 * 
	 * @param nf forme.
	 */
	public void add(final Forme nf) {
		this.formes.add(nf);
	}

	/**
	 * supprimer une forme dans un groupe.
	 * 
	 * @param nf une forme.
	 */
	public void remove(final Forme nf) {
		if (formes.contains(nf)) {
			this.formes.remove(nf);
		} else {
			System.out.println("l'element n'existe pas ");
		}
	}

	/**
	 * retourner la liste des formes d'un groupe.
	 * 
	 * @return formes.
	 */
	public ArrayList<Forme> getFormes() {
		return this.formes;
	}

	/**
	 * deplacer les formes du groupe.
	 * 
	 * @param dx .
	 * @param dy .
	 */
	public void deplacer(final int dx, final int dy) {
		for (Forme f : formes) {
			f.deplacer(dx, dy);
		}
	}

	/**
	 * methode pour afficher les formes du groupe.
	 */
	public void print() {
		System.out.println("Groupe :" + this.name);
		for (Forme f : formes) {

			f.print();
		}

	}

	/**
	 * getElementList elle retourn List .
	 */
	public List getElementList() {
		return (List) Collections.unmodifiableList(formes);
	}

	/**
	 * getListe elle retourne ArrayList .
	 */
	public ArrayList<Forme> getListe() {
		return this.formes;
	}

}
