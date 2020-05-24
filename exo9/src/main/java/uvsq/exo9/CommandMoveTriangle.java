package uvsq.exo9;

/**
 * class CommandMoveTriangle.
 * 
 * @author Koussaila HAMMOUCHE.
 *
 */

public class CommandMoveTriangle implements CommandMove {

	/**
	 * un triangle.
	 */
	private Triangle tr;

	/**
	 * deplacemnt sur l'axe x.
	 */
	private int depX;

	/**
	 * deplacement sur l'axe y.
	 */
	private int depY;

	/**
	 * constructeur CommandMoveTriangle.
	 * 
	 * @param t triangle.
	 * @param dx deplacement x.
	 * @param dy deplacment y.
	 */
	public CommandMoveTriangle(final Triangle triang,final int dx,
			final int dy) {
		this.tr = triang;
		this.depX = dx;
		this.depY = dy;
	}

	/**
	 * executer la commade de deplacement d un triangle.
	 */
	@Override
	public void execute() {
		this.tr.deplacer(depX, depY);
	}
}
