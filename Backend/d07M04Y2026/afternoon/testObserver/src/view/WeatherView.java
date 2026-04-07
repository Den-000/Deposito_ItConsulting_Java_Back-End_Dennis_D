package view;

import model.Weather.Display;

public class WeatherView {
    
    // classe interna che rappresenta un display su console
    public class ConsoleDisplay implements Display {

        // metodo chiamato quando la temperatura cambia
        @Override
        public void update(float temperature) {
            // output su console
            System.out.println("[Console] Temperatura aggiornata: " + temperature);
        }
    }

    // classe interna che rappresenta un display mobile
    public class MobileDisplay implements Display {

        // metodo chiamato quando la temperatura cambia
        @Override
        public void update(float temperature) {
            // output simulato per dispositivo mobile
            System.out.println("[Mobile] Temperatura aggiornata: " + temperature);
        }
    }
}