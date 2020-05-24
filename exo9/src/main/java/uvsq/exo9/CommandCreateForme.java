package uvsq.exo9;

/**
 * interface CommandCreate .
 * 
 * @author Koussaila HAMMOUCHE.
 *
 * @param <T> un objet.
 */

public interface CommandCreateForme<T> extends Icommande {
	T execute();
}
