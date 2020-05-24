package uvsq.exo9;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * class CercleDaoJdbc.
 * 
 * @author koussaila HAMMOUCHE.
 *
 */
public class CercleDaoJdbc implements Dao<Cercle> {

	/**
	 * conn la connexion.
	 */
	private Connection conn = null;

	/**
	 * la requte de creation de la table cercle.
	 */
	private String sql = "CREATE TABLE  cercle (nom varchar(20) NOT NULL PRIMARY KEY , " + "px integer not null , "
			+ "py integer not null ," + "rayon double not null ) ";
	/**
	 * statement .
	 */
	private Statement statement;

	/**
	 * constructor CercleDaoJdbc.
	 *
	 * @param connect la connexion
	 */
	public CercleDaoJdbc(final Connection connect) {
		this.conn = connect;
		try {
			statement = conn.createStatement();
			if (!doesTableExists("cercle", conn)) {
				statement.execute(sql);
			}
			statement.close();
			// conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * insérer des tuples dans la table cercle. on recupere ces informations apres
	 * on insere dans la table
	 *
	 * @return obj le nouveux cercle.
	 */
	public Cercle create(final Cercle obj) {
		PreparedStatement statement = null;
		int res = 0;
		String insert = "INSERT INTO cercle (nom, px, py , rayon) VALUES (?, ?, ?,?)";
		try {
			statement = conn.prepareStatement(insert);
			statement.setString(1, obj.getName());
			statement.setInt(2, obj.getCentre().getX());
			statement.setInt(3, obj.getCentre().getY());
			statement.setDouble(4, obj.getRayon());
			res = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (res > 0) {
			System.out.println("Un nouveau cercle a été inséré avec succès!");
			return obj;
		} else {
			return null;
		}
	}

	/**
	 * find pour cherhcher si il exite un touble dans la table cercle.
	 *
	 * @return c .
	 */
	public Cercle find(final String s) {
		Cercle c = null;
		PreparedStatement statement = null;
		String select = "SELECT * FROM cercle where nom = (?)";
		try {
			statement = conn.prepareStatement(select);
			statement.setString(1, s);
			statement.execute();
			ResultSet result = statement.getResultSet();
			if (result.next()) {
				String nom = result.getString("nom");
				int px = result.getInt("px");
				int py = result.getInt("py");
				double rayon = result.getDouble("rayon");
				c = new Cercle(nom, new Point(px, py), rayon);
				// c.print();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	/**
	 * update modifier des tuples dans la table cercle.
	 * 
	 * @return obj le nouveux cercle.
	 */
	public Cercle update(final Cercle obj) {
		PreparedStatement statement = null;
		int rowsUpdated = 0;
		String update = "UPDATE cercle SET    px = ?, py = ?, rayon =? WHERE nom=?";
		try {
			statement = conn.prepareStatement(update);
			statement.setInt(1, obj.getCentre().getX());
			statement.setInt(2, obj.getCentre().getY());
			statement.setDouble(3, obj.getRayon());
			statement.setString(4, obj.getName());
			rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Un cercle existant a été mis à jour avec succès !");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * supprimer des tuples dans la table cercle.
	 *
	 * @param obj le cercle.
	 */
	public void delete(final Cercle obj) {
		PreparedStatement statement = null;
		int rowsDeleted = 0;
		String delete = "delete from cercle where nom=?";
		try {
			statement = conn.prepareStatement(delete);
			statement.setString(1, obj.getName());
			rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Un membre du cercle a été supprimé avec succès!");
			} else {
				System.out.println("element n'existe pas");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * existance dun tuble dans une table.
	 * 
	 * @param tableName nom de la table.
	 * @param conn      la connexion.
	 * @return resultat 0 ou 1
	 * @throws SQLException Exception sql.
	 * 
	 */
	boolean doesTableExists(final String tableName, final Connection conn) throws SQLException {
		DatabaseMetaData meta = conn.getMetaData();
		ResultSet result = meta.getTables(null, null, tableName.toUpperCase(), null);
		return result.next();
	}

}
