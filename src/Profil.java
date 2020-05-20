/**
 * Représente l'interpréteur Profil.
 * Son état interne contient le nombre d'opérations, le nombre d'accèes à la pile et le nombre
 * d'accès à l'accumulateur.
 *
 * @author Sofiane Selaoui SELS28049204
 */
public class Profil implements ContexteInterpretation {

    private int no = 0;
    private int np = 0;
    private int na = 0;

    /**
     * Appelle la methode <code>actionABCD(E mot)</code> afin d'interpréter le mot A ou A(v)
     *
     * @param motA instance de la classe MotA
     */
    @Override
    public void a(MotA motA) {

        actionABCD(motA);

    }

    /**
     * Appelle la methode <code>actionABCD(E mot)</code> afin d'interpréter le mot B ou B(v)
     *
     * @param motB instance de la classe MotB
     */
    @Override
    public void b(MotB motB) {

        actionABCD(motB);

    }

    /**
     * Appelle la methode <code>actionABCD(E mot)</code> afin d'interpréter le mot C ou C(v)
     *
     * @param motC instance de la classe MotC
     */
    @Override
    public void c(MotC motC) {

        actionABCD(motC);

    }

    /**
     * Appelle la methode <code>actionABCD(E mot)</code> afin d'interpréter le mot D ou D(v)
     *
     * @param motD instance de la classe MotD
     */
    @Override
    public void d(MotD motD) {

        actionABCD(motD);

    }

    /**
     * Ajoute 1 au nombre d'accès à la pile <code>np</code>
     * Ajoute 1 au nombre d'accès à l'accumulateur <code>na</code>
     *
     * @param motE instance de la classe MotE
     */
    @Override
    public void e(MotE motE) {

        np = np + 1;
        na = na + 1;

    }

    /**
     * Ajoute 1 au nombre d'accès à la pile <code>np</code>
     * Ajoute 1 au nombre d'accès à l'accumulateur <code>na</code>
     *
     * @param motF instance de la classe MotF
     */
    @Override
    public void f(MotF motF) {

        np = np + 1;
        na = na + 1;

    }

    /**
     * Ajoute 1 au nombre d'accès à l'accumulateur <code>na</code>
     *
     * @param motG instance de la classe MotG
     */
    @Override
    public void g(MotG motG) {

        na = na + 1;

    }


    /**
     * Si le mot n'a pas de valeur : ajoute 3 au nombre d'accès à la pile <code>np</code>
     * Si le mont à une valeur : ajoute 2 au nombre d'accès à l'accumulateur <code>na</code>
     * Ajoute 1 au nombre d'opérations <code>no</code>
     *
     * @param mot une instance de Mot A, B, C ou D
     * @param <E> un type Mot A, B, C ou D
     */
    private <E extends Mot> void actionABCD(E mot) {

        if (mot.getValeur() == 0) {

            np = np + 3;

        } else {

            na = na + 2;
        }

        no = no + 1;

    }

    /**
     * @return une phrase détaillant l'état interne de l'intépreteur
     */
    public String toString() {

        return "État final :\nNombre d'opération : " + no + "\nNombre d'accès à la pile : " + np + "\nNombre d'accès à l'accumulateur : " + na;

    }

}