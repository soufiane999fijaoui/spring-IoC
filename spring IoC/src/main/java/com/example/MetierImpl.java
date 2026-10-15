package com.example;

/**
 * MetierImpl - implémentation concrète de IMetier.
 * Elle dépend de l'interface IDao (et non d'une classe concrète),
 * ce qui assure un faible couplage (principe d'inversion de dépendance).
 */
public class MetierImpl implements IMetier {

    private IDao dao;

    public MetierImpl() {
    }

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double data = dao.getData();
        return data * 2 + 10;
    }
}
