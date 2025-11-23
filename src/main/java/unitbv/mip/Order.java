package unitbv.mip;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items = new ArrayList<>();
    private static final double TAX_RATE = 0.09;
    private DiscountStrategy strategy;

    public Order() {
        this.strategy = order -> order.getSubtotalNet();
    }


    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) return;

        // Căutăm dacă produsul există deja în listă
        for (OrderItem item : items) {
            if (item.getProduct().equals(product)) { // Aici ne bazăm pe equals (sau comparăm nume/referință)
                item.addQuantity(quantity);
                return; // Am găsit, am actualizat, ieșim
            }
        }

        // Dacă nu există, adăugăm unul nou
        items.add(new OrderItem(product, quantity));
    }


    public List<OrderItem> getItems() {
        return items;
    }

    public double getSubtotalNet() {
        double subtotal = 0.0;
        for (OrderItem item : items) {
            subtotal += item.getSubtotalNet();
        }
        return subtotal;
    }

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateTotal() {
        // Calculează subtotalul folosind strategia curentă
        double discountedSubtotal = strategy.calculateDiscountedSubtotal(this);

        // Aplică TVA-ul peste subtotalul redus
        return discountedSubtotal * (1 + TAX_RATE);
    }

}
