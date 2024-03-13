package fr.ecole3il.rodez2023.Vue;

import fr.ecole3il.rodez2023.Controller.PenduController;
import fr.ecole3il.rodez2023.Model.Mot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIPenduJeu extends JFrame {
    private JLabel definitionLabel;
    private JTextField propositionLettre;
    private JButton proposerButton;
    private JButton rejouerButton;
    private JLabel lettresProposeesLabel;
    private JLabel lettresProposees;
    private JPanel panelLettresProposees;
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
        penduImage = new JLabel();
        penduImage.setHorizontalAlignment(SwingConstants.CENTER);
        //Construction des tentatives
        JPanel panelTentative = new JPanel();
        tentativesLabel = new JLabel("Nombre de tentatives restantes :");
        tentatives = new JLabel(String.valueOf(controller.getTentatives()));
        panelTentative.add(tentativesLabel);
        panelTentative.add(tentatives);

        propositionLettre = new JTextField(1);
        propositionLettre.setDocument(new LimitJTextField(1));
        propositionLettre.setHorizontalAlignment(SwingConstants.CENTER);
        // Construction des lettres déja proposé
        panelLettresProposees = new JPanel();
        lettresProposeesLabel = new JLabel("Lettres déjà proposées : ");
        lettresProposees = new JLabel();
        panelLettresProposees.add(lettresProposeesLabel);
        panelLettresProposees.add(lettresProposees);

        penduLabel = new JLabel("Pendu : ");
        resultatLabel = new JLabel();
        proposerButton = new JButton("Proposer");
        rejouerButton = new JButton("Rejouer");

        add(definitionLabel);
        add(penduImage, BorderLayout.CENTER);
        add(propositionLettre);
        add(panelLettresProposees);
        add(penduLabel);
        add(panelTentative);
        add(resultatLabel);
        add(proposerButton);

        proposerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lettreProposee = propositionLettre.getText().trim();
                controller.proposerLettre(lettreProposee);
                propositionLettre.setText(""); // Effacer le champ après chaque proposition
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
        penduImage.setIcon(new ImageIcon(new ImageIcon("src/main/resources/img/Pendu"+controller.getTentatives()+".png").getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)));
        definitionLabel.setText("définition du Mot à deviner : " + motADeviner.getDefinition());
        // Initialiser le pendu
        String penduVide = "";
        for (int i = 0; i < motADeviner.getMot().length(); i++) {
            penduVide += "__ ";
        }
        penduLabel.setText("Pendu : " + penduVide);
        lettresProposees.setText("");
    }

    public void setLettresProposees(String lettres) {
        lettresProposees.setText(lettres);
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
        String cheminImage = "src/main/resources/img/Pendu"+tentativesRestantes+".png";
        // Chargez l'image correspondante et mettez à jour le JLabel
        penduImage.setIcon(new ImageIcon(new ImageIcon(cheminImage).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)));
    }
}
