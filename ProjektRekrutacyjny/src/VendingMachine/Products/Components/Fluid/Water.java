package VendingMachine.Products.Components.Fluid;

public class Water extends FluidComponent {

    public Water(double volumeInMilliliters) {
        super(volumeInMilliliters);
    }

    private Water() {

    }

    @Override
    public Water takeSomeComponent(double componentQuantity) {
        this.volumeInMilliliters -= componentQuantity;
        return new Water(componentQuantity);
    }

    @Override
    public void addSomeComponent(FluidComponent componentQuantity) {
        if (componentQuantity instanceof Water)
            this.volumeInMilliliters = this.getQuantityOfComponent() + componentQuantity.getQuantityOfComponent();
    }

    public static Water getInstance() {
        return new Water();
    }

    @Override
    public String getComponentType() {
        return this.getClass().getTypeName();
    }
}
