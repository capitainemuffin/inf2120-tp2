import java.util.Scanner;

/**
 * <p>Ce logiciel interprète une phrase. Cette phrase est lue dans un fichier texte.
 * Elle est constituée d’une séquence de mots. Le logiciel valide la syntaxe de la phrase.
 * Ensuite, le logiciel demande à l’utilisateur de choisir l’interpréteur qui sera utilisé.
 * Finalement, le logiciel afficher l’état final de l’interpréteur.</p>
 *
 * <p> Phrase :: séquence de Mot. Une phrase est une suite de 0 ou plus Mot.
 * Chaque Mot de la phrase peut être entouré d’espace ‘ ‘, de tabulation ‘\t’ et de fin de ligne ‘\n’.
 * Mot :: un mot est une lettre minuscule. Les lettres de ‘a’ à ‘g’ sont utilisées.
 * Les mots de ‘a’ à ‘d’ peuvent être suivi, optionnellement, par une valeur entière entre parenthèses.
 * Il peut y avoir des espaces, tabulation et fin de ligne de chaque côté des parenthèses.</p>
 *
 * @author Sofiane Selaoui SELS28049204
 */
public class Principal {

    /**
     * Demande à l'utilisateur d'entrer le chemin d'accès de la phrase à analyser.
     *
     * @return un String représentant l'entrée de l'utilisateur.
     */
    private static String lireChaine() {

        Scanner sc = new Scanner(System.in);

        System.out.print(Messages.ENTRER_FICHIER);

        return sc.nextLine();

    }

    /**
     * Demande à l'utilisateur quel interpréteur utiliser ou s'il veut quitter.
     *
     * @return le choix entré par l'utilisateur
     */
    private static int menu() {

        Scanner sc = new Scanner(System.in);
        System.out.println(Messages.DELIMITEUR);
        System.out.println(Messages.CHOIX_MENU);

        int choix = Integer.parseInt(sc.nextLine());

        while (choix != 1 && choix != 2 && choix != 3 && choix != 4) {

            System.out.println(Messages.CHOIX_INVALIDE);
            choix = Integer.parseInt(sc.nextLine());

        }

        System.out.println(Messages.DELIMITEUR);
        return choix;

    }


    /**
     * Exécution
     */
    public static void main(String[] args) {

        int choix;
        String nomFichier = lireChaine();
        Phrase phrase = new Phrase(nomFichier);

        do {

            choix = menu();

            switch (choix) {

                case 1:
                    Calculatrice calculatrice = new Calculatrice();
                    phrase.interprete(calculatrice);
                    System.out.println(calculatrice);
                    break;
                case 2:
                    Profil profil = new Profil();
                    phrase.interprete(profil);
                    System.out.println(profil);
                    break;
                case 3:
                    Tortue tortue = new Tortue();
                    phrase.interprete(tortue);
                    System.out.println(tortue);
                    tortue.afficherChemin();
                    break;
                case 4:
                    System.out.println(Messages.TERMINER);
                    break;

            }

        } while (choix != 4);

    }

}
