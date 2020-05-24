package uvsq.exo9;

/**
 * interface AbstractFactoryJdbc.
 * 
 * @author Koussaila HAMMOUCHE.
 *
 */

public interface AbstractFactoryJdbc {
	/**
	 * creation CercleJdbc.
	 */
	Dao<Cercle> createCercleJdbc();

	/**
	 * creation GroupeJdbc.
	 */
	Dao<GroupeForme> createGroupeJdbc();

	/**
	 * creation CarreJdbc.
	 */
	Dao<Carre> createCarreJdbc();

	/**
	 * creation RectangleJdbc.
	 */
	Dao<Rectangle> createRectangleJdbc();

	/**
	 * creation TriangleJdbc.
	 */
	Dao<Triangle> crateTriangleJdbc();

}
