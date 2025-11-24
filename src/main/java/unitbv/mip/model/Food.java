package unitbv.mip.model;

public non-sealed class Food extends Product {
    private double weight;
    private boolean isVegetarian;

    public Food(String name, double price, double weight, Category category,
                boolean isVegetarian) {
        super(name, price, category);
        this.weight = weight;
        this.isVegetarian = isVegetarian;
    }

    public double getWeight() {
        return weight;
    }
    public boolean isVegetarian() { return isVegetarian; }

    @Override
    public String toString() {
        return super.toString() + " - Gramaj: " + weight + "g" + (isVegetarian ? " [VEG]" : "");
    }

}
