package model.computer;

// Classe concreta: PC base da ufficio
public class ComputerBaseOffice implements Computer {

    public String getDescription() {
        return "PC da Ufficio";
    }

    public double getPrice() {
        return 500.00;
    }
}