import model.Weather;
import model.Weather.WeatherStation;
import view.WeatherView;

public class App {
    public static void main(String[] args) throws Exception {

        // creazione dell'oggetto principale che contiene modello ed interfaccia
        Weather weather = new Weather();

        // creazione della stazione meteo (Subject dell'Observer)
        WeatherStation station = weather.new WeatherStation();

        // creazione della vista che contiene i display (Observer)
        WeatherView weatherView = new WeatherView();

        // registrazione dei display alla stazione meteo
        // ogni display verrà notificato quando cambia la temperatura
        station.addDisplay(weatherView.new ConsoleDisplay());
        station.addDisplay(weatherView.new MobileDisplay());

        // output iniziale su console
        System.out.println("=== Sistema Meteo ===");

        // aggiornamento temperatura → scatena la notifica a tutti i display
        station.setTemperature(25.5f);

        // nuovo aggiornamento temperatura → nuova notifica
        station.setTemperature(30.0f);
    }
}