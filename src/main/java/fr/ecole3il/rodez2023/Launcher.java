package fr.ecole3il.rodez2023;

import fr.ecole3il.rodez2023.Controller.PenduController;
import fr.ecole3il.rodez2023.Model.FabriqueChargeurMot;
import fr.ecole3il.rodez2023.Model.GestionMotsFichier;
import fr.ecole3il.rodez2023.Model.GestionMotsInterface;
import fr.ecole3il.rodez2023.Vue.UI;

class Launcher {
    public static void main(String[] args) {
        GestionMotsInterface gestionMots = FabriqueChargeurMot.getChargeurMot("mots.txt");
        PenduController controller = new PenduController(gestionMots);
        UI ui = new UI();

        controller.setUI(ui);
        ui.setController(controller);

        // Initialiser la partie
        controller.initialiserPartie();
    }
}
