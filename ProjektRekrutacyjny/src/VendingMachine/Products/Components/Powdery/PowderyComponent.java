package VendingMachine.Products.Components.Powdery;


public abstract class PowderyComponent {

    double weightInGrams;

    PowderyComponent(double weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    public abstract PowderyComponent takeSomeComponent(double takenWeight);

    public double getWeightInGrams() {
        return weightInGrams;
    }
}
