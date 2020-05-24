package uvsq.exo9;

import uvsq.exo9.Forme;

/**
 * class Triangle.
 * 
 * @author koussaila HAMMOUCHE.
 *
 */

public class Triangle extends Forme {
	/**
	 * le 3 Points pour creer un triangle.
	 */

	private Point p1, p2, p3;

	/**
	 * constructeur Triangle.
	 * 
	 * @param name nom du triangle.
	 * @param p1   le premier P
	 * @param p2   le deuxième Point.
	 * @param p3   le troisième Point.
	 */
	public Triangle(final String name, final Point p1,
			final Point p2,final Point p3) {
		super(name);
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	/**
	 * mretourne le premier Point
	 * 
	 * @return p1.
	 */
	public Point getP1() {
		return p1;
	}

	/**
	 *  retourne le deuxième Point
	 * 
	 * @return p2.
	 */
	public Point getP2() {
		return p2;
	}

	/**
	 * retourne le troisième Point.
	 * 
	 * @return p3.
	 */
	public Point getP3() {
		return p3;
	}

	/**
	 *  deplacer le triangle.
	 *  @param x
	 *  @param y
	 */
	public void deplacer(final int x, final int y) {
		this.p1.sommePoint(x, y);
		this.p2.sommePoint(x, y);
		this.p3.sommePoint(x, y);

	}

	/**
	 *  afficher le triangle.
	 */
	public void print() {
		System.out.println("Triangle{" + "Nom='" + this.getName() + '\'' + ", p1=" + p1.toString() + ", p2="
				+ p2.toString() + ", p3=" + p3.toString() + "}\n");
	}

}
