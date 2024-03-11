package fr.ecole3il.rodez2023.Model;

import java.util.List;

public interface GestionMotsInterface {

    /**
     * Charge les mots depuis un fichier
     * @param cheminFichier le chemin du fichier
     * @return la liste des mots
     */
    public void chargerMots(String cheminFichier);

    /**
     * Renvoie un mot aléatoire
     * @return le mot
     */
    public Mot choisirMotAleatoire();

}
