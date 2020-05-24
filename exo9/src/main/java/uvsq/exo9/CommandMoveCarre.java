package uvsq.exo9;

/**
 * class CommandMoveCarre.
 * 
 * @author Koussaila HAMMOUCHE.
 *
 */
public class CommandMoveCarre implements CommandMove {

	/**
	 * un carre.
	 */
	private Carre carre;

	/**
	 * deplacement sur l'axe x.
	 */
	private int depX;

	/**
	 * deplacement sur l'axe y.
	 */
	private int depY;

	/**
	 * constructeur CommandMoveCarre.
	 * 
	 * @param c  carre.
	 * @param dx deplacement sur l'axe x.
	 * @param dy deplacement sur l'axe y.
	 */
	public CommandMoveCarre(final Carre c, final int dx, final int dy) {
		this.carre = c;
		this.depX = dx;
		this.depY = dy;
	}

	/**
	 * executer la commande pour deplacer un carre.
	 */
	public void execute() {
		this.carre.deplacer(depX, depY);
	}

}
