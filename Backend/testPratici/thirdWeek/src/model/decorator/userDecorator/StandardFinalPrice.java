package model.decorator.userDecorator;

public class StandardFinalPrice implements finalPriceCompenent {

    public float getFinalPrice(float price) {
        return price;
    }

}
