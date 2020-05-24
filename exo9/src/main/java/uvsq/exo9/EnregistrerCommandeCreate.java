package uvsq.exo9;

import java.sql.SQLException;
/**
 * class EnregistrerCommandeCreate.
 * 
 * @author Koussaila HAMMOUCHE .
 *
 */
public class EnregistrerCommandeCreate implements EnregistrerCommande
{
	/**
	 * forme à créer.
	 */
	private Forme forme;
	/**
	 * DaoFactory de type DaoFactory.
	 */
	private DaoFactoryJdbc factory;

	/**
	 * constructor de CommandDeCreation.
	 * 
	 * @param forme forme à créer
	 * @throws SQLException Exception SQL
	 */
	public EnregistrerCommandeCreate(final Forme forme) throws SQLException {
		this.forme = forme;
		this.factory = new DaoFactoryJdbc();

	}

	/**
	 * La methode getForme.
	 * 
	 * @return la forme cree
	 */
	public final Forme getForme() {
		return this.forme;
	}

	@Override
	public void execute() {
		Forme formeCree = null;
		if (forme instanceof Cercle) {
			Dao<Cercle> dao = factory.createCercleJdbc();
			formeCree = dao.create((Cercle) forme);

		} else if (forme instanceof Carre) {
			Dao<Carre> dao = factory.createCarreJdbc();
			formeCree = dao.create((Carre) forme);
		} else if (forme instanceof Rectangle) {
			Dao<Rectangle> dao = factory.createRectangleJdbc();
			formeCree = dao.create((Rectangle) forme);
		} else if (forme instanceof Triangle) {
			Dao<Triangle> dao = factory.crateTriangleJdbc();
			formeCree = dao.create((Triangle) forme);

		} else if (forme instanceof GroupeForme) {
			Dao<GroupeForme> dao = factory.createGroupeJdbc();
			formeCree = dao.create((GroupeForme) forme);

		} else {
			factory.close();
		}
		factory.close();
	}
}
