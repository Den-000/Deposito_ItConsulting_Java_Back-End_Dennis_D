package model;

public class PayPal implements IMetodoPagamento {

    private String email;

    public PayPal(String email) {
        this.email = email;
    }

    @Override
    public void paga(double importo) {
        System.out.println("Pagamento di " + importo + "€ effettuato tramite PayPal (" + email + ")");
    }
}