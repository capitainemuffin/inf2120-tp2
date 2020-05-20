import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Représente une phrase contenant des mots. Une liste contenant 0 ou + instances de Mots.
 *
 * @author Sofiane Selaoui SELS28049204
 */
public class Phrase extends ArrayList<Mot> implements Expression {

    /**
     * Constructeur
     *
     * @param nomFichier le chemin d'accès spécifié par l'utilisateur contenant le fichier .txt à interpréter.
     * @throws IOException                si le fichier est introuvable
     * @throws SyntaxeIncorrecteException s'il y une erreur de syntaxe dans la phrase
     */
    public Phrase(String nomFichier) {

        int ligne = 1;
        int colonne = 0;
        String motTemporaire = "";

        try {

            BufferedReader fichier = new BufferedReader(new FileReader(nomFichier));

            int c;

            while ((c = fichier.read()) != -1) {

                char lettre = (char) c;

                if (lettre == '\n') {

                    ligne++;
                    colonne = 0;

                } else {

                    colonne++;

                }

                // filtrer les espaces et sauts de lignes avant de valider les mots
                if (lettre != '\n' && lettre != '\r' && lettre != ' ' && lettre != '\t') {

                    if (estLettreValide(lettre)) {

                        if (motTemporaire.isEmpty()) {

                            motTemporaire = "" + lettre;

                        } else {

                            if (estFinDeMotValide(motTemporaire)) {

                                ajouterMot(motTemporaire, colonne, ligne);
                                motTemporaire = "" + lettre;

                            } else {

                                throw new SyntaxeIncorrecteException(colonne, ligne);

                            }

                        }


                    } else if (lettre == '(') {

                        if (motTemporaire.isEmpty()) {

                            throw new SyntaxeIncorrecteException(colonne, ligne);

                        } else {

                            char debut = motTemporaire.charAt(0);

                            if (debut == 'a' || debut == 'b' || debut == 'c' || debut == 'd') {

                                motTemporaire += lettre;

                            } else {

                                throw new SyntaxeIncorrecteException(colonne, ligne);

                            }
                        }


                    } else if (lettre == ')') {

                        if (motTemporaire.isEmpty()) {

                            throw new SyntaxeIncorrecteException(colonne, ligne);

                        } else {

                            char debut = motTemporaire.charAt(0);
                            char valeur = motTemporaire.charAt(motTemporaire.length() - 1);

                            if ((debut == 'a' || debut == 'b' || debut == 'c' || debut == 'd') && Character.isDigit(valeur)) {

                                motTemporaire += lettre;
                                ajouterMot(motTemporaire, colonne, ligne);
                                motTemporaire = "";

                            } else {

                                throw new SyntaxeIncorrecteException(colonne, ligne);

                            }
                        }


                    } else if (Character.isDigit(lettre)) {

                        if (motTemporaire.isEmpty()) {

                            throw new SyntaxeIncorrecteException(colonne, ligne);

                        } else {

                            char valeur = motTemporaire.charAt(motTemporaire.length() - 1);

                            if (valeur == '(' || Character.isDigit(lettre)) {

                                motTemporaire += lettre;

                            } else {

                                throw new SyntaxeIncorrecteException(colonne, ligne);

                            }

                        }


                    } else {

                        throw new SyntaxeIncorrecteException(colonne, ligne);

                    }

                }

            }

            if (!motTemporaire.isEmpty()) {

                if (estFinDeMotValide(motTemporaire)) {

                    ajouterMot(motTemporaire, colonne, ligne);

                } else {

                    throw new SyntaxeIncorrecteException(colonne, ligne);

                }
            }

        } catch (IOException e) {

            System.err.println(Messages.FICHIER_INTROUVABLE);
            System.exit(-1);

        }

    }


    /**
     * Pour chaque mots de la phrase, applique son interprétation, selon le contexte passé en paramètre.
     *
     * @param contexte une instance d'un Interpréteur
     */
    @Override
    public void interprete(ContexteInterpretation contexte) {

        for (Mot mot : this) {

            mot.interprete(contexte);

        }

    }

    /**
     * Créer une instance selon le mot passé en paramètre et ajoute cette instance à la phrase.
     *
     * @param motTemporaire le mot tel que le dans le document
     * @param colonne       la colonne où ce mot a été lu
     * @param ligne         la ligne où ce mot a été lu
     */
    private void ajouterMot(String motTemporaire, int colonne, int ligne) {

        Mot mot = null;
        char lettre = motTemporaire.charAt(0);

        switch (lettre) {

            case 'a':
                mot = new MotA(colonne, ligne, motTemporaire);
                break;
            case 'b':
                mot = new MotB(colonne, ligne, motTemporaire);
                break;
            case 'c':
                mot = new MotC(colonne, ligne, motTemporaire);
                break;
            case 'd':
                mot = new MotD(colonne, ligne, motTemporaire);
                break;
            case 'e':
                mot = new MotE(colonne, ligne, motTemporaire);
                break;
            case 'f':
                mot = new MotF(colonne, ligne, motTemporaire);
                break;
            case 'g':
                mot = new MotG(colonne, ligne, motTemporaire);
                break;

        }

        this.add(mot);

    }

    /**
     * Test si la caractère passé en paramètre est valide
     *
     * @param lettre le caractère lu dans le document
     * @return vrai si le caractère représente l'une des 7 lettres acceptées, faux sinon
     */
    private static boolean estLettreValide(char lettre) {

        return (lettre == 'a' || lettre == 'b' || lettre == 'c' || lettre == 'd' || lettre == 'e' || lettre == 'f' || lettre == 'g');

    }

    /**
     * Test si la fin du mot passé en paramètre est valide
     *
     * @param motTemporaire le mot lu dans le document
     * @return vrai si le mot ne termine pas par "(" ni par un nombre, faux sinon
     */
    private static boolean estFinDeMotValide(String motTemporaire) {

        return (motTemporaire.charAt(motTemporaire.length() - 1) != '(' && !Character.isDigit(motTemporaire.charAt(motTemporaire.length() - 1)));

    }
}
