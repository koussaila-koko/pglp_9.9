package uvsq.exo9;

/**
 * class CommandMoveCercle.
 * 
 * @author Koussaila HAMMOUCHE.
 *
 */

public class CommandMoveCercle implements CommandMove {
	/**
	 * un cercle.
	 */
	private Cercle cercle;

	/**
	 * deplacemnt sur l'axe x.
	 */
	private int depX;

	/**
	 * deplacement sur l'axe y.
	 */
	private int depY;

	/**
	 * constructeur CommandMoveCercle.
	 * 
	 * @param c  cercle.
	 * @param dx deplacement sur l'axe x.
	 * @param dy deplacement sur l'axe y.
	 */
	public CommandMoveCercle(final Cercle c, final int dx, final int dy) {
		this.cercle = c;
		this.depX = dx;
		this.depY = dy;
	}

	@Override
	/**
	 * executer la commande du deplacement pour un cercle.
	 */
	public void execute() {
		this.cercle.deplacer(depX, depY);
	}
}
