package VendingMachine.Products.Drinks;

import VendingMachine.Products.Components.Fluid.Water;
import VendingMachine.Products.Components.Others.BigCup;
import VendingMachine.Products.Components.Powdery.CoffeeBeans;
import VendingMachine.Products.ProductList;

public class BigCoffee extends Drink {

    private String name = ProductList.BIG_COFFEE.getName();
    private double price = ProductList.BIG_COFFEE.getPrice();

    public BigCoffee(BigCup cup, Water water, CoffeeBeans powderyLooseCoffee) {
        this.cup = cup;
        this.fluidComponents.add(water);
        this.powderyComponents.add(powderyLooseCoffee);
    }

}
