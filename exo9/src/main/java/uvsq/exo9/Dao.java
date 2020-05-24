package uvsq.exo9;

/**
 * interface Dao.
 * 
 * @author koussaila HAMMOUCHE.
 *
 * @param <T> object.
 */

public interface Dao<T> {
	/**
	 * les operations .
	 *
	 * @param obj object.
	 * @return object .
	 */

	T create(final T obj);

	/**
	 * find .
	 *
	 * @param s .
	 * @return object .
	 */
	T find(final String s);

	/**
	 * update .
	 *
	 * @param obj object.
	 * @return object .
	 */
	T update(final T obj);

	/**
	 * delete supp.
	 *
	 * @param obj object. .
	 */
	void delete(final T obj);

}
