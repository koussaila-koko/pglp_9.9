package uvsq.exo9;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * classe GroupeDaoJdbc . koussaila HAMMOUCHE .
 */
public class GroupeDaoJdbc implements Dao<GroupeForme> {
	/**
	 * classe GroupeDaoJdbc .
	 */
	private Connection conn = null;
	String sql = "CREATE TABLE Groupes (nomGroupe varchar(40) PRIMARY KEY NOT NULL) ";
	/**
	 * Statement .
	 */
	private Statement statement;

	/**
	 * GroupeDaoJdbc .
	 * 
	 * @param connect connexion
	 */
	public GroupeDaoJdbc(final Connection connect) {
		this.conn = connect;
		try {
			statement = conn.createStatement();
			if (!doesTableExists("Groupes", conn)) {
				statement.execute(sql);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * create .
	 * 
	 * @param obj
	 */
	public GroupeForme create(final GroupeForme obj) {
		PreparedStatement statement = null;
		int rowsInserted = 0;
		String insert = "INSERT INTO Groupes (nomGroupe) VALUES (?)";
		try {
			statement = conn.prepareStatement(insert);
			statement.setString(1, obj.getName());
			rowsInserted = statement.executeUpdate();
			ArrayList<Forme> l = obj.getFormes();
			int verifie = 0;
			while (verifie < l.size()) {
				if (l.get(verifie) instanceof GroupeForme) {
					this.create((GroupeForme) l.get(verifie));
				}
				verifie++;
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

		if (rowsInserted > 0) {
			System.out.println("Un nouveau groupe est ajouté!");
			return obj;
		} else {
			return null;
		}

	}

	/**
	 * find .
	 * 
	 * @param id .
	 */
	public GroupeForme find(final String id) {
		GroupeForme g = null;

		PreparedStatement statementG = null;
		PreparedStatement statementCr = null;
		PreparedStatement statementCl = null;
		PreparedStatement statementT = null;
		PreparedStatement statementR = null;
		Carre c = null;
		Cercle cl = null;
		Triangle t = null;
		Rectangle r = null;
		String selectG = "select * from Groupes where nomGroupe = (?)";
		String selectCr = "select * from carre where nom = (?)";
		String selectCl = "select * from cercle where nom = (?)";
		String selectT = "select * from triangle where nom = (?)";
		String selectR = "select * from rectangle where nom = (?)";
		try {
			statementG = conn.prepareStatement(selectG);
			statementG.setString(1, id);
			statementG.execute();
			ResultSet resultG = statementG.getResultSet();
			if (resultG.next()) {
				String nomGroupe = resultG.getString("nomGroupe");
				g = new GroupeForme(nomGroupe);
				try {
					statementCr = conn.prepareStatement(selectCr);
					statementCr.setString(1, id);
					statementCr.execute();
					ResultSet resultCr = statementCr.getResultSet();
					while (resultCr.next()) {
						String nom = resultCr.getString("nom");
						int px = resultCr.getInt("px");
						int py = resultCr.getInt("py");
						double cote = resultCr.getDouble("cote");
						c = new Carre(nom, new Point(px, py), cote);
						g.add(c);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					statementCl = conn.prepareStatement(selectCl);
					statementCl.setString(1, id);
					statementCl.execute();
					ResultSet resultCl = statementCl.getResultSet();
					while (resultCl.next()) {
						String nom = resultCl.getString("nom");
						int px = resultCl.getInt("px");
						int py = resultCl.getInt("py");
						double rayon = resultCl.getDouble("rayon");
						cl = new Cercle(nom, new Point(px, py), rayon);
						g.add(cl);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					statementT = conn.prepareStatement(selectT);
					statementT.setString(1, id);
					statementT.execute();
					ResultSet resultT = statementT.getResultSet();
					while (resultT.next()) {
						String nom = resultT.getString("nom");
						int p1x = resultT.getInt("p1x");
						int p1y = resultT.getInt("p1y");
						int p2x = resultT.getInt("p2x");
						int p2y = resultT.getInt("p2y");
						int p3x = resultT.getInt("p3x");
						int p3y = resultT.getInt("p3y");
						t = new Triangle(nom, new Point(p1x, p1y), new Point(p2x, p2y), new Point(p3x, p3y));
						g.add(t);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					statementR = conn.prepareStatement(selectR);
					statementR.setString(1, id);
					statementR.execute();
					ResultSet resultR = statementR.getResultSet();
					while (resultR.next()) {
						String nom = resultR.getString("nom");
						int px = resultR.getInt("px");
						int py = resultR.getInt("py");
						double lon = resultR.getDouble("longueur");
						double lar = resultR.getDouble("largeur");
						r = new Rectangle(nom, new Point(px, py), lon, lar);
						g.add(r);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (statementG != null) {
				statementG.close();
			}
			if (statementCr != null) {
				statementCr.close();
			}
			if (statementCl != null) {
				statementCl.close();
			}
			if (statementT != null) {
				statementT.close();
			}
			if (statementR != null) {
				statementR.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return g;
	}

	/**
	 * update pour modifier .
	 * 
	 * @param obj de type GroupeForme
	 */
	public GroupeForme update(final GroupeForme obj) {
		PreparedStatement statementCr = null;
		PreparedStatement statementCl = null;
		PreparedStatement statementT = null;
		PreparedStatement statementR = null;
		PreparedStatement statement = null;
		int rowsUpdated = 0;
		String update = "UPDATE Groupes SET nomGroupe=(?) ";
		try {
			statement = conn.prepareStatement(update);
			statement.setString(1, obj.getName());

			rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Un groupe existant a bien été modifier !");
			}
			ArrayList<Forme> listFormes = obj.getFormes();
			for (Forme f : listFormes) {
				if (f instanceof Carre) {
					// conn = this.getConnection();
					String updateCr = "UPDATE carre SET  px = ?, py = ?, cote =? WHERE nom=?";
					statementCr = conn.prepareStatement(updateCr);
					statementCr.setInt(2, ((Carre) f).getP().getX());
					statementCr.setInt(3, ((Carre) f).getP().getY());
					statementCr.setDouble(4, ((Carre) f).getCote());
					statementCr.setString(5, ((Carre) f).getName());
					int rowsUpdatedCr = statementCr.executeUpdate();
					if (rowsUpdatedCr > 0) {
						System.out.println("Un carre existant a bien été modifier !");
					}
				}
				if (f instanceof Cercle) {
					String updatecercle = "UPDATE cercle SET px = ?, py = ?, rayon =? WHERE nom=?";
					statementCl = conn.prepareStatement(updatecercle);
					statementCl.setInt(2, ((Cercle) f).getCentre().getX());
					statementCl.setInt(3, ((Cercle) f).getCentre().getY());
					statementCl.setDouble(4, ((Cercle) f).getRayon());
					statementCl.setString(5, ((Cercle) f).getName());
					int rowsUpdatedCl = statementCl.executeUpdate();
					if (rowsUpdatedCl > 0) {
						System.out.println("Un cercle existant a bien été modifier !");
					}
				}
				if (f instanceof Triangle) {
					String updatetr = "UPDATE triangle SET    p1x = ?, p1y = ?, p2x = ?, p2y = ?, p3x = ?, p3y = ?  WHERE nom=?";
					statementT = conn.prepareStatement(updatetr);

					statementT.setInt(2, ((Triangle) f).getP1().getX());
					statementT.setInt(3, ((Triangle) f).getP1().getY());
					statementT.setInt(4, ((Triangle) f).getP2().getX());
					statementT.setInt(5, ((Triangle) f).getP2().getY());
					statementT.setInt(6, ((Triangle) f).getP3().getX());
					statementT.setInt(7, ((Triangle) f).getP3().getY());
					statementT.setString(8, ((Triangle) f).getName());
					int rowsUpdatedT = statementT.executeUpdate();
					if (rowsUpdatedT > 0) {
						System.out.println("Un triangle existant a bien été modifier!");
					}
				}
				if (f instanceof Rectangle) {
					String updater = "UPDATE rectangle SET    px = ?, py = ?, longueur =?, largeur=?  WHERE nom=?";
					statementR = conn.prepareStatement(updater);

					statementR.setInt(2, ((Rectangle) f).getP().getX());
					statementR.setInt(3, ((Rectangle) f).getP().getY());
					statementR.setDouble(4, ((Rectangle) f).getLongueur());
					statementR.setDouble(5, ((Rectangle) f).getLargeur());
					statementR.setString(6, ((Rectangle) f).getName());
					int rowsUpdatedR = statementR.executeUpdate();
					if (rowsUpdatedR > 0) {
						System.out.println("Un rectangle existant a bien été modifier !");
					}
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * delete suprimer le groupe obj .
	 * 
	 * @param obj .
	 */
	public void delete(final GroupeForme obj) {
		PreparedStatement statement = null;
		int rowsDeleted = 0;
		String delete = "Delete from Groupes where  nomGroupe=?";
		try {
			statement = conn.prepareStatement(delete);
			statement.setString(1, obj.getName());
			rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Un membre du groupe a été supprimé avec succé!");
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
	 * @return renvoie une valeur booléenne si l'objet Result Set contient plus de
	 *         lignes.
	 * @throws SQLException Exception sql.
	 */

	boolean doesTableExists(final String tableName, final Connection c) throws SQLException {
		DatabaseMetaData meta = c.getMetaData();
		ResultSet result = meta.getTables(null, null, tableName.toUpperCase(), null);

		return result.next();
	}

}
