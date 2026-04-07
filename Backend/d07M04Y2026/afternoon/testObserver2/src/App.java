import model.Stock;
import model.Stock.StockAgency;

public class App {
    public static void main(String[] args) throws Exception {

        // creazione dell'oggetto principale del modello
        Stock stock = new Stock();

        // creazione dell'agenzia borsistica (Subject)
        StockAgency agency = stock.new StockAgency();

        // creazione della vista che contiene gli investitori (Observer)
        view.StockView stockView = new view.StockView();

        // registrazione degli investitori all'agenzia
        // ogni investitore riceverà notifiche sulle variazioni
        agency.addInvestor(stockView.new PrivateInvestor());
        agency.addInvestor(stockView.new BankInvestor());

        // output iniziale
        System.out.println("\n=== Sistema Borsa ===");

        // aggiornamento valore azione → notifica a tutti gli investitori
        agency.updateStockValue("ENI", 12.45);

        // secondo aggiornamento → nuova notifica
        agency.updateStockValue("FIAT", 9.87);
    }
}