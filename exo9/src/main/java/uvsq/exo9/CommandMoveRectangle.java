package uvsq.exo9;

/**
 * class CommandMoveRectangle.
 * 
 * @author Koussaila HAMMOUCHE.
 *
 */

public class CommandMoveRectangle implements CommandMove {

	/**
	 * une reclange .
	 */
	private Rectangle rec;

	/**
	 * deplacement sur l'axe x.
	 */
	private int depX;

	/**
	 * deplacement sur l'axe y.
	 */
	private int depY;

	/**
	 * constructeur CommandMoveRectangle.
	 * 
	 * @param rectang un rectangle
	 * @param x   deplacemnt sur l'axe x.
	 * @param y   deplacement sur l'axe y.
	 */
	public CommandMoveRectangle(Rectangle rectang, int dx, int dy) {
		this.rec = rectang;
		this.depX = dx;
		this.depY = dy;
	}

	@Override
	/**
	 * executer la commande de deplacement du rectangle.
	 */
	public void execute() {
		this.rec.deplacer(depX, depY);
	}
}
