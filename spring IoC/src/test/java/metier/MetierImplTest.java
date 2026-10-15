package metier;

import dao.IDao;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test unitaire de MetierImpl.
 * Objectif : vérifier que calcul() traite correctement la valeur fournie par IDao,
 * SANS dépendre de Spring ni d'une vraie source de données.
 */
public class MetierImplTest {

    @Test
    public void testCalcul() {

        // On fabrique un faux IDao (classe anonyme) qui renvoie une valeur connue : 10.0.
        // C'est un "stub" : il rend le test isolé et prévisible.
        IDao dao = new IDao() {
            @Override
            public double getValue() {
                return 10.0;
            }
        };

        // On instancie le métier puis on injecte la dépendance MANUELLEMENT (setter).
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao);

        // Appel du calcul : 10.0 * 2 = 20.0 attendu.
        double result = metier.calcul();

        // Vérification avec une tolérance de 0.001 (comparaison de doubles).
        Assert.assertEquals(20.0, result, 0.001);
    }
}
