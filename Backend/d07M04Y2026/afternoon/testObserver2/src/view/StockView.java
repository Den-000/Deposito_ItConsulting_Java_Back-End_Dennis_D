package view;

import model.Stock.Investor;

public class StockView {

    // classe che rappresenta un investitore privato
    public class PrivateInvestor implements Investor {

        // metodo chiamato quando cambia il valore di un'azione
        @Override
        public void notify(String action, double value) {

            // output personalizzato per investitore privato
            System.out.println("[Privato] L'azione " + action + " ora vale: " + value);
        }
    }

    // classe che rappresenta un investitore bancario
    public class BankInvestor implements Investor {

        // metodo chiamato quando cambia il valore di un'azione
        @Override
        public void notify(String action, double value) {

            // output più formale per banca
            System.out.println("[Banca] Aggiornamento importante su " + action + ": " + value);
        }
    }
}