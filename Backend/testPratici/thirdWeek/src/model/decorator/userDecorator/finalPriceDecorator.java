package model.decorator.userDecorator;

public abstract class finalPriceDecorator implements finalPriceCompenent {
    protected finalPriceCompenent decoratedFinalPrice;

    public finalPriceDecorator(finalPriceCompenent decoratedFinalPrice) {
        this.decoratedFinalPrice = decoratedFinalPrice;
    }
    
     public abstract float getFinalPrice(float price);
}
