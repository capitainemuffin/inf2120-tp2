/**
 * Les messages pouvant êtres affichés pendant l'exécution.
 *
 * @author Sofiane Selaoui SELS28049204
 */
public enum Messages {

    ENTRER_FICHIER("Svp entrez le chemin du fichier text à lire : "),
    FICHIER_INTROUVABLE("Le fichier indiqué est introuvable."),
    TERMINER("Fin du logiciel. "),
    CHOIX_MENU("1- Calculatrice\n2- Profil\n3- Tortue\n4- Fin du logiciel\nEntrez votre choix :"),
    CHOIX_INVALIDE("Le choix est invalide."),
    DELIMITEUR("\n- - - - - - - - - - - - - - - - - -\n");

    String message;

    /**
     * Constructeur
     *
     * @param message instance de Messages
     */
    Messages(String message) {
        this.message = message;

    }

    /**
     * @return String le message de l'instance en cours
     */
    public String toString() {
        return "" + this.message;

    }
}
