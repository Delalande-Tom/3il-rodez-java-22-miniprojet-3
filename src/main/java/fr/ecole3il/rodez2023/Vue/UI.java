package fr.ecole3il.rodez2023.Vue;

import fr.ecole3il.rodez2023.Controller.PenduController;
import fr.ecole3il.rodez2023.Model.Mot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame {
    private JLabel definitionLabel;
    private JTextField lettreField;
    private JButton proposerButton;
    private JButton rejouerButton;
    private JLabel lettresProposeesLabel;
    private JLabel penduLabel;
    private JLabel resultatLabel;

    private PenduController controller;

    public UI() {
        setTitle("Jeu du Pendu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        definitionLabel = new JLabel("Définition du mot à deviner : ");
        lettreField = new JTextField(10);
        proposerButton = new JButton("Proposer");
        rejouerButton = new JButton("Rejouer");
        lettresProposeesLabel = new JLabel("Lettres déjà proposées : ");
        penduLabel = new JLabel("Pendu : ");
        resultatLabel = new JLabel();

        add(definitionLabel);
        add(lettreField);
        add(lettresProposeesLabel);
        add(penduLabel);
        add(resultatLabel);
        add(proposerButton);

        proposerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lettreProposee = lettreField.getText().trim();
                controller.proposerLettre(lettreProposee);
                lettreField.setText(""); // Effacer le champ après chaque proposition
            }
        });

        rejouerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.initialiserPartie();
                controller.recommencerPartie();
                remove(rejouerButton);
                add(proposerButton);
                resultatLabel.setText("");
                lettresProposeesLabel.setText("Lettres déjà proposées : ");

            }
        });

        setVisible(true);
    }

    public void setController(PenduController controller) {
        this.controller = controller;
    }

    public void initialiserMotADeviner(Mot motADeviner) {
        definitionLabel.setText("définition du Mot à deviner : " + motADeviner.getDefinition());
        // Initialiser le pendu
        String penduVide = "";
        for (int i = 0; i < motADeviner.getMot().length(); i++) {
            penduVide += "__ ";
        }
        penduLabel.setText("Pendu : " + penduVide);
    }

    public void setLettresProposees(String lettres) {
        lettresProposeesLabel.setText("Lettres déjà proposées : " + lettres);
    }

    public void setPenduRempli(String penduRempli) {
        penduLabel.setText("Pendu : " + penduRempli);
    }

    public void afficherMessage(String message) {
        resultatLabel.setText(message);
    }

    public void gagner(String motADeviner) {
        this.afficherMessage("Félicitations, vous avez trouvé le mot : " + motADeviner);
        remove(proposerButton);
        add(rejouerButton);

    }
}
