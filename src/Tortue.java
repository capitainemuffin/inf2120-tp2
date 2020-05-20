import java.awt.geom.Path2D;
import java.util.EmptyStackException;
import java.util.Stack;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Représente l'intepréteur Tortue. Les mots analysés dans le fichier représenterons les mouvements d'une tortue.
 * La tortue peut avancer, reculer, tourner en sens horaire et antihoraire, et se téléporter à une ancienne position.
 * Son état interne comprend la position (x,y, angle) de la tortue, une pile d'instances tortues et le chemin
 * parcouru par la tortue.
 *
 * @author Sofiane Selaoui SELS28049204
 */
public class Tortue implements ContexteInterpretation {

    private double x;
    private double y;
    private double angle;
    private static Tortue tortue = new Tortue();
    private static Stack<Tortue> pile = new Stack<>();
    private Path2D.Double chemin = new Path2D.Double();

    /**
     * Constructeur vide
     */
    public Tortue() {

        this.chemin.moveTo(0, 0);

    }

    /**
     * Construit une nouvelle tortue avec celle passée en argument
     *
     * @param tortue une instance de la classe Tortue
     */
    public Tortue(Tortue tortue) {

        this.x = tortue.x;
        this.y = tortue.y;
        this.angle = tortue.angle;
        this.chemin = tortue.chemin;

    }

    /**
     * Avance la tortue
     *
     * @param motA l'instance de la classe MotA
     */
    public void a(MotA motA) {

        if (motA.getValeur() == 0) {

            tortue.x = tortue.x + cos(tortue.angle);
            tortue.y = tortue.y + sin(tortue.angle);
            chemin.lineTo(tortue.x, tortue.y);

        } else {

            tortue.x = tortue.x + motA.getValeur() * cos(tortue.angle);
            tortue.y = tortue.y + motA.getValeur() * sin(tortue.angle);
            chemin.lineTo(tortue.x, tortue.y);

        }

    }

    /**
     * Recule la tortue
     *
     * @param motB l'instance de la classe MotB
     */
    public void b(MotB motB) {

        if (motB.getValeur() == 0) {

            tortue.x = tortue.x - cos(tortue.angle);
            tortue.y = tortue.y - sin(tortue.angle);
            chemin.lineTo(tortue.x, tortue.y);

        } else {

            tortue.x = tortue.x - motB.getValeur() * cos(tortue.angle);
            tortue.y = tortue.y - motB.getValeur() * sin(tortue.angle);
            chemin.lineTo(tortue.x, tortue.y);

        }

    }

    /**
     * Tourne la tortue antihoraire
     *
     * @param motC l'instance de la classe MotC
     */
    public void c(MotC motC) {

        if (motC.getValeur() == 0) {

            tortue.angle = tortue.angle + (Math.PI / 2);

        } else {

            tortue.angle = tortue.angle + Math.toRadians(motC.getValeur());
        }

    }

    /**
     * Tourne la tortue horaire
     *
     * @param motD l'instance de la classe MotD
     */
    public void d(MotD motD) {

        if (motD.getValeur() == 0) {

            tortue.angle = tortue.angle - (Math.PI / 2);

        } else {

            tortue.angle = tortue.angle - Math.toRadians(motD.getValeur());

        }

    }

    /**
     * Mémorise la position de la tortue en la plaçant sur la pile. Construit une nouvelle tortue.
     *
     * @param motE l'instance de la classe MotE
     */
    public void e(MotE motE) {

        pile.push(tortue);
        tortue = new Tortue(tortue);

    }

    /**
     * Téléporte la tortue à l'ancienne position en dépilant une tortue de la pile.
     *
     * @param motF l'instance de la classe MotF
     * @throws PileVideException si la pile est vide
     */
    public void f(MotF motF) {

        try {

            tortue = pile.pop();
            chemin.moveTo(tortue.x, tortue.y);

        } catch (EmptyStackException e) {

            throw new PileVideException(motF.getColonne(), motF.getLigne());

        }

    }

    /**
     * Téléporte la tortue à l'origine
     *
     * @param motG l'instance de la classe MotG
     */
    public void g(MotG motG) {

        tortue = new Tortue();
        chemin.moveTo(tortue.x, tortue.y);


    }

    /**
     * @return une phrase détaillant la position de la tortue.
     */
    @Override
    public String toString() {

        return "Tortue :\nPosition X : " + tortue.x + "\nPosition Y : " + tortue.y +
                "\nDirection : " + tortue.angle + "\nPile : " + pile;

    }

    public void afficherChemin() {

        Fenetre.afficherChemin(this.chemin);
    }


}