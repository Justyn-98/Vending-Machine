package VendingMachine.Products.Components.Fluid;

public class Milk extends FluidComponent {
    public Milk(double volumeInMilliliters) {
        super(volumeInMilliliters);
    }

    @Override
    public FluidComponent takeSomeComponent(double takenVolumeInMilliliters) {
        this.volumeInMilliliters -=takenVolumeInMilliliters;
        return new Milk(takenVolumeInMilliliters);
    }
}
