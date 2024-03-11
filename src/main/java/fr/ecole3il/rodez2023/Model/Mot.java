package fr.ecole3il.rodez2023.Model;

public class Mot {

    private final String mot;

    private final String definition;

    /**
     * Constructeur
     * @param mot le mot
     * @param definition la définition
     */
    public Mot(String mot, String definition) {
        this.mot = mot;
        this.definition = definition;
    }

    /**
     * Renvoie le mot
     * @return le mot
     */
    public String getMot() {
        return mot;
    }

    /**
     * Renvoie la définition
     * @return la définition
     */
    public String getDefinition() {
        return definition;
    }

    /**
     *  Renvoie true si le mot contient la lettre
     * @param lettre la lettre à chercher
     * @return true si le mot contient la lettre
     */
    public boolean contientLettre(String lettre) {
        return mot.contains(lettre);
    }

    /**
     * Renvoie true si le mot est entièrement trouvé
     * @param lettresProposees les lettres proposées
     * @return true si le mot est entièrement trouvé
     */
    public boolean estEntierementTrouve(String lettresProposees) {
        for (char lettre : mot.toCharArray()) {
            if (!lettresProposees.contains(String.valueOf(lettre))) {
                return false;
            }
        }
        return true;
    }
}
