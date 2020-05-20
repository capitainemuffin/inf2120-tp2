/**
 * Représente une erreur lorsque le mot lu à une syntaxe incorrecte.
 * Hérite de IllegalArgumentException et l'enrichie en affichant la ligne et la colonne du mot qui a causé l'erreur.
 *
 * @author Sofiane Selaoui SELS28049204
 */
public class SyntaxeIncorrecteException extends IllegalArgumentException {

    /**
     * Appelle le constructeur de <code>IllegalArgumentException</code>
     *
     * @param colonne colonne du mot qui a causé l'erreur
     * @param ligne   ligne du mot qui a causé l'erreur
     */
    public SyntaxeIncorrecteException(int colonne, int ligne) {

        super("La syntaxe est incorrecte. Ligne : " + ligne + ". Colonne : " + colonne + ".");

    }


}
