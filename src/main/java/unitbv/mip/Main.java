package unitbv.mip;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Product chickenMeat = new Food("Carne de pui", 25.5, 350, Category.FELURI_PRINCIPALE, false);
        Product bolognesePasta = new Food("Paste Bolognese", 28.0, 300, Category.FELURI_PRINCIPALE, false);
        Product caesarSalad =  new Food("Salată Caesar", 30.0, 250, Category.APERITIVE, false);
        Product pizza = new Food("Pizza Margherita", 35.0, 400, Category.FELURI_PRINCIPALE, true);
        Product lavaCake = new Food("Lava Cake", 20.0, 150, Category.DESERTURI, true);
        Product water = new Drink("Apă", 9.0, 0.5, false);
        Product orangeJuice = new Drink("Suc de portocale", 12.0, 0.33, false);
        Product beer = new Drink("Bere", 10.0, 0.5, true);

        // Creare Pizza Custom cu Builder
        Product customPizza = new Pizza.PizzaBuilder("Pufos", "Dulce", 20.0)
                .withName("Pizza Casei")
                .addTopping("Mozzarella", 5.0, 50, false)
                .addTopping("Bacon", 6.0, 40, true)
                .addTopping("Ciuperci", 3.0, 30, false)
                .build();

        Menu restaurantMenu = new Menu();
        restaurantMenu.addProduct(chickenMeat);
        restaurantMenu.addProduct(bolognesePasta);
        restaurantMenu.addProduct(caesarSalad);
        restaurantMenu.addProduct(pizza);
        restaurantMenu.addProduct(lavaCake);
        restaurantMenu.addProduct(water);
        restaurantMenu.addProduct(orangeJuice);
        restaurantMenu.addProduct(beer);
        restaurantMenu.addProduct(customPizza);

        System.out.println("\n>>> 1. Meniul complet pe categorii:");
        restaurantMenu.printMenu();

        System.out.println("\n>>> 2. Produse Vegetariene (Sortate Alfabetic):");
        List<Product> vegProducts = restaurantMenu.getVegetarianFoodsSorted();
        vegProducts.forEach(System.out::println);

        System.out.println("\n>>> 3. Statistici:");
        System.out.println("Preț mediu deserturi: " + restaurantMenu.getAverageDessertPrice() + " RON");
        System.out.println("Avem produse scumpe (>100 RON)? " + (restaurantMenu.hasExpensiveProduct() ? "DA" : "NU"));

        System.out.println("\n>>> 4. Căutare Produs:");
        String searchFor = "Pizza Margherita";
        Optional<Product> result = restaurantMenu.searchProductInMenu(searchFor);

        result.ifPresentOrElse(
                p -> System.out.println("Găsit: " + p),
                () -> System.out.println("Produsul " + searchFor + " nu a fost găsit.")
        );

        Order myOrder = new Order();
        myOrder.addProduct(chickenMeat, 2);
        myOrder.addProduct(beer, 3);
        myOrder.addProduct(caesarSalad, 1);
        myOrder.addProduct(orangeJuice, 2);
        myOrder.addProduct(pizza, 2);
        myOrder.addProduct(customPizza, 1);

        System.out.println("\n--- Detalii comandă curentă ---");
        List<OrderItem> items = myOrder.getItems();
        for (OrderItem item : items) {
            System.out.println(item.toString() + " | Preț unitar: " + item.getProduct().getPrice() + " RON");
        }

        System.out.println("\n--- Total standard ---");
        System.out.println("Total de plată (TVA 9% inclus): " + String.format("%.2f", myOrder.calculateTotal()) + " RON");

        System.out.println("\n--- Happy Hour (-20% la alcool) ---");
        myOrder.setStrategy(DiscountStrategies::applyHappyHourStrategy);
        System.out.println("Total de plată Happy Hour: " + String.format("%.2f", myOrder.calculateTotal()) + " RON");

        System.out.println("\n--- Valentine's Day (10% reducere la tot) ---");
        myOrder.setStrategy(DiscountStrategies::ValentinesDayStrategy);
        System.out.println("Total de plată Valentine's Day: " + String.format("%.2f", myOrder.calculateTotal()) + " RON");

        System.out.println("\n ------------------------------------------ ");
    }
}