package uvsq.exo9;

import uvsq.exo9.Forme;

/**
 * class Rectangle.
 * 
 * @author koussaila HAMMOUCHE.
 *
 */

public class Rectangle extends Forme {

	/**
	 * point pour creer un rectangle.
	 */
	private Point point;

	/**
	 * longueur du rectangle.
	 */
	private double longueur;

	/**
	 * argeur du rectangle.
	 */
	private double largeur;

	/**
	 * constructeur Rectangle.
	 * 
	 * @param name du rectangle.
	 * @param p    point pour creer un rectangle.
	 * @param lon  longueur du rectangle.
	 * @param lar  largeur du rectangle.
	 */
	public Rectangle(final String name, final Point p, final double lon, final double lar) {
		super(name);
		this.point = p;
		this.longueur = lon;
		this.largeur = lar;
	}

	/**
	 * retourner le point.
	 * 
	 * @return p.
	 */
	public Point getP() {
		return point;
	}

	/**
	 * retoune la longueur du rectangle.
	 * 
	 * @return longueur.
	 */
	public double getLongueur() {
		return longueur;
	}

	/**
	 * retourne la largeur du rectangle.
	 * 
	 * @return largeur.
	 */
	public double getLargeur() {
		return largeur;
	}

	/**
	 * print le rectangle
	 */
	public void print() {
		System.out.println("Rectangle{" + "nom='" + this.getName() + '\'' + ", p1=" + point.toString() + ", longueur="
				+ longueur + ", largeur=" + largeur + "}\n");

	}

	/**
	 * deplacer le rectangle
	 * 
	 * @param x .
	 * @param y .
	 */
	@Override
	public void deplacer(final int x, final int y) {
		this.point.sommePoint(x, y);

	}

}
