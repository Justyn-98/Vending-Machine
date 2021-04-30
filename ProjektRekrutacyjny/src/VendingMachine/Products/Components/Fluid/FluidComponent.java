package VendingMachine.Products.Components.Fluid;

import VendingMachine.Products.Components.Component;

public abstract class FluidComponent implements Component {

    double volumeInMilliliters;

    FluidComponent(double volumeInMilliliters) {
        this.volumeInMilliliters = volumeInMilliliters;
    }

    FluidComponent() {
    }

    public abstract FluidComponent takeSomeComponent(double componentQuantity);

    public abstract void addSomeComponent(FluidComponent componentQuantity);

    public double getQuantityOfComponent() {
        return volumeInMilliliters;
    }

}
