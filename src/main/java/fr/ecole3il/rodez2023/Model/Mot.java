package fr.ecole3il.rodez2023.Model;

public class Mot {

    private final String mot;

    private final String definition;

    public Mot(String mot, String definition) {
        this.mot = mot;
        this.definition = definition;
    }

    public String getMot() {
        return mot;
    }

    public String getDefinition() {
        return definition;
    }
}
