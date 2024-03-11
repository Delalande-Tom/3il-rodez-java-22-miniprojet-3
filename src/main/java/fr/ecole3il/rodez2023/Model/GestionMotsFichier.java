package fr.ecole3il.rodez2023.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestionMotsFichier implements GestionMotsInterface{

    private List<Mot> mots;

    public GestionMotsFichier() {
        this.mots = new ArrayList<>();
    }

    /**
     * Charge les mots depuis un fichier
     * @param cheminFichier le chemin du fichier
     * @return
     */
    @Override
    public void chargerMots(String cheminFichier) {
        try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] elements = ligne.split(" ", 2); // séparer le mot et sa définition
                if (elements.length == 2) {
                    mots.add(new Mot(elements[0], elements[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Renvoie un mot aléatoire
     * @return le mot
     */
    @Override
    public Mot choisirMotAleatoire() {
        Random random = new Random();
        int index = random.nextInt(mots.size());
        return mots.get(index);
    }
}
