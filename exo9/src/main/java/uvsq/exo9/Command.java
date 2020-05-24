package uvsq.exo9;

/**
 * interface Command .
 * 
 * @author Koussaila HAMMOUCHE.
 */
public interface Command {
	/**
	 * init .
	 * 
	 * @param S .
	 */
	void init(final String S);

	/**
	 * execute
	 */
	void execute();

	/**
	 * print
	 */
	void print();

}
