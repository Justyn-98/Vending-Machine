package VendingMachine.Products.Components.Powdery;

import VendingMachine.Products.Components.Component;

public abstract class PowderyComponent implements Component {

    double weightInGrams;

    PowderyComponent(double weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    PowderyComponent() {
    }


    public abstract PowderyComponent takeSomeComponent(double componentQuantity);

    public abstract void addSomeComponent(PowderyComponent componentQuantity);

    public double getQuantityOfComponent() {
        return weightInGrams;
    }

}
