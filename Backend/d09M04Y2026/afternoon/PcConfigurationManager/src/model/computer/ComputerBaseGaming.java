package model.computer;

// Classe concreta: PC base da gaming
public class ComputerBaseGaming implements Computer {

    public String getDescription() {
        return "PC da Gaming";
    }

    public double getPrice() {
        return 1000.00;
    }
}