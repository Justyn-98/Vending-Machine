package VendingMachine.Products.Drinks;

import VendingMachine.Products.Components.Fluid.Milk;
import VendingMachine.Products.Components.Others.BigCup;
import VendingMachine.Products.Components.Powdery.Cocoa;
import VendingMachine.Products.ProductList;

public class BigHotChocolate extends Drink {

    private String name = ProductList.BIG_HOT_CHOCOLATE.getName();
    private double price = ProductList.BIG_HOT_CHOCOLATE.getPrice();

    public BigHotChocolate(BigCup cup, Cocoa cocoa, Milk milk) {
        this.cup = cup;
        this.fluidComponents.add(milk);
        this.powderyComponents.add(cocoa);
    }
}
