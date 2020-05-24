package uvsq.exo9;

/**
 * class CommandCreateRectangle.
 * 
 * @author Koussaila HAMMOUCHE.
 *
 */
public class CommandCreateRectangle implements CommandCreateForme<Rectangle> {

	/**
	 * nom d rectangle.
	 */
	private String name;

	/**
	 * le point reference.
	 */
	private Point pointRect;

	/**
	 * la longueur d rectangle.
	 */
	private double lon;

	/**
	 * la largeur d rectangle.
	 */
	private double lar;

	/**
	 * costructeur CommandCreateRectangle.
	 *
	 * @param nom  nom d rectangle .
	 * @param p   le point reference.
	 * @param lon la longueur d rectangle.
	 * @param lar la largeur d rectangle.
	 */
	public CommandCreateRectangle(final String nom, final Point p, final double lon, final double lar) {
		this.name = nom;
		this.pointRect = p;
		this.lon = lon;
		this.lar = lar;
	}

	@Override
	/**
	 * executer la commande de creation de rectangle.
	 */
	public Rectangle execute() {
		return new Rectangle(name, pointRect, lon, lar);
	}

}
