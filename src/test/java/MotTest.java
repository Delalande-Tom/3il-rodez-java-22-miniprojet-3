import fr.ecole3il.rodez2023.Model.Mot;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MotTest {

    @Test
    public void testContientLettre() {
        Mot mot = new Mot("chat", "un animal");

        assertTrue(mot.contientLettre("c"));
        assertTrue(mot.contientLettre("h"));
        assertTrue(mot.contientLettre("a"));
        assertFalse(mot.contientLettre("x"));
    }

    @Test
    public void testEstEntierementTrouve() {
        Mot mot = new Mot("chat", "un animal");

        assertFalse(mot.estEntierementTrouve("")); // Aucune lettre proposée
        assertFalse(mot.estEntierementTrouve("c")); // Une seule lettre proposée
        assertFalse(mot.estEntierementTrouve("ch")); // Deux lettres proposées
        assertTrue(mot.estEntierementTrouve("chat")); // Toutes les lettres proposées
    }
}
