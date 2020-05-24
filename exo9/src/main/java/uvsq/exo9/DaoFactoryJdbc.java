package uvsq.exo9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * class DaoFactoryJdbc.
 * 
 * @author Koussaila HAMMOUCHE .
 *
 */

public class DaoFactoryJdbc implements AbstractFactoryJdbc {
	/**
	 * connect connexion .
	 */
	private Connection connect = null;
	/**
	 * constroctor de DaoFactoryJdbc
	 * @throws SQLException Exception sql.
	 */
	public DaoFactoryJdbc() throws SQLException {
		this.connect = DriverManager.getConnection("jdbc:derby:bddDessin;create=true");
	}
	/**
	 * createCarreJdbc pour un carré .
	 */
	public Dao<Carre> createCarreJdbc() {
		return new CarreDaoJdbc(connect);
	}
	/**
	 * createCarreJdbc cercle.
	 */
	public Dao<Cercle> createCercleJdbc() {
		return new CercleDaoJdbc(connect);
	}
	/**
	 * createCarreJdbc Rectangle .
	 */
	public Dao<Rectangle> createRectangleJdbc() {
		return new RectangleDaoJdbc(connect);
	}
	/**
	 * createCarreJdbc Triangle .
	 */
	public Dao<Triangle> crateTriangleJdbc() {
		return new TriangleDaoJdbc(connect);
	}
	/**
	 * createCarreJdbc GroupeForme .
	 */
	public Dao<GroupeForme> createGroupeJdbc() {
		return new GroupeDaoJdbc(connect);
	}
	/**
	 * close   .
	 */
	public void close() {
		try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
