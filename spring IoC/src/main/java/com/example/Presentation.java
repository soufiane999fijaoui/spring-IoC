package com.example;

/**
 * Presentation - point d'entrée de l'application.
 * Elle crée les objets et réalise l'injection de dépendance MANUELLEMENT
 * (sans Spring) : on instancie DaoImpl puis on l'injecte dans MetierImpl.
 */
public class Presentation {

    public static void main(String[] args) {

        IDao dao = new DaoImpl();

        IMetier metier = new MetierImpl(dao);

        double resultat = metier.calcul();

        System.out.println("Résultat du calcul = " + resultat);
    }
}
