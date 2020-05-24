package uvsq.exo9;

/**
 * class CommandCreateCercle.
 * 
 * @author Koussaila HAMMOUCHE.
 *
 */

public class CommandCreateCercle implements CommandCreateForme<Cercle> {
	/**
	 * nom d un cercle.
	 */
	private String name;

	/**
	 * centre de cercle.
	 */
	private Point centre;

	/**
	 * le rayon de cercle.
	 */
	private double rayon;

	/**
	 * constructeur CommandCreateCercle.
	 * 
	 * @param name   nom de cercle
	 * @param centre centre de cercle.
	 * @param rayon  de cercle.
	 */
	public CommandCreateCercle(final String name, final Point centre,
			final double rayon) {
		this.name = name;
		this.centre = centre;
		this.rayon = rayon;
	}

	@Override
	/**
	 * executer la commande du creation de cercle.
	 */
	public Cercle execute() {
		return new Cercle(name, centre, rayon);
	}

}
