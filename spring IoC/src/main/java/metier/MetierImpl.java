package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Implémentation de IMetier.
 *
 * Point clé de l'injection de dépendances : cette classe ne fait PAS
 * "new DaoImpl()". Elle déclare seulement un besoin (un IDao) et laisse
 * Spring lui fournir l'objet -> couplage faible et code testable.
 *
 * @Component("metier") : Spring crée un bean nommé "metier".
 */
@Component("metier")
public class MetierImpl implements IMetier {

    // Dépendance déclarée sous forme d'INTERFACE (IDao), jamais d'implémentation.
    @Autowired
    // Comme il existe deux beans IDao (dao et dao2), on précise lequel injecter.
    @Qualifier("dao2")
    private IDao dao;

    /**
     * Calcul métier : on récupère la valeur via la dépendance injectée
     * puis on la multiplie par 2 (règle métier de l'exercice).
     */
    @Override
    public double calcul() {
        return dao.getValue() * 2;
    }

    /**
     * Setter d'injection.
     * Utilisé par la configuration XML (injection par setter) et par les tests
     * qui injectent manuellement un faux IDao, sans Spring.
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
