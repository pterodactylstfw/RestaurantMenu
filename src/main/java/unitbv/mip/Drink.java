package unitbv.mip;

public final class Drink extends Product {
    private double volume;
    private boolean isAlcoholic;

    public Drink(String name, double price, double volume, boolean isAlcoholic) {
        super(name, price);
        this.volume = volume;
        this.isAlcoholic = isAlcoholic;
    }


    public double getVolume() {
        return volume;
    }

    public boolean isAlcoholic() {
        return isAlcoholic;
    }


    @Override
    public String toString() {
        return super.toString() + " - Volum: " + volume + "l - " + (isAlcoholic ? "Contine alcool" : "Fara alcool");
    }
}
