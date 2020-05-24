package uvsq.exo9;

/**
 * class Carre.
 * 
 * @author koussaila HAMMOUCHE.
 *
 */

public class Carre extends Forme {

	/**
	 * le centre de carré point cest le point de carre px et py.
	 */
	private Point point;

	/**
	 * la taille de coter de carré.
	 */
	private double cote;

	/**
	 * constructor Carre.
	 * 
	 * @param nom  de Carre.
	 * @param p    point pour creer un carré.
	 * @param cote le cote d'un carré.
	 */
	public Carre(final String nom, final Point p, final double cote) {
		super(nom);
		this.point = p;
		this.cote = cote;
	}

	/**
	 * getP qui vas nous permettre de retourner le point .
	 * 
	 * @return point .
	 */
	public Point getP() {
		return point;
	}

	/**
	 * getCote qui vas nous permettre de retourner le cote de caréé.
	 * 
	 * @return cote double.
	 */

	public double getCote() {
		return cote;
	}

	/**
	 * afficher les informations de carré.
	 */
	public void print() {
		System.out.println(
				"Carré{" + "Nom='" + this.getName() + '\'' + ", centre=" + point.toString() + ", cote=" + cote + "}\n");

	}

	@Override
	/**
	 * deplacer c'est pour deplacer le carré . dans ce projet pour deplacer un carré
	 * on deplace son point car le point est son centre
	 * 
	 * @param x de combien deplacer le point x
	 * @param y de combien deplacer le point y
	 */
	public void deplacer(final int x, final int y) {

		this.point.sommePoint(x, y);
	}
}
