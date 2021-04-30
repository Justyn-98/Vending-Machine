package VendingMachine.Products.Drinks;

import VendingMachine.Products.Components.Fluid.Water;
import VendingMachine.Products.Components.Others.SmallCup;
import VendingMachine.Products.Components.Powdery.CoffeeBeans;
import VendingMachine.Products.ProductList;

public class SmallCoffee extends Drink {

    private String name = ProductList.SMALL_COFFEE.getName();
    private double price = ProductList.SMALL_COFFEE.getPrice();

    public SmallCoffee(SmallCup cup, Water water, CoffeeBeans powderyLooseCoffee) {
        this.cup = cup;
        this.fluidComponents.add(water);
        this.powderyComponents.add(powderyLooseCoffee);
    }

    private SmallCoffee(){

    }

    public static SmallCoffee getInstance(){
        return new SmallCoffee();
    }
}
