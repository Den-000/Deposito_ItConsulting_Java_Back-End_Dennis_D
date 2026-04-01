package vehiclesManager.model;

public abstract class VeicoloConsegna {
    private String targa;
    private float caricoMassimo;

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public float getCaricoMassimo() {
        return caricoMassimo;
    }

    public void setCaricoMassimo(float caricoMassimo) {
        this.caricoMassimo = caricoMassimo;
    }

    public VeicoloConsegna(String targa, float caricoMassimo) {
        this.targa = targa;
        this.caricoMassimo = caricoMassimo;
    }

    // Metodo astratto
    public abstract void consegnaPacco(String destinazione, float peso);

    // Metodo concreto
    public void stampaInfo() {
        System.out.println("Targa: " + targa + ", Carico massimo: " + caricoMassimo + " kg");
    }
}