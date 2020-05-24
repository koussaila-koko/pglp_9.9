package uvsq.exo9;

/**
 * class CommandCreatTriangle.
 * 
 * @author Koussaila HAMMOUCHE.
 *
 */
public class CommandCreatTriangle implements CommandCreateForme<Triangle> {

	/**
	 * nom triangle.
	 */
	private String name;

	/**
	 * le premier point .
	 */
	private Point p1;

	/**
	 * le deuxième point .
	 */
	private Point p2;

	/**
	 * le troisième ponit.
	 */
	private Point p3;

	/**
	 * constructeur CommandCreatTriangle.
	 * 
	 * @param name le nom d triangle.
	 * @param np1  point 1.
	 * @param np2  point 2.
	 * @param np3  point 3.
	 */
	public CommandCreatTriangle(final String name, final Point np1, final Point np2, final Point np3) {
		this.name = name;
		this.p1 = np1;
		this.p2 = np2;
		this.p3 = np3;
	}

	@Override
	/**
	 * executer la commande de creation d'un triangle.
	 */
	public Triangle execute() {
		return new Triangle(name, p1, p2, p3);
	}

}
