package presentation;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Point d'entrée utilisant une configuration XML (alternative aux annotations).
 * Ici, les beans et l'injection sont décrits dans applicationContext.xml.
 */
public class PresentationXML {

    public static void main(String[] args) {

        // Chargement du conteneur Spring à partir du fichier XML du classpath.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Récupération du bean "metier" (déjà injecté avec son IDao via le XML).
        IMetier metier = (IMetier) context.getBean("metier");

        // Résultat attendu : la valeur du dao injecté dans le XML, multipliée par 2.
        System.out.println("Résultat (XML) = " + metier.calcul());
    }
}
