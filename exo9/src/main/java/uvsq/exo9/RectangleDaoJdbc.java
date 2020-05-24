package uvsq.exo9;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uvsq.exo9.Dao;

/**
 * class RectangleDaoJdbc.
 * 
 * @author koussaila HAMMOUCHE.
 *
 */

public class RectangleDaoJdbc implements Dao<Rectangle> {
	/**
	 * attribut connection.
	 */
	private Connection conn;
	/**
	 * attribut connection.
	 */
	private Statement statement;
	/**
	 * requete sql pour créer la table rectangle.
	 */
	private String sql = "CREATE TABLE  rectangle (nom varchar(20) NOT NULL PRIMARY KEY , " + "px integer not null , "
			+ "py integer not null ," + "longueur double not null," + "largeur double not null ) ";

	/**
	 * constructeur RectangleDaoJdbc.
	 */
	public RectangleDaoJdbc(Connection connect) {
		this.conn = connect;
		try {
			statement = conn.createStatement();
			if (!doesTableExists("rectangle", conn)) {
				statement.execute(sql);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * methode pour insérer des tuples dans la table rectangle.
	 * 
	 * @param obj
	 */
	public Rectangle create(final Rectangle obj) {
		PreparedStatement statement = null;
		int rowsInserted = 0;
		String insert = "INSERT INTO rectangle (nom, px, py ,longueur , largeur)" + " VALUES (?, ?, ?,?,?)";
		try {
			statement = conn.prepareStatement(insert);
			statement.setString(1, obj.getName());
			statement.setInt(2, obj.getP().getX());
			statement.setInt(3, obj.getP().getY());
			statement.setDouble(4, obj.getLongueur());
			statement.setDouble(5, obj.getLargeur());
			rowsInserted = statement.executeUpdate();
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
		if (rowsInserted > 0) {
			System.out.println("Un nouveau rectangle a été inséré avec succès!");
			return obj;
		} else {
			return null;
		}
	}

	/**
	 * chercher des tuples du la table rectangle.
	 * 
	 * @param s .
	 */
	public Rectangle find(final String s) {
		PreparedStatement statement = null;
		Rectangle r = null;
		String select = "SELECT * FROM rectangle where nom = (?)";
		try {
			statement = conn.prepareStatement(select);
			statement.setString(1, s);
			statement.execute();
			ResultSet result = statement.getResultSet();
			if (result.next()) {
				String nom = result.getString("nom");
				int px = result.getInt("px");
				int py = result.getInt("py");
				double lon = result.getDouble("longueur");
				double lar = result.getDouble("largeur");
				r = new Rectangle(nom, new Point(px, py), lon, lar);
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
		return r;
	}

	/**
	 * methode pour modifier des tuples du la table rectangle.
	 * 
	 * @param obj .
	 */
	public Rectangle update(Rectangle obj) {
		PreparedStatement statement = null;
		int rowsUpdated = 0;
		String update = "UPDATE rectangle SET    px = ?, py = ?," + " longueur =?, largeur=?  WHERE nom=?";
		try {
			statement = conn.prepareStatement(update);
			statement.setInt(2, obj.getP().getX());
			statement.setInt(3, obj.getP().getY());
			statement.setDouble(4, obj.getLongueur());
			statement.setDouble(5, obj.getLargeur());
			statement.setString(6, obj.getName());
			rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Un rectangle existant a été mis à jour avec succès !");
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
	 * supprimer des tupes du la table rectangle.
	 * 
	 * @param obj .
	 */
	public void delete(final Rectangle obj) {
		PreparedStatement statement = null;
		int rowsDeleted = 0;
		String delete = "delete from rectangle where nom=?";
		try {
			statement = conn.prepareStatement(delete);
			statement.setString(1, obj.getName());
			rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Un membre du rectangle a été supprimé avec succès!");
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
	 * methode pour savoir si la table existe déja ou non.
	 * 
	 * @param tableName nom de la table.
	 * @param c         la connexion.
	 * @return renvoie une valeur booléenne si l'objet ResultSet contient plus de
	 *         lignes.
	 * @throws SQLException Exception sql.
	 */
	boolean doesTableExists(final String tableName, final Connection c) throws SQLException {
		DatabaseMetaData meta = c.getMetaData();
		ResultSet result = meta.getTables(null, null, tableName.toUpperCase(), null);
		return result.next();
	}

}
