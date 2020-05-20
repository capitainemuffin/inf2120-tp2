/**
 * Représente une erreur lorsqu'on essaie de dépiler sur une pile vide.
 * Affiche la ligne et la colonne du mot qui a causé l'erreur.
 *
 * @author Sofiane Selaoui SELS28049204
 */
public class PileVideException extends RuntimeException {

    /**
     * Appele le constructeur de <code>RuntimeException</code>
     *
     * @param colonne colonne du mot qui a causé l'erreur
     * @param ligne   ligne du mot qui a causé l'erreur
     */
    public PileVideException(int colonne, int ligne) {

        super("La pile est vide. Ligne : " + ligne + ". Colonne : " + colonne + ".");

    }
}
