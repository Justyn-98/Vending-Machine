package VendingMachine.Products.Components.Powdery;

public class Cocoa extends PowderyComponent {
    public Cocoa(double weightInGrams) {
        super(weightInGrams);
    }

    @Override
    public PowderyComponent takeSomeComponent(double takenWeight) {
        this.weightInGrams -=takenWeight;
        return new Cocoa(takenWeight);
    }
}
