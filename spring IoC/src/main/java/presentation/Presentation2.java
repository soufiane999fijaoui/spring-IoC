package presentation;

import metier.IMetier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Point d'entrée basé sur les annotations Spring.
 *
 * @Configuration : cette classe participe à la configuration du conteneur.
 * @ComponentScan : Spring parcourt les packages "dao" et "metier" pour y trouver
 *                  les classes annotées @Component et créer les beans.
 */
@Configuration
@ComponentScan(basePackages = {"dao", "metier"})
public class Presentation2 {

    public static void main(String[] args) {

        // 1) On prépare le conteneur IoC (contexte Spring).
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 2) On active le profil "dev" : c'est DaoImpl2 (150.0) qui sera créé.
        context.getEnvironment().setActiveProfiles("dev");

        // 3) On enregistre cette classe de configuration (donc le @ComponentScan).
        context.register(Presentation2.class);

        // 4) On démarre réellement le conteneur : création + injection des beans.
        context.refresh();

        // 5) On demande le bean de type IMetier : Spring a déjà injecté son IDao.
        IMetier metier = context.getBean(IMetier.class);

        // 6) Exécution : 150.0 * 2 = 300.0 avec le profil dev.
        System.out.println("Résultat = " + metier.calcul());
    }
}
