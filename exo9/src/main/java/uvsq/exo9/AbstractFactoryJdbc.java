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
	 * @return GroupeForme .Dao
	 */
	Dao<GroupeForme> createGroupeJdbc();

	/**
	 * creation CarreJdbc.
	 * @return carre .Dao
	 */
	Dao<Carre> createCarreJdbc();

	/**
	 * creation RectangleJdbc.
	 * @return rectangle .Dao
	 */
	Dao<Rectangle> createRectangleJdbc();

	/**
	 * creation TriangleJdbc.
	 * @return triangle Dao
	 */
	Dao<Triangle> crateTriangleJdbc();

}
