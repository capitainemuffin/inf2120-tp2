/**
 * Classe pour un mot F analysé dans le document
 *
 * @author Sofiane Selaoui SELS28049204
 */
public class MotF extends Mot {

    /**
     * Constructeur
     *
     * @param colonne la colonne du mot analysé dans le document
     * @param ligne   la ligne du mot analyés dans le document
     * @param element le mot tel que lu dans le document
     */
    public MotF(int colonne, int ligne, String element) {
        super(colonne, ligne, element);
    }

    /**
     * inteprete le mot avec le contexte passé en paramètre.
     *
     * @param contexte une instance d'un Interpréteur
     */
    @Override
    public void interprete(ContexteInterpretation contexte) {

        contexte.f(this);

    }

}
