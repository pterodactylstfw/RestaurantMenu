package unitbv.mip;

import java.util.Map;

public final class DiscountStrategies {
    public static double applyHappyHourStrategy(Order order) {
        System.out.println("Happy Hour activ!");
        double finalSubtotal = 0.0;

        for (OrderItem item : order.getItems()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();

            if ((product instanceof Drink) && ((Drink) product).isAlcoholic()) {
                finalSubtotal += product.getPrice() * quantity * 0.8; // -20%
            } else {
                finalSubtotal += item.getSubtotalNet(); // Preț întreg
            }
        }
        return finalSubtotal;
    }

    public static double ValentinesDayStrategy(Order order) {
        System.out.println("Este Valentine's Day, se aplică 10% reducere la întreaga comandă!");
        double subtotal = 0.0;
        for(OrderItem orderItem: order.getItems())
            subtotal += orderItem.getSubtotalNet();
        return subtotal * 0.9;
    }

    public static double applyFreeDrinkStrategy(Order order) {
        System.out.println("Se aplică oferta: Cumperi o pizza, primești o băutură gratis!");
        double subtotal = 0.0;
        double cheapestDrinkPrice = Double.MAX_VALUE;
        boolean hasPizza = false;

        for(OrderItem orderItem: order.getItems()) {
            Product product = orderItem.getProduct();
            int quantity = orderItem.getQuantity();
            subtotal += product.getPrice() * quantity;

            if(product.getName().toLowerCase().contains("pizza")) {
                hasPizza = true;
            }

            if(product instanceof Drink) {
                cheapestDrinkPrice = Math.min(cheapestDrinkPrice, product.getPrice());
            }
        }

        if(hasPizza && cheapestDrinkPrice != Double.MAX_VALUE) {
            System.out.println("Ofertă aplicată: Băutura gratuită are prețul " + cheapestDrinkPrice + " RON.");
            subtotal -= cheapestDrinkPrice;
        } else {
            System.out.println("Oferta 'băutură gratis' nu se aplică (nu există pizza în comandă sau nu există băuturi).");
        }

        return subtotal;
    }
}
