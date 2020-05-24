package uvsq.exo9;

import java.sql.SQLException;

/**
 * class EnregisterCommandeMove.
 * 
 * @author Koussaila HAMMOUCHE .
 *
 */
public class EnregisterCommandeMove implements EnregistrerCommande {

	/**
	 * forme à créer.
	 */
	private Forme forme;
	/**
	 * DaoFactory de type DaoFactory.
	 */
	private DaoFactoryJdbc factory;

	/**
	 * constructeur de la classe CommandDeCreation.
	 * 
	 * @param forme forme à créer
	 * @throws SQLException lever les Exceptions SQL
	 */
	public EnregisterCommandeMove(final Forme forme) throws SQLException {
		this.factory = new DaoFactoryJdbc();
		this.forme = forme;
	}

	/**
	 * La methode getForme.
	 * 
	 * @return la forme cree
	 */
	public final Forme getForme() {
		return this.forme;
	}

	/**
	 * La methode execute. la methode qui cree la forme choisi .
	 * 
	 */
	@Override
	public void execute() {
		Forme formeCree = null;
		if (forme instanceof Cercle) {
			Dao<Cercle> dao = factory.createCercleJdbc();
			formeCree = dao.update((Cercle) forme);
		} else if (forme instanceof Carre) {
			Dao<Carre> dao = factory.createCarreJdbc();
			formeCree = dao.update((Carre) forme);

		} else if (forme instanceof Rectangle) {
			Dao<Rectangle> dao = factory.createRectangleJdbc();
			formeCree = dao.update((Rectangle) forme);
		} else if (forme instanceof Triangle) {
			Dao<Triangle> dao = factory.crateTriangleJdbc();
			formeCree = dao.update((Triangle) forme);

		} else if (forme instanceof GroupeForme) {
			Dao<GroupeForme> dao = factory.createGroupeJdbc();
			formeCree = dao.update((GroupeForme) forme);

		} else {
			factory.close();
		}
		factory.close();
	}
}
