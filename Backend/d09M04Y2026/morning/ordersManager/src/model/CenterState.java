package model;

// Enum per rappresentare lo stato operativo di un ordine
public enum CenterState {
    NORMAL,   // Esecuzione standard
    PRIORITY, // Esecuzione prioritaria
    CONTROL   // Esecuzione sotto controllo/controllata
}