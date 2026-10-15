package dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Première implémentation de IDao (version "production").
 *
 * @Component("dao") : Spring crée un bean nommé "dao" à partir de cette classe.
 * @Profile("prod")  : ce bean n'est instancié que si le profil "prod" est actif.
 *
 * Dans une application réelle, getValue() irait chercher la donnée en base de données.
 * Ici, on se contente d'une valeur fixe pour rester simple.
 */
@Component("dao")
@Profile("prod")
public class DaoImpl implements IDao {

    // Redéfinition de la méthode définie dans l'interface IDao.
    @Override
    public double getValue() {
        // Petit message pour identifier la version exécutée.
        System.out.println("Version de production");
        // Valeur fixe retournée : 100.0 (profil prod).
        return 100.0;
    }
}
