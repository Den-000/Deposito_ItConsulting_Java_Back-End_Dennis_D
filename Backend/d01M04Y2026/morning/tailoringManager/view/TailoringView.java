package tailoringManager.view;

import java.util.List;

import tailoringManager.model.*;

// ===== GESTIONE OUTPUT =====

public class TailoringView {

    public void showMainMenu() {
        System.out.println("\n=== GESTIONALE SARTORIA ===");
        System.out.println("1) Menu capi principali");
        System.out.println("2) Menu componenti di finitura");
        System.out.println("0) Esci");
        System.out.println("==========================");
        System.out.print("Scelta: ");
    }

    public void showGarmentsMenu() {
        System.out.println("\n=== GESTIONALE SARTORIA ===");
        System.out.println("1) Aggiungi capo");
        System.out.println("2) Visualizza capi");
        System.out.println("3) Cerca capo");
        System.out.println("4) Modifica capo");
        System.out.println("5) Rimuovi capo");
        System.out.println("0) Torna al menu principale");
        System.out.println("==========================");
        System.out.print("Scelta: ");
    }

    public void showGarmentsAvailableToDo() {
        System.out.println("\n=== GESTIONALE SARTORIA ===");
        System.out.println("1) Giacca");
        System.out.println("2) Gilet");
        System.out.println("3) Pantalone");
        System.out.println("0) Torna al menu dei capi");
        System.out.println("==========================");
        System.out.print("Scelta: ");
    }

    public void showComponentsMenu() {
        System.out.println("\n=== GESTIONALE SARTORIA ===");
        System.out.println("1) Aggiungi componente");
        System.out.println("2) Visualizza componenti");
        System.out.println("3) Cerca componente");
        System.out.println("4) Modifica componente");
        System.out.println("5) Rimuovi componente");
        System.out.println("0) Torna al menu principale");
        System.out.println("==========================");
        System.out.print("Scelta: ");
    }

    public void showComponentsAvailableToDo() {
        System.out.println("\n=== GESTIONALE SARTORIA ===");
        System.out.println("1) Cravatta");
        System.out.println("2) Papillon");
        System.out.println("3) Pochette");
        System.out.println("0) Torna al menu dei componenti");
        System.out.println("==========================");
        System.out.print("Scelta: ");
    }

    public void showGarments(List<MainGarment> garments) {
        System.out.println("\n=== CAPI PRINCIPALI ===");
        for (MainGarment g : garments) {
            System.out.println(g.showDetails());
        }
        System.out.println("=====================");
    }

    public void showComponents(List<FinishingComponent> components) {
        System.out.println("\n=== COMPONENTI FINITURA ===");
        for (FinishingComponent c : components) {
            System.out.println(c.showDetails());
        }
        System.out.println("==========================");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}