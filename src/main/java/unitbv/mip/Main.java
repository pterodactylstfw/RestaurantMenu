package unitbv.mip;


import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> menu = List.of(
                new Food("Carne de pui", 25.5, 350),
                new Drink("Apă", 9.0, 0.5),
                new Food("Salată Caesar", 30.0, 250),
                new Drink("Suc de portocale", 12.0, 0.33)
        );

        System.out.println(" --- Meniul Restaurantului \"La Andrei\" --- ");

        for(Product product : menu) {
            System.out.println(product);
        }

        System.out.println(" ------------------------------------------ ");

    }
}
