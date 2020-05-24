package uvsq.exo9;

/**
 * class Cercle.
 * 
 * @author koussaila HAMMOUCHE.
 *
 */
public class Cercle extends Forme {

	/**
	 * point centre du cercle.
	 */
	private Point centre;

	/**
	 * rayon du cercle.
	 */
	private double rayon;

	/**
	 * construteur Cercle.
	 * 
	 * @param name   de la Cercle.
	 * @param centre de cercle.
	 * @param rayon  de cercle.
	 */
	public Cercle(final String name, final Point centre, final  double rayon) {
		super(name);
		this.centre = centre;
		this.rayon = rayon;
	}

	/**
	 * retouner le centre du cercle.
	 * 
	 * @return centre.
	 */
	public Point getCentre() {
		return centre;
	}

	/**
	 * retourner le rayon.
	 * 
	 * @return le rayon.
	 */
	public double getRayon() {
		return rayon;
	}

	/**
	 * deplacer le cercle.
	 * 
	 * public void deplacer(int x, int y) { this.centre.setX(centre.getX() + x);
	 * this.centre.setY(centre.getY() + y); }
	 */

	/**
	 * methode pour affichager le dessin .
	 */
	public void print() {

		System.out.println("Cercle{" + "Nom='" + this.getName() + '\'' + ", Centre=" + centre.toString() + ", Rayon="
				+ rayon + "}\n");

	}

	@Override
	/**
	 * methode pour deplacer . 
	 * @param x c'est la valeur de deplacement pour x .
	 * 
	 * @param y c'est la valeur de deplacement pour y.
	 */
	public void deplacer(final int x, final int y) {

		this.centre.sommePoint(x, y);
	}

}
