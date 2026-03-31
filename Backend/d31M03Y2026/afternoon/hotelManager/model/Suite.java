package d31M03Y2026.afternoon.hotelManager.model;

public class Suite extends Room {
    private String extraServices;

    public Suite(int number, float price, String extraServices) {
        super(number, price);
        this.extraServices = extraServices;
    }

    public String getExtraServices() { return extraServices; }
    public void setExtraServices(String extraServices) {
        this.extraServices = extraServices;
    }

    // Override
    @Override
    public void roomDetails() {
        System.out.println("Suite numero: " + getNumber() +
                ", prezzo: " + getPrice() +
                ", servizi extra: " + extraServices);
    }
}