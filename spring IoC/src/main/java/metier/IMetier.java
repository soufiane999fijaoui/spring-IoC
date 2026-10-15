package metier;

/**
 * Interface de la couche métier.
 * Elle expose les traitements offerts par l'application, ici un simple calcul().
 * Le monde extérieur (présentation) ne connaît que cette interface,
 * jamais l'implémentation concrète : c'est le principe d'inversion de dépendance.
 */
public interface IMetier {

    /**
     * @return le résultat du calcul métier.
     */
    double calcul();
}
