package tailoringManager.service;

import java.util.ArrayList;

import tailoringManager.model.*;

// ===== LOGICA GESTIONALE =====
public class TailoringService {

    private ArrayList<MainGarment> garments = new ArrayList<>();
    private ArrayList<FinishingComponent> components = new ArrayList<>();

    // AGGIUNTA
    public void addGarment(MainGarment g) {
        garments.add(g);
    }

    public void addComponent(FinishingComponent c) {
        components.add(c);
    }

    // LETTURA
    public ArrayList<MainGarment> getGarments() {
        return garments;
    }

    public ArrayList<FinishingComponent> getComponents() {
        return components;
    }

    // RICERCA
    public MainGarment findGarmentByCode(String code) {
        for (MainGarment g : garments) {
            if (g.getCode().equals(code))
                return g;
        }
        return null;
    }

    public FinishingComponent findComponentByCode(String code) {
        for (FinishingComponent c : components) {
            if (c.getCode().equals(code))
                return c;
        }
        return null;
    }

    // RIMOZIONE
    public boolean removeGarmentByCode(String code) {
        MainGarment g = findGarmentByCode(code);
        if (g != null) {
            garments.remove(g);
            return true;
        }
        return false;
    }

    public boolean removeComponentByCode(String code) {
        FinishingComponent c = findComponentByCode(code);
        if (c != null) {
            components.remove(c);
            return true;
        }
        return false;
    }
}