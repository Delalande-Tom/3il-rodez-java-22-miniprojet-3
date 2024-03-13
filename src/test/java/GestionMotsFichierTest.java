
import fr.ecole3il.rodez2023.Model.FabriqueChargeurMot;
import fr.ecole3il.rodez2023.Model.GestionMotsInterface;
import fr.ecole3il.rodez2023.Model.Mot;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GestionMotsFichierTest {

    @Test
    public void testChargerMots() {
        // Créer une instance de GestionMotsFichier en lui passant un chemin de fichier valide
        GestionMotsInterface gestionMots = FabriqueChargeurMot.getChargeurMot("src/main/java/fr/ecole3il/rodez2023/Model/mots.txt");

        // Appeler la méthode chargerMots() pour obtenir une liste de mots
        List<Mot> mots = gestionMots.chargerMots();

        // Vérifier si la liste de mots est correcte (vous pouvez ajuster les assertions en fonction de votre fichier)
        assertEquals(58, mots.size()); // Supposons que le fichier contienne 3 mots
    }

    @Test
    public void testChargerMot1(){
        // Créer une instance de GestionMotsFichier en lui passant un chemin de fichier valide
        GestionMotsInterface gestionMots = FabriqueChargeurMot.getChargeurMot("src/main/java/fr/ecole3il/rodez2023/Model/mots.txt");

        // Appeler la méthode chargerMots() pour obtenir une liste de mots
        List<Mot> mots = gestionMots.chargerMots();

        assertEquals("agenda", mots.get(0).getMot());
    }
}
