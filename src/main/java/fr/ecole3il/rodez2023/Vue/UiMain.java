package fr.ecole3il.rodez2023.Vue;

import fr.ecole3il.rodez2023.Controller.PenduController;
import fr.ecole3il.rodez2023.Model.FabriqueChargeurMot;
import fr.ecole3il.rodez2023.Model.GestionMotsInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UiMain extends JFrame{
    private JButton startButton;
    private JComboBox<String> difficultyComboBox;

    public UiMain() {
        setTitle("Pendu - Choix de difficulté");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        JLabel titleLabel = new JLabel("Choisissez la difficulté :");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);

        // ComboBox pour choisir la difficulté
        difficultyComboBox = new JComboBox<>();
        for (int i = 1; i <= 5; i++) {
            difficultyComboBox.addItem("Difficulté " + i);
        }
        add(difficultyComboBox);

        // Bouton pour lancer l'autre interface
        startButton = new JButton("Commencer le jeu");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedDifficulty = difficultyComboBox.getSelectedIndex() + 1;
                dispose(); // Fermer cette interface
                launchGame(selectedDifficulty); // Lancer l'autre interface avec la difficulté sélectionnée
            }
        });
        add(startButton);

        setVisible(true);
    }

    private void launchGame(int difficulty) {
        GestionMotsInterface gestionMots = FabriqueChargeurMot.getChargeurMot("mots.txt");
        PenduController controller = new PenduController(gestionMots);
        UIPenduJeu uiPenduJeu = new UIPenduJeu(difficulty);

        controller.setUI(uiPenduJeu);
        uiPenduJeu.setController(controller);

        // Initialiser la partie
        controller.initialiserPartie();
    }

}
