package model;

public class CartaDiCredito implements IMetodoPagamento {

    private String nome;
    private String numeroCarta;

    public CartaDiCredito(String nome, String numeroCarta) {
        this.nome = nome;
        this.numeroCarta = numeroCarta;
    }

    @Override
    public void paga(double importo) {
        System.out.println("Pagamento di " + importo + "€ effettuato con Carta di Credito intestata a " + nome + " (Numero: " + numeroCarta + ")");
    }
}