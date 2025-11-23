package unitbv.mip;

public class Food extends Product {
    private double weight;

    public Food(String name, double price, double weight) {
        super(name, price);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return super.toString() + " - Gramaj: " + weight + "g";
    }

}
