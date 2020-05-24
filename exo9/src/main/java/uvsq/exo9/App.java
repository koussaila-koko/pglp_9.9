package uvsq.exo9;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws SQLException {
		System.out.println("Hellorldddddddddddd!");

		{
			// Connection connect = null;
			DaoFactoryJdbc m = new DaoFactoryJdbc();
			Dao<Cercle> cercle = m.createCercleJdbc();
			Dao<GroupeForme> groupe = m.createGroupeJdbc();
			Dao<Carre> carre = m.createCarreJdbc();
			Dao<Rectangle> rectangle = m.createRectangleJdbc();
			Dao<Triangle> tr = m.crateTriangleJdbc();

			Cercle c = new Cercle("idir", new Point(1, 1), 5);
			Carre ca = new Carre("liii", new Point(3, 2), 4);
			Triangle t = new Triangle("merdee", new Point(3, 2), new Point(3, 2), new Point(3, 2));
			Rectangle r = new Rectangle("ppfffff", new Point(3, 2), 3, 3);
			System.out.println("avant");
			cercle.create(c);
			Cercle CercleRead = cercle.find("idir");
			CercleRead.print();
			System.out.println("Apres");

			System.out.println("avant");
			carre.create(ca);
			Carre carreRead = carre.find("liii");
			carreRead.print();
			System.out.println("Apres");

			System.out.println("avant");
			tr.create(t);
			Triangle trRead = tr.find("merdee");
			trRead.print();
			System.out.println("Apres");

			System.out.println("avant");
			rectangle.create(r);
			Rectangle readRectangle = rectangle.find("ppfffff");
			readRectangle.print();
			System.out.println("Apres");

			GroupeForme j = new GroupeForme("mimi");
			j.add(readRectangle);
			groupe.create(j);
			j = groupe.find("mimi");
			j.print();
			System.out.println("#########################");
			m.close();

		}
	}
}
