package controller;

import model.IMetodoPagamento;

public class PagamentoController {

    private IMetodoPagamento metodo;

    public void setMetodo(IMetodoPagamento metodo) {
        this.metodo = metodo;
    }

    public void eseguiPagamento(double importo) {
        if (metodo == null) {
            throw new IllegalStateException("Metodo di pagamento non selezionato!");
        }
        metodo.paga(importo);
    }
}