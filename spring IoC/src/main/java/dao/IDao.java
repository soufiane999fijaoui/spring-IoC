package dao;

/**
 * Interface de la couche d'accès aux données (DAO = Data Access Object).
 * Elle décrit CE QUE l'on peut faire (récupérer une valeur) sans préciser COMMENT.
 * Toute classe qui souhaite fournir des données doit implémenter getValue().
 * C'est cette abstraction qui garantit un faible couplage avec la couche métier.
 */
public interface IDao {

    /**
     * @return la valeur numérique exposée par la source de données.
     */
    double getValue();
}
