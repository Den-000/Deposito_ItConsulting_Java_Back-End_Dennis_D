package model;

public class ComputerFacade {

    private Bios bios;
    private HardDisk hardDisk;
    private SistemaOperativo sistemaOperativo;

    public ComputerFacade() {
        bios = new Bios();
        hardDisk = new HardDisk();
        sistemaOperativo = new SistemaOperativo();
    }

    public void accendiComputer() {
        bios.inizializza();
        hardDisk.carica();
        sistemaOperativo.avvia();
    }
}