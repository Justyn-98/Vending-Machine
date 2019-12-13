package VendingMachine.Products.Components.Powdery;

public class Sugar extends PowderyComponent {
    public Sugar(double weightInGrams) {
        super(weightInGrams);
    }

    @Override
    public PowderyComponent takeSomeComponent(double takenWeight) {
        this.weightInGrams -= takenWeight;
        return new Sugar(takenWeight);
    }

}
