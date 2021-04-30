package VendingMachine.Products.Components.Fluid;

public class Milk extends FluidComponent {

    public Milk(double volumeInMilliliters) {
        super(volumeInMilliliters);
    }

    private Milk() {
    }

    @Override
    public Milk takeSomeComponent(double componentQuantity) {
            this.volumeInMilliliters -= componentQuantity;
            return new Milk(componentQuantity);
    }

    @Override
    public void addSomeComponent(FluidComponent componentQuantity) {
        if (componentQuantity instanceof Milk)
            this.volumeInMilliliters = this.getQuantityOfComponent() + componentQuantity.getQuantityOfComponent();
    }

    public static Milk getInstance() {
        return new Milk();
    }

    @Override
    public String getComponentType() {
        return this.getClass().getTypeName();
    }
}
