package fr.ecole3il.rodez2023.Model;

import fr.ecole3il.rodez2023.Model.Mot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionMotsFichier implements GestionMotsInterface {
    private final String fichierMots;

    /**
     * Constructeur
     * @param fichierMots le fichier contenant les mots
     */
    public GestionMotsFichier(String fichierMots) {
        this.fichierMots = fichierMots;
    }

    /**
     * Charge les mots depuis un fichier
     * @return la liste des mots
     */
    @Override
    public List<Mot> chargerMots() {
        List<Mot> mots = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fichierMots))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ", 2);
                if (parts.length >= 2) {
                    String mot = parts[0];
                    String definition = parts[1];
                    mots.add(new Mot(mot, definition));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mots;
    }
}
