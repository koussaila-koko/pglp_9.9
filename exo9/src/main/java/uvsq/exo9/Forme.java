package uvsq.exo9;

/**
 * class abstract Forme.
 * 
 * @author koussaila HAMMOUCHE.
 *
 */

public abstract class Forme {
	/**
	 * retourner le nom.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 *  nom de la forme.
	 */
	protected String name;

	/**
	 * constructeur Forme.
	 * 
	 * @param nom de la forme.
	 */
	public Forme(final String nom) {
		this.name = nom;
	}

	/**
	 * methode pour deplacer une forme.
	 * 
	 * @param x position du x.
	 * @param y position du y.
	 */
	public abstract void deplacer(final int dx, final int dy);


	public abstract void print();

}
