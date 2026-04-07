package model;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    // interfaccia Observer
    // definisce il comportamento degli investitori
    public interface Investor {
        void notify(String action, double value);
    }

    // classe Subject (osservato)
    public class StockAgency {

        // lista degli investitori registrati
        private List<Investor> investors = new ArrayList<>();

        // aggiunge un investitore alla lista
        public void addInvestor(Investor i) {
            investors.add(i);
        }

        // rimuove un investitore dalla lista
        public void removeInvestor(Investor i) {
            investors.remove(i);
        }

        // notifica tutti gli investitori registrati
        public void notifyInvestors(String action, double value) {
            for (Investor i : investors) {

                // invia aggiornamento a ciascun observer
                i.notify(action, value);
            }
        }

        // metodo chiamato quando cambia il valore di un'azione
        public void updateStockValue(String name, double value) {

            // inoltra l'aggiornamento a tutti gli investitori
            notifyInvestors(name, value);
        }
    }
}