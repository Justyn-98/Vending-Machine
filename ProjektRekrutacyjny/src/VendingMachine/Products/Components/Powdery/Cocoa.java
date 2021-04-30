package VendingMachine.Products.Components.Powdery;

public class Cocoa extends PowderyComponent {

    public Cocoa(double weightInGrams) {
        super(weightInGrams);
    }

    private Cocoa() {

    }

    @Override
    public Cocoa takeSomeComponent(double componentQuantity) {
        this.weightInGrams -= componentQuantity;
        return new Cocoa(componentQuantity);
    }

    @Override
    public void addSomeComponent(PowderyComponent componentQuantity) {
        if (componentQuantity instanceof Cocoa)
            this.weightInGrams = this.getQuantityOfComponent() + componentQuantity.getQuantityOfComponent();
    }

    public static Cocoa getInstance() {
        return new Cocoa();
    }

    @Override
    public String getComponentType() {
        return this.getClass().getTypeName();
    }
}
