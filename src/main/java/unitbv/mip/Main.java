package unitbv.mip;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 1. Definirea produselor
        Product chickenMeat = new Food("Carne de pui", 25.5, 350);
        Product water = new Drink("Apă", 9.0, 0.5, false);
        Product caesarSalad =  new Food("Salată Caesar", 30.0, 250);
        Product orangeJuice = new Drink("Suc de portocale", 12.0, 0.33, false);
        Product bolognesePasta = new Food("Paste Bolognese", 28.0, 300);
        Product beer = new Drink("Bere", 10.0, 0.5, true);
        Product pizza = new Food("Pizza Margherita", 35.0, 400);

        Order myOrder = new Order();

        myOrder.addProduct(chickenMeat, 2);
        myOrder.addProduct(beer, 3);
        myOrder.addProduct(caesarSalad, 1);
        myOrder.addProduct(orangeJuice, 2);
        myOrder.addProduct(pizza,2);

        System.out.println(" --- Meniul Restaurantului \"La Andrei\" --- ");


        System.out.println("\n--- Detalii comandă ---");
        List<OrderItem> items = myOrder.getItems();
        for (OrderItem item : items) {
            System.out.println(item.toString() + " | Preț unitar: " + item.getProduct().getPrice() + " RON");
        }

        System.out.println("\n--- Total standard ---");
        double totalStandard = myOrder.calculateTotal();
        System.out.println("Total de plată (TVA 9% inclus): " + String.format("%.2f", totalStandard) + " RON");


        System.out.println("\n--- Happy Hour (-20% la alcool) ---");

        myOrder.setStrategy(DiscountStrategies::applyHappyHourStrategy);

        double totalHappyHour = myOrder.calculateTotal();
        System.out.println("Total de plată Happy Hour: " + String.format("%.2f", totalHappyHour) + " RON");


        System.out.println("\n--- Valentine's Day (10% reducere la tot) ---");
        myOrder.setStrategy(DiscountStrategies::ValentinesDayStrategy);

        double totalValentines = myOrder.calculateTotal();
        System.out.println("Total de plată Valentine's Day: " + String.format("%.2f", totalValentines) + " RON");

        System.out.println("\n ------------------------------------------ ");
    }
}