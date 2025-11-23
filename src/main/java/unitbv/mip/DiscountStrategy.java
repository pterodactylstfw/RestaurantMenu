package unitbv.mip;

@FunctionalInterface
public interface DiscountStrategy {
    abstract double calculateDiscountedSubtotal(Order order);
}
