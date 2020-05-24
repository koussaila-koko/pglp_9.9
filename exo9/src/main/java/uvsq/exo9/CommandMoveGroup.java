package uvsq.exo9;

/**
 * class CommandMoveGroup.
 * 
 * @author Koussaila HAMMOUCHE.
 *
 */

public class CommandMoveGroup implements CommandMove {

	/**
	 * un grouep.
	 */
	private GroupeForme groupe;

	/**
	 * deplacement sur l'axe x.
	 */
	private int depX;

	/**
	 * deplacement sur l'axe y.
	 */
	private int depY;

	/**
	 * constructor CommandMoveGroup.
	 * 
	 * @param g le groupe a deplacé.
	 * @param dx deplacement sur l'axe x.
	 * @param dy deplacemnt sur l'axe y.
	 */
	public CommandMoveGroup(final GroupeForme g, final int dx,
			final int dy) {
		this.groupe = g;
		this.depX = dx;
		this.depY = dy;
	}

	@Override
	/**
	 * executer la commande du deplacement pour un groupe.
	 */
	public void execute() {
		this.groupe.deplacer(depX, depY);
	}
}
