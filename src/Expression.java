/**
 * Interface à implémenter par les classes qui veulent intepréter des mots avec un contexte.
 * La méthode interprete est à implementer.
 *
 * @author Bruno Malenfant
 */
public interface Expression {

    /**
     * Appelle la méthode définie par le contexte reçu en argument.
     *
     * @param contexte une instance d'un Interpréteur
     */
    void interprete(ContexteInterpretation contexte);
}
