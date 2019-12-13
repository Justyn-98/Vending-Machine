package VendingMachine.Products.Drinks;

import VendingMachine.Products.Components.Fluid.Milk;
import VendingMachine.Products.Components.Fluid.Water;
import VendingMachine.Products.Components.Others.BigCup;
import VendingMachine.Products.Components.Powdery.CoffeeBeans;
import VendingMachine.Products.ProductList;

public class BigMilkCoffee extends Drink {

    private String name = ProductList.BIG_MILK_COFFEE.getName();
    private double price = ProductList.BIG_MILK_COFFEE.getPrice();

    public BigMilkCoffee(BigCup cup, Water water, CoffeeBeans powderyLooseCoffee, Milk milk) {
        this.cup = cup;
        this.fluidComponents.add(water);
        this.fluidComponents.add(milk);
        this.powderyComponents.add(powderyLooseCoffee);
    }
}
