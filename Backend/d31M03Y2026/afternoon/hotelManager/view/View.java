package d31M03Y2026.afternoon.hotelManager.view;

public class View {

    public void showMenu(){
        System.out.println("\n=== GESTIONALE HOTEL ===");
        System.out.println("1. Crea hotel");
        System.out.println("2. Lista hotel");
        System.out.println("3. Aggiungi camera");
        System.out.println("4. Aggiungi suite");
        System.out.println("5. Mostra camere");
        System.out.println("0. Esci");
        System.out.println("========================");
    }
    
    public void println(String msg){
        System.out.println(msg);
    }
}