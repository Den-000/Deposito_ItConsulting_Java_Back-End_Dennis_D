package d31M03Y2026.afternoon.hotelManager.model;

public class Room {
    private int number;
    private float price;

    public Room(int number, float price) {
        this.number = number;
        this.price = price;
    }

    // Getter & Setter
    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }

    // Metodo dettagli
    public void roomDetails() {
        System.out.println("Camera numero: " + number + ", prezzo: " + price);
    }

    // Overload
    public void roomDetails(boolean withPrice) {
        if (withPrice) {
            roomDetails();
        } else {
            System.out.println("Camera numero: " + number);
        }
    }
}