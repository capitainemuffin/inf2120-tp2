import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Représente un mot, sera héritée par les autres classes Mots plus spécifiques.
 * Les classes qui héritent de Mot devront implémenter la méthode
 * <code>inteprete(ContexteIntepretation contexte)</code>.
 *
 * @author Sofiane Selaoui SELS28049204
 */
public abstract class Mot implements Expression {

    private int colonne;
    private int ligne;
    private int v;

    /**
     * Constructeur
     * Utilise un regex pour trouver la valeur.
     * Si le mot possède une valeur entre parenthèses, place cette valeur dans la variable v.
     * Si aucune valeur trouvée, la valeur vaut zéro.
     *
     * @param colonne la colonne du mot analysé dans le document
     * @param ligne   la ligne du mot analysé dans le document
     * @param mot     le mot tel qu'écrit dans le document
     */
    public Mot(int colonne, int ligne, String mot) {

        Pattern r = Pattern.compile("\\d+");
        Matcher match = r.matcher(mot);

        if (match.find()) {
            this.v = Integer.parseInt(match.group(0));
        }

        this.colonne = colonne;
        this.ligne = ligne;
    }

    /**
     * @return la valeur du mot dans le document. Si aucune valeur : la valeur vaut zéro.
     */
    public int getValeur() {

        return this.v;
    }

    /**
     * @return la colonne du mot dans le document
     */
    public int getColonne() {

        return this.colonne;
    }

    /**
     * @return la ligne du mot dans le document
     */
    public int getLigne() {

        return this.ligne;
    }


}
