package unitbv.mip;

public class Drink extends Product {
    private double volume;

    public Drink(String name, double price, double volume) {
        super(name, price);
        this.volume = volume;
    }


    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return super.toString() + " - Volum: " + volume + "l";
    }
}
