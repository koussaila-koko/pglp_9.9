package uvsq.exo9;

/**
 * class CommadCreateGroup utiliser une commande pour creér un groupe.
 * 
 * @author Koussaila HAMMOUCHE.
 *
 */

public class CommadCreateGroup implements CommandCreateForme<GroupeForme> {

	/**
	 * nom du groupe.
	 */
	private String name;

	/**
	 * constructeur CommadCreateGroup.
	 * 
	 * @param name nom du groupe.
	 */
	public CommadCreateGroup(final String name) {
		this.name = name;
	}

	/**
	 * execute pour executer la commande de creation du groupe.
	 */
	public GroupeForme execute() {
		return new GroupeForme(name);
	}

}
