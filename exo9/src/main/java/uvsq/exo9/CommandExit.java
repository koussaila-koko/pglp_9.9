package uvsq.exo9;

/**
 * class CommandExit.
 * 
 * @author Koussaila HAMMOUCHE.
 *
 */
public class CommandExit implements CommandMove {

	/**
	 * executer la commande exit
	 * c'est pour quitter.
	 */
	@Override
	public void execute() {
		Runtime.getRuntime().exit(0);
	}

}
