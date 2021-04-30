package VendingMachine.ProductManagers.ProductCreator;

import VendingMachine.Products.Components.Fluid.Milk;
import VendingMachine.Products.Components.Fluid.Water;
import VendingMachine.Products.Components.Others.BigCup;
import VendingMachine.Products.Components.Others.SmallCup;
import VendingMachine.Products.Components.Powdery.Cocoa;
import VendingMachine.Products.Components.Powdery.CoffeeBeans;
import VendingMachine.Products.Components.Powdery.Sugar;

import java.util.ArrayList;

public class ComponentStorage {

    private CoffeeBeans coffeeBeansStorage = new CoffeeBeans(0);
    private Water waterStorage = new Water(0);
    private Milk milkStorage = new Milk(0);
    private Cocoa cocoaStorage = new Cocoa(0);
    private Sugar sugarStorage = new Sugar(0);
    private ArrayList<BigCup> bigCupsStorage = new ArrayList<>();
    private ArrayList<SmallCup> smallCupsStorage = new ArrayList<>();

    public CoffeeBeans getCoffeeBeansStorage() {
        return coffeeBeansStorage;
    }

    public Water getWaterStorage() {
        return waterStorage;
    }

    public Milk getMilkStorage() {
        return milkStorage;
    }

    public Cocoa getCocoaStorage() {
        return cocoaStorage;
    }

    public Sugar getSugarStorage() {
        return sugarStorage;
    }

    public ArrayList<BigCup> getBigCupsStorage() {
        return bigCupsStorage;
    }

    public ArrayList<SmallCup> getSmallCupsStorage() {
        return smallCupsStorage;
    }

    BigCup getBigCup() {
        return bigCupsStorage.get(0);
    }

    SmallCup getSmallCup() {
        return smallCupsStorage.get(0);
    }

    CoffeeBeans getSomeCoffeeBeans(double componentQuantity) {
        return (CoffeeBeans) coffeeBeansStorage.takeSomeComponent(componentQuantity);
    }

    Water getSomeWater(double componentQuantity) {
        return (Water) waterStorage.takeSomeComponent(componentQuantity);
    }

    Milk getSomeMilk(double componentQuantity) {
        return (Milk) milkStorage.takeSomeComponent(componentQuantity);
    }

    Cocoa getSomeCocoa(double componentQuantity) {
        return (Cocoa) cocoaStorage.takeSomeComponent(componentQuantity);
    }

    public Sugar getSomeSugar(double componentQuantity) {
        return (Sugar) sugarStorage.takeSomeComponent(componentQuantity);
    }
}
