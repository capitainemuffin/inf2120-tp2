/**
 * Représente une erreur lorsqu'on tente de diviser par zéro.
 * Hérite de ArithmeticException et l'enrichie en affichant la ligne et la colonne du mot qui a causé l'erreur.
 *
 * @author Sofiane Selaoui SELS28049204
 */
public class DivisionParZeroException extends ArithmeticException {

    /**
     * Appele le constructeur de <code>ArithmeticException</code>
     *
     * @param colonne colonne du mot qui a causé l'erreur
     * @param ligne   ligne du mot qui a causé l'erreur
     */
    public DivisionParZeroException(int colonne, int ligne) {

        super("On ne peut pas diviser par zéro. Ligne : " + ligne + ". Colonne : " + colonne + ".");

    }
}