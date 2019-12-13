package VendingMachine.Products.Components.Fluid;

public class Water extends FluidComponent {

    public Water(double volumeInMilliliters) {
        super(volumeInMilliliters);
    }

    @Override
    public FluidComponent takeSomeComponent(double takenVolumeInMilliliters) {
        this.volumeInMilliliters -= takenVolumeInMilliliters;
        return new Water(takenVolumeInMilliliters);
    }
}
