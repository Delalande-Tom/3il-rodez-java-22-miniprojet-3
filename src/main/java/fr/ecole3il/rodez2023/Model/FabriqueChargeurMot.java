package fr.ecole3il.rodez2023.Model;

public class FabriqueChargeurMot {

    /**
     * Renvoie un chargeur de mots
     * @return un chargeur de mots
     */
    public static GestionMotsInterface getChargeurMot() {
            return new GestionMotsFichier();
        }
}
