package dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Seconde implémentation de IDao (version "développement").
 *
 * On a deux implémentations de la MÊME interface : c'est exactement
 * ce qui permet à Spring de choisir laquelle injecter (via @Qualifier ou un profil).
 *
 * @Component("dao2") : bean nommé "dao2".
 * @Profile("dev")    : actif uniquement quand le profil "dev" est activé.
 */
@Component("dao2")
@Profile("dev")
public class DaoImpl2 implements IDao {

    @Override
    public double getValue() {
        // Message qui confirme l'utilisation de la version de développement.
        System.out.println("Version de développement");
        // Valeur différente (150.0) pour bien distinguer les deux implémentations.
        return 150.0;
    }
}
