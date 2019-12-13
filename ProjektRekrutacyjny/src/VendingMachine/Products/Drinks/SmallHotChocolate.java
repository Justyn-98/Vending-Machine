package VendingMachine.Products.Drinks;

import VendingMachine.Products.Components.Fluid.Milk;
import VendingMachine.Products.Components.Others.SmallCup;
import VendingMachine.Products.Components.Powdery.Cocoa;
import VendingMachine.Products.ProductList;

public class SmallHotChocolate extends Drink {

    private String name = ProductList.SMALL_HOT_CHOCOLATE.getName();
    private double price = ProductList.SMALL_HOT_CHOCOLATE.getPrice();

    public SmallHotChocolate(SmallCup cup, Cocoa cocoa, Milk milk) {
        this.cup = cup;
        this.fluidComponents.add(milk);
        this.powderyComponents.add(cocoa);
    }
}
