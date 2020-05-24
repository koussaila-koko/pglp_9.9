package uvsq.exo9;

/**
 * class Point.
 * 
 * @author koussaila HAMMOUCHE.
 *
 */

public class Point {
	/**
	 * int x position du point sur l'axe X.
	 */
	private int px;

	/**
	 * int y position du point sur l'axe Y.
	 */
	private int py;
	/**
	 * setX 
	 * @param x .
	 */
	public void setX(final int x) {
		this.px = x;
	}
	/**
	 * sety 
	 * @param y .
	 */
	public void setY(final int y) {
		this.py = y;
	}

	/**
	 * constructeur Point.
	 * 
	 * @param x  l'axe X.
	 * @param y  l'axe Y.
	 */
	public Point(final int x,final int y) {
		this.px = x;
		this.py = y;
	}

	/**
	 * methode getX.
	 * 
	 * @return la position du point sur l'axe X .
	 */
	public int getX() {
		return px;
	}

	/**
	 * methode getY.
	 * 
	 * @return la position du point sur l'axe Y.
	 */
	public int getY() {
		return py;
	}

	/**
	 * sommePoint pour deplacer .
	
	 */
	public void sommePoint(final double x, final double y) {
		this.px += x;
		this.py += y;
	}
	/**
	 * toString  .
	 *  */
	@Override
	public String toString() {
		return "(" + "x=" + px + ", y=" + py + ')';
	}

}
