package model.decorator.userDecorator;

public class ProFinalPriceDecorator extends finalPriceDecorator {

    public ProFinalPriceDecorator(finalPriceCompenent decoratedFinalPrice) {
        super(decoratedFinalPrice);
    }

    public float getFinalPrice(float price) {
        return decoratedFinalPrice.getFinalPrice(price) * 0.85f; // Sconto del 15% per utenti Pro
    }
    
}
