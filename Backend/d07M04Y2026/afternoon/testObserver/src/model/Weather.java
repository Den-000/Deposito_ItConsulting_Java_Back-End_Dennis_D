package model;

import java.util.*;

public class Weather {

    // interfaccia Observer
    // definisce il metodo che tutti i display devono implementare
    public interface Display {
        void update(float temperature);
    }

    // classe Subject (osservato)
    public class WeatherStation {

        // lista degli observer registrati
        private List<Display> displays = new ArrayList<>();

        // stato interno (temperatura corrente)
        private float temperature;

        // metodo per registrare un observer
        public void addDisplay(Display d) {
            displays.add(d);
        }

        // metodo per rimuovere un observer
        public void removeDisplay(Display d) {
            displays.remove(d);
        }

        // notifica tutti gli observer registrati
        public void notifyDisplays() {
            for (Display d : displays) {
                // chiama update su ogni display passando la temperatura
                d.update(temperature);
            }
        }

        // metodo per aggiornare lo stato (temperatura)
        public void setTemperature(float t) {
            // aggiorna il valore interno
            this.temperature = t;

            // notifica automaticamente tutti gli observer
            notifyDisplays();
        }
    }
}