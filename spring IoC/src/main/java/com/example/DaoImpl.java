package com.example;

/**
 * DaoImpl - implémentation concrète de IDao.
 * C'est ici que l'on irait chercher les données (BDD, web service, fichier...).
 * Pour l'exemple, on retourne une simple valeur numérique.
 */
public class DaoImpl implements IDao {

    @Override
    public double getData() {
        System.out.println("DaoImpl : récupération de la donnée...");
        return 25.0;
    }
}
