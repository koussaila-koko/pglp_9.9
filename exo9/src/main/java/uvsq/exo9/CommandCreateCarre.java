package uvsq.exo9;

/**
 * class CommandCreateCarre une commande pour creation d'un carre.
 * 
 * @author Koussaila HAMMOUCHE.
 *
 */

public class CommandCreateCarre implements CommandCreateForme<Carre> {
	/**
	 * nom de carre.
	 */
	private String nom;

	/**
	 * point_car reference le centre.
	 */
	private Point point_car;

	/**
	 * cote de carre.
	 */
	private double cote;

	/**
	 * constructeur CommandCreateCarre.
	 * 
	 * @param nom  nom de carre.
	 * @param p    point centre d carré.
	 * @param cote d'un carre.
	 */
	public CommandCreateCarre(final String nom, final Point p, final double cote) {
		this.nom = nom;
		this.point_car = p;
		this.cote = cote;
	}

	@Override
	/**
	 * executer la commande du reation du carre.
	 */
	public Carre execute() {
		return new Carre(nom, point_car, cote);
	}

}
