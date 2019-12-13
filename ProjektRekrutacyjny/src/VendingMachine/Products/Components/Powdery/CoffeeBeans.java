package VendingMachine.Products.Components.Powdery;

public class CoffeeBeans extends PowderyComponent {
    public CoffeeBeans(double weightInGrams) {
        super(weightInGrams);
    }
    @Override
    public PowderyComponent takeSomeComponent(double takenWeight) {
        this.weightInGrams -=takenWeight;
        return new CoffeeBeans(takenWeight);
    }
}
