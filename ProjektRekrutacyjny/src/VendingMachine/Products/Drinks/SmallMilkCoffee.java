package VendingMachine.Products.Drinks;

import VendingMachine.Products.Components.Fluid.Milk;
import VendingMachine.Products.Components.Fluid.Water;
import VendingMachine.Products.Components.Others.SmallCup;
import VendingMachine.Products.Components.Powdery.CoffeeBeans;
import VendingMachine.Products.ProductList;

public class SmallMilkCoffee extends Drink {

    private String name = ProductList.SMALL_MILK_COFFEE.getName();
    private double price = ProductList.SMALL_MILK_COFFEE.getPrice();

    public SmallMilkCoffee(SmallCup cup, Water water, CoffeeBeans powderyLooseCoffee, Milk milk) {
        this.cup = cup;
        this.fluidComponents.add(water);
        this.fluidComponents.add(milk);
        this.powderyComponents.add(powderyLooseCoffee);
    }

    private SmallMilkCoffee() {

    }

    public static SmallMilkCoffee getInstance(){
        return new SmallMilkCoffee();
    }
}
