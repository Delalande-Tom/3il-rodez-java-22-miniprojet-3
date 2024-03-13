package fr.ecole3il.rodez2023.Controller;

import fr.ecole3il.rodez2023.Model.GestionMotsInterface;
import fr.ecole3il.rodez2023.Model.Mot;
import fr.ecole3il.rodez2023.Vue.UIPenduJeu;

import java.util.List;
import java.util.Locale;
import java.util.Random;

public class PenduController {
    private GestionMotsInterface gestionMots;
    private UIPenduJeu uiPenduJeu;
    private Mot motADeviner;
    private String lettresProposees;

    private int tentatives;

    private int difficulty;

    public PenduController(GestionMotsInterface gestionMots, int difficulty) {
        this.difficulty = difficulty;
        this.gestionMots = gestionMots;
        this.lettresProposees = "";
        this.setTentatives(difficulty);
    }

    /**
     * Setter pour l'interface utilisateur
     * @param uiPenduJeu l'interface utilisateur
     */
    public void setUI(UIPenduJeu uiPenduJeu) {
        this.uiPenduJeu = uiPenduJeu;
    }

    /**
     * Initialiser une partie de pendu
     */
    public void initialiserPartie() {
        List<Mot> mots = gestionMots.chargerMots();
        motADeviner = choisirMotAleatoire(mots);
        uiPenduJeu.initialiserMotADeviner(motADeviner);
    }

    /**
     * Recommencer une partie
     */
    public void recommencerPartie() {
        setTentatives(this.difficulty);
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
            uiPenduJeu.afficherMessage("La lettre '" + lettreProposee + "' a déjà été proposée. Veuillez choisir une autre lettre.");
            return; // Sortir de la méthode si la lettre a déjà été proposée
        }

        lettresProposees += lettreProposee.toLowerCase(Locale.ROOT)+" ";
        uiPenduJeu.setLettresProposees(lettresProposees);
        uiPenduJeu.afficherMessage("");

        // Mettre à jour la représentation du pendu avec les lettres correctes
        String penduRempli = "";
        for (char lettre : motADeviner.getMot().toCharArray()) {
            if (lettresProposees.contains(String.valueOf(lettre))) {
                penduRempli += lettre + " ";
            } else {
                penduRempli += "__ ";
            }
        }
        uiPenduJeu.setPenduRempli(penduRempli);

        if (motADeviner.contientLettre(lettreProposee)) {
            if (motADeviner.estEntierementTrouve(lettresProposees)) {
                uiPenduJeu.gagner(motADeviner.getMot());
            }
        } else {
            tentatives--;
            uiPenduJeu.decrementerTentatives();
            uiPenduJeu.mettreAJourImagePendu(tentatives);
            if (tentatives == 0) uiPenduJeu.perdre(motADeviner.getMot());
        }
    }

    /**
     * Setter pour le nombre de tentatives
     * @param difficulty la difficulté
     */
    private void setTentatives(int difficulty) {
        this.tentatives = 10 - difficulty;
    }

    /**
     * Getter pour le nombre de tentatives
     * @return le nombre de tentatives
     */
    public int getTentatives() {
        return tentatives;
    }
}
