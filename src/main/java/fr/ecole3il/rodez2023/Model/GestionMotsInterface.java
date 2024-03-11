package fr.ecole3il.rodez2023.Model;

import java.util.List;

public interface GestionMotsInterface {

    /**
     * Charge les mots depuis un fichier
     * @return la liste des mots
     */
    public List<Mot> chargerMots();

}
