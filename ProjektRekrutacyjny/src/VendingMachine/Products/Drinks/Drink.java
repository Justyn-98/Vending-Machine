package VendingMachine.Products.Drinks;

import VendingMachine.Products.Components.Fluid.FluidComponent;
import VendingMachine.Products.Components.Others.Cup;
import VendingMachine.Products.Components.Powdery.PowderyComponent;
import VendingMachine.Products.Components.Powdery.Sugar;

import java.util.ArrayList;

public abstract class Drink {
    private String name;
    private double price;
    Cup cup;
    ArrayList<FluidComponent> fluidComponents = new ArrayList<>();
    ArrayList<PowderyComponent> powderyComponents = new ArrayList<>();

    public void addSugarPortion(Sugar sugar) {
        this.powderyComponents.add(sugar);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
