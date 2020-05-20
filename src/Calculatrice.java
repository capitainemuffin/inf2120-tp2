import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Représente un interpréteur Calculatrice, son état interne comporte un accumulateur et une pile d'entiers.
 * Comprends des méthodes qui vont modifier ces 2 objets en fonctions des mots interprétés.
 *
 * @author Sofiane Selaoui SELS28049204
 */
public class Calculatrice implements ContexteInterpretation {

    private Integer accumulateur = 0;
    private Stack<Integer> pile = new Stack<>();

    /**
     * Si le mot n'a pas de valeur : Lit 2 valeurs sur la pile, les additionnes et place le resultat sur la pile.
     * Si le mot a une valeur : Ajoute cette valeur à l'accumulateur.
     *
     * @param motA instance de la Classe MotA
     * @throws PileVideException si la pile est vide
     */
    @Override
    public void a(MotA motA) {


        if (motA.getValeur() == 0) {

            try {

                Integer valeur1 = this.pile.pop();
                Integer valeur2 = this.pile.pop();
                this.pile.push(valeur1 + valeur2);

            } catch (EmptyStackException e) {

                throw new PileVideException(motA.getColonne(), motA.getLigne());

            }


        } else {

            this.accumulateur = this.accumulateur + motA.getValeur();

        }

    }

    /**
     * Si le mot n'a pas de valeur : Lit 2 valeurs sur la pile, soustrait la première à la deuxième
     * et place la résultat sur la pile.
     * Si le mot à une valeur : Soustrait cette valeur de l'accumulateur.
     *
     * @param motB une instance de la Classe MotB
     * @throws PileVideException si la pile est vide
     */
    @Override
    public void b(MotB motB) {

        if (motB.getValeur() == 0) {

            try {

                Integer valeur1 = this.pile.pop();
                Integer valeur2 = this.pile.pop();
                this.pile.push(valeur2 - valeur1);

            } catch (EmptyStackException e) {

                throw new PileVideException(motB.getColonne(), motB.getLigne());

            }

        } else {

            this.accumulateur = this.accumulateur - motB.getValeur();

        }

    }

    /**
     * Si le mot n'a pas de valeur : Lit 2 valeurs sur la pile, multiplie ces valeurs et place le résultat sur la pile.
     * Si le mot à une valeur : l'accumulateur devient le produit de ce dernier et la valeur.
     *
     * @param motC une instance de la Classe MotC
     * @throws PileVideException si la pile est vide
     */
    @Override
    public void c(MotC motC) {


        if (motC.getValeur() == 0) {

            try {

                Integer valeur1 = this.pile.pop();
                Integer valeur2 = this.pile.pop();
                this.pile.push(valeur2 * valeur1);

            } catch (EmptyStackException e) {

                throw new PileVideException(motC.getColonne(), motC.getLigne());

            }

        } else {

            this.accumulateur = motC.getValeur() * this.accumulateur;

        }


    }

    /**
     * Si le mot n'a pas de valeur : lire 2 valeurs sur la pile, divise la première par la deuxième, et place le
     * résultat sur la pile.
     * Si le mot à une valeur : Divise l'accumulateur par la valeur et place le résultat dans l'accumulateur.
     *
     * @param motD une instance de la Classe MotD
     * @throws PileVideException        si la pile est vide
     * @throws DivisionParZeroException si on tente de diviser par zéro.
     */
    @Override
    public void d(MotD motD) {

        try {

            if (motD.getValeur() == 0) {

                Integer valeur1 = this.pile.pop();
                Integer valeur2 = this.pile.pop();
                this.pile.push(valeur1 / valeur2);

            } else {

                this.accumulateur = (this.accumulateur / motD.getValeur());

            }

        } catch (ArithmeticException e) {

            throw new DivisionParZeroException(motD.getColonne(), motD.getLigne());

        } catch (EmptyStackException e) {

            throw new PileVideException(motD.getColonne(), motD.getLigne());

        }


    }

    /**
     * Place le contenu de l'accumulateur sur la pile.
     *
     * @param motE une instance de la Classe MotE
     */
    @Override
    public void e(MotE motE) {

        this.pile.push(this.accumulateur);

    }

    /**
     * Lit une valeur sur la pile et la place dans l'accumulateur.
     *
     * @param motF une instance de la Classe MotF
     * @throws PileVideException si la pile est vide
     */
    @Override
    public void f(MotF motF) {

        try {

            this.accumulateur = this.pile.pop();

        } catch (EmptyStackException e) {

            throw new PileVideException(motF.getColonne(), motF.getLigne());

        }

    }

    /**
     * Place l'accumulateur à zéro.
     *
     * @param motG une instance de la Classe MotG
     */
    @Override
    public void g(MotG motG) {

        this.accumulateur = 0;

    }

    /**
     * @return une phrase détaillant l'état interne de l'interpéteur
     */
    @Override
    public String toString() {

        return "État final :\nAccumulateur : " + this.accumulateur + "\nPile : " + this.pile;

    }
}
