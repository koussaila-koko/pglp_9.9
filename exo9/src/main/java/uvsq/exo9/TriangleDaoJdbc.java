package uvsq.exo9;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uvsq.exo9.Dao;

/**
 * class TriangleDaoJdbc.
 * 
 * @author koussaila HAMMOUCHE.
 *
 */

public class TriangleDaoJdbc implements Dao<Triangle> {
	private Connection conn;
	private Statement statement;
	private String sql = "CREATE TABLE  triangle (nom varchar(20) NOT NULL PRIMARY KEY , " + "p1x integer not null , "
			+ "p1y integer not null ," + "p2x integer not null , " + "p2y integer not null ,"
			+ "p3x integer not null , " + "p3y integer not null )";

	/**
	 * constructeur TriangleDaoJdbc().
	 * 
	 * @param connect .
	 */
	public TriangleDaoJdbc(final Connection connect) {
		this.conn = connect;
		try {
			statement = conn.createStatement();
			if (!doesTableExists("triangle", conn)) {
				statement.execute(sql);
			}
			// conn.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * methode pour insérer des tuples dans la table triangle.
	 * 
	 * @param obj .
	 */
	public Triangle create(final Triangle obj) {
		PreparedStatement statement = null;
		int rowsInserted = 0;
		String insert = "INSERT INTO triangle (nom, p1x, p1y ," + "p2x,p2y,p3x,p3y) VALUES (?, ?, ?,?,?,?,?)";
		try {
			statement = conn.prepareStatement(insert);
			statement.setString(1, obj.getName());
			statement.setInt(2, obj.getP1().getX());
			statement.setInt(3, obj.getP1().getY());
			statement.setInt(4, obj.getP2().getX());
			statement.setInt(5, obj.getP2().getY());
			statement.setInt(6, obj.getP3().getX());
			statement.setInt(7, obj.getP3().getY());
			rowsInserted = statement.executeUpdate();
			// conn.close();
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
			System.out.println("Un nouveau triangle a été inséré avec succès!");
			return obj;
		} else {
			return null;
		}
	}

	/**
	 * methode pour chercher des tuples dans la table triangle.
	 * 
	 * @param s .
	 */
	public Triangle find(final String s) {
		PreparedStatement statement = null;
		Triangle t = null;
		String select = "SELECT * FROM triangle where nom = (?)";
		try {
			statement = conn.prepareStatement(select);
			statement.setString(1, s);
			statement.execute();
			ResultSet result = statement.getResultSet();
			if (result.next()) {
				String nom = result.getString("nom");
				int p1x = result.getInt("p1x");
				int p1y = result.getInt("p1y");
				int p2x = result.getInt("p2x");
				int p2y = result.getInt("p2y");
				int p3x = result.getInt("p3x");
				int p3y = result.getInt("p3y");
				t = new Triangle(nom, new Point(p1x, p1y), new Point(p2x, p2y), new Point(p3x, p3y));
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
		return t;
	}

	/**
	 * modifier des tuples dans la table triangle.
	 * 
	 * @param obj .
	 */
	public Triangle update(final Triangle obj) {
		PreparedStatement statement = null;
		int rowsUpdated = 0;
		String update = "UPDATE triangle SET   , p1x = ?, p1y = ?,"
				+ " p2x = ?, p2y = ?, p3x = ?, p3y = ?  WHERE nom=?";
		try {
			statement = conn.prepareStatement(update);
			statement.setInt(1, obj.getP1().getX());
			statement.setInt(2, obj.getP1().getY());
			statement.setInt(3, obj.getP2().getX());
			statement.setInt(4, obj.getP2().getY());
			statement.setInt(5, obj.getP3().getX());
			statement.setInt(6, obj.getP3().getY());
			statement.setString(7, obj.getName());
			rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Un triangle existant a été mis à jour avec succès !");
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
	 * supprimer des tuples dans la table triangle.
	 * 
	 * @param obj .
	 */
	public void delete(Triangle obj) {
		PreparedStatement statement = null;
		int rowsDeleted = 0;
		String delete = "delete from triangle where nom=?";
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
	 * @param conn      la connexion.
	 * @return renvoie une valeur booléenne si l'objet ResultSet contient plus de
	 *         lignes.
	 * @throws SQLException Exception sql.
	 */
	boolean doesTableExists(final String tableName, final Connection conn) throws SQLException {
		DatabaseMetaData meta = conn.getMetaData();
		ResultSet result = meta.getTables(null, null, tableName.toUpperCase(), null);
		return result.next();
	}

}
