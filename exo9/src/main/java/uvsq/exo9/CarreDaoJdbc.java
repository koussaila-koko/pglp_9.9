package uvsq.exo9;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * class CarreDaoJdbc.
 * 
 * @author koussaila HAMMOUCHE.
 *
 */

public class CarreDaoJdbc implements Dao<Carre> {
	/**
	 * conn la connection est null.
	 */
	private Connection conn = null;

	/**
	 * creation de la table carre avec le nom comme id.
	 */
	private String sql = "CREATE TABLE  carre (nom varchar(20) NOT NULL PRIMARY KEY , " + "px int not null , "
			+ "py int not null ," + "cote double not null ) ";
	/**
	 * Statement statement.
	 */
	private Statement statement;

	/**
	 * le constructor CarreDaoJdbc. il test si la table elle n'existe
	 * pas dans deja dans sa connection apres il excute la reque
	 * sql pour cree la table carré
	 * 
	 * @param c la connexion .
	 */
	public CarreDaoJdbc(Connection c) {
		this.conn = c;
		try {
			statement = conn.createStatement();
			if (!doesTableExists("carre", conn)) {
				statement.execute(sql);
			}
			statement.close();
			// conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * create pour créé un caréé on recuper les donnees de carré
	 *on inser dans la
	 * conn ces donner recuperer
	 * 
	 * @param obj de type carré
	 * @return obj le nouveu carre
	 */
	public Carre create(final Carre obj) {
		PreparedStatement statement = null;
		int res = 0;
		String insert = "INSERT INTO carre (nom, px, py , cote) VALUES (?, ?, ?,?)";
		try {
			statement = conn.prepareStatement(insert);
			statement.setString(1, obj.getName());
			statement.setInt(2, obj.getP().getX());
			statement.setInt(3, obj.getP().getY());
			statement.setDouble(4, obj.getCote());
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
			System.out.println("Un nouveau carre a bien été inséré");
			return obj;
		} else {
			return null;
		}
	}

	/**
	 * find elle cherche un carré qui a le nom s .
	 * dans la bdd si il existe elle
	 * retourne ce carré sinon elle nous renvoie un message
	 *
	 * @param s le nom de carré a cherche
	 * @throws SQLException En cas d'erreur d'ecriture .
	 */
	public Carre find(final String s) {
		Carre c = null;
		PreparedStatement statement = null;
		String select = "SELECT * FROM carre where nom = (?)";
		try {
			statement = conn.prepareStatement(select);
			statement.setString(1, s);
			statement.execute();
			ResultSet result = statement.getResultSet();
			if (result.next()) {
				String nom = result.getString("nom");
				int px = result.getInt("px");
				int py = result.getInt("py");
				double cote = result.getDouble("cote");
				c = new Carre(nom, new Point(px, py), cote);
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
	 * update pour modifier le carré obj .
	 * on recupere les nouveux valeur de carré et modifier le carré
	 * @param obj le carré a modifer.
	 */
	public Carre update(final Carre obj) {
		int rowsUpdated = 0;
		PreparedStatement statement = null;
		String update = "UPDATE carre SET    px = ?, py = ?, cote =? WHERE nom=?";
		try {
			statement = conn.prepareStatement(update);
			statement.setInt(1, obj.getP().getX());
			statement.setInt(2, obj.getP().getY());
			statement.setDouble(3, obj.getCote());
			statement.setString(4, obj.getName());
			rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("les  mis à jour ont bien été modifier");
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
	 * delete pour supprimer un tuble dans la table carré.
	 * on recuper le nom de carré 
	 * grace a son nom (id) on peut le supprimer
	 * @param obj cest un carré .
	 */
	public void delete(final Carre obj) {
		PreparedStatement statement = null;
		int rowsDeleted = 0;
		String delete = "delete from carre where nom=?";
		try {
			statement = conn.prepareStatement(delete);
			statement.setString(1, obj.getName());
			rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Un membre du carre a été supprimé avec succès!");
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
	 * poue verifier si une table existe ?.
	 * @param tableName nom de la table.
	 * @param c     la connexion.
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
