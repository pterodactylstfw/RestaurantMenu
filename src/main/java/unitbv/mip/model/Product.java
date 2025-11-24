package unitbv.mip.model;

public sealed abstract class Product permits Food, Drink {
    private String name;
    private double price;
    private Category category;

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {return name;}
    public double getPrice() {
        return price;
    }
    public Category getCategory() {return category;}


    @Override
    public String toString() {
        return "> " + name + " (" + category + ") - " + price + " RON";
    }
}
