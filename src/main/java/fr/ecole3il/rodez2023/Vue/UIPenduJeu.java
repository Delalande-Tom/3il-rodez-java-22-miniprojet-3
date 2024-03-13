package fr.ecole3il.rodez2023.Vue;

import fr.ecole3il.rodez2023.Controller.PenduController;
import fr.ecole3il.rodez2023.Model.Mot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIPenduJeu extends JFrame {
    private JLabel definitionLabel;
    private JTextField lettreField;
    private JButton proposerButton;
    private JButton rejouerButton;
    private JLabel lettresProposeesLabel;
    private JLabel penduLabel;
    private JLabel resultatLabel;
    private JLabel tentativesLabel;

    private JLabel tentatives;

    private JLabel penduImage;

    private PenduController controller;

    public UIPenduJeu(PenduController controller) {
        this.controller = controller;
        setTitle("Jeu du Pendu");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 1));

        definitionLabel = new JLabel("Définition du mot à deviner : ");
        JPanel panelTentative = new JPanel();
        penduImage = new JLabel(new ImageIcon(new ImageIcon("src/main/resources/img/Pendu"+controller.getTentatives()+".png").getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)));
        //Construction des tentatives
        tentativesLabel = new JLabel("Nombre de tentatives restantes :");
        tentatives = new JLabel(String.valueOf(controller.getTentatives()));
        panelTentative.add(tentativesLabel);
        panelTentative.add(tentatives);

        lettreField = new JTextField(1);
        lettresProposeesLabel = new JLabel("Lettres déjà proposées : ");
        penduLabel = new JLabel("Pendu : ");
        resultatLabel = new JLabel();
        proposerButton = new JButton("Proposer");
        rejouerButton = new JButton("Rejouer");

        add(definitionLabel);
        add(penduImage, BorderLayout.CENTER);
        add(lettreField);
        add(lettresProposeesLabel);
        add(penduLabel);
        add(panelTentative);
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
                tentatives.setText("10");

            }
        });

        setVisible(true);
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

    public void perdre(String motADeviner) {
        this.afficherMessage("Désolé, vous avez perdu. Le mot à deviner était : " + motADeviner);
        remove(proposerButton);
        add(rejouerButton);
    }

    public void decrementerTentatives() {
        int nbTentatives = Integer.parseInt(tentatives.getText());
        nbTentatives--;
        tentatives.setText(String.valueOf(nbTentatives));

    }

    public void mettreAJourImagePendu(int tentativesRestantes) {
        // Générez le chemin de l'image en fonction du nombre de tentatives restantes
        String cheminImage = "src/main/resources/img/Pendu"+tentatives+".png";
        // Chargez l'image correspondante et mettez à jour le JLabel
        penduLabel.setIcon(new ImageIcon(cheminImage));
    }
}
