package VendingMachine.Products.Components.Fluid;

public abstract class FluidComponent {

    double volumeInMilliliters ;

    FluidComponent(double volumeInMilliliters) {
        this.volumeInMilliliters = volumeInMilliliters;
    }

    public abstract FluidComponent takeSomeComponent(double takenVolumeInMilliliters);

    public double getVolumeInMilliliters() {
        return volumeInMilliliters;
    }
}
