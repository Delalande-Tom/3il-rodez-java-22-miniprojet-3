package fr.ecole3il.rodez2023.Controller;

import fr.ecole3il.rodez2023.Model.GestionMotsInterface;
import fr.ecole3il.rodez2023.Model.Mot;
import fr.ecole3il.rodez2023.Vue.UI;

import java.util.List;
import java.util.Locale;
import java.util.Random;

public class PenduController {
    private GestionMotsInterface gestionMots;
    private UI ui;
    private Mot motADeviner;
    private String lettresProposees;

    public PenduController(GestionMotsInterface gestionMots) {
        this.gestionMots = gestionMots;
        this.lettresProposees = "";
    }

    /**
     * Setter pour l'interface utilisateur
     * @param ui l'interface utilisateur
     */
    public void setUI(UI ui) {
        this.ui = ui;
    }

    /**
     * Initialiser une partie de pendu
     */
    public void initialiserPartie() {
        List<Mot> mots = gestionMots.chargerMots();
        motADeviner = choisirMotAleatoire(mots);
        ui.initialiserMotADeviner(motADeviner);
    }

    public void recommencerPartie() {
        lettresProposees = "";
        initialiserPartie();
    }

    /**
     * Choisir un mot aléatoire parmi une liste de mots
     * @param mots la liste de mots
     * @return le mot choisi
     */
    private Mot choisirMotAleatoire(List<Mot> mots) {
        Random rand = new Random();
        return mots.get(rand.nextInt(mots.size()));
    }

    /**
     * Proposer une lettre
     * @param lettreProposee la lettre proposée
     */
    public void proposerLettre(String lettreProposee) {
        // Vérifier si la lettre a déjà été proposée
        if (lettresProposees.contains(lettreProposee)) {
            ui.afficherMessage("La lettre '" + lettreProposee + "' a déjà été proposée. Veuillez choisir une autre lettre.");
            return; // Sortir de la méthode si la lettre a déjà été proposée
        }

        lettresProposees += lettreProposee.toLowerCase(Locale.ROOT)+" ";
        ui.setLettresProposees(lettresProposees);
        ui.afficherMessage("");

        // Mettre à jour la représentation du pendu avec les lettres correctes
        String penduRempli = "";
        for (char lettre : motADeviner.getMot().toCharArray()) {
            if (lettresProposees.contains(String.valueOf(lettre))) {
                penduRempli += lettre + " ";
            } else {
                penduRempli += "__ ";
            }
        }
        ui.setPenduRempli(penduRempli);

        if (motADeviner.contientLettre(lettreProposee)) {
            if (motADeviner.estEntierementTrouve(lettresProposees)) {
                ui.gagner(motADeviner.getMot());
            }
        } else {
            //@TODO perdre le pendu
        }
    }

}
