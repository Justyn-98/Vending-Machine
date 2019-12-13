package VendingMachine.ProductCreator;

import VendingMachine.Products.Components.Fluid.Milk;
import VendingMachine.Products.Components.Fluid.Water;
import VendingMachine.Products.Components.Others.BigCup;
import VendingMachine.Products.Components.Others.SmallCup;
import VendingMachine.Products.Components.Powdery.Cocoa;
import VendingMachine.Products.Components.Powdery.CoffeeBeans;

import java.util.ArrayList;

public class ComponentStorage {
    private CoffeeBeans powderyLooseCoffeeStorage;
    private Water waterStorage;
    private Milk milkStorage;
    private Cocoa cocoaStorage;
    private ArrayList<BigCup> bigCups = new ArrayList<>();
    private ArrayList<SmallCup> smallCups = new ArrayList<>();

    public ComponentStorage() {
        this.powderyLooseCoffeeStorage = new CoffeeBeans(10000);
        this.waterStorage = new Water(10000);
        this.milkStorage = new Milk(10000);
        this.cocoaStorage = new Cocoa(10000);
    }

    public CoffeeBeans getSomeCoffeeBeans(double componentQuantity) throws ComponentSoldOut {
        if(powderyLooseCoffeeStorage.getWeightInGrams()<componentQuantity)
            throw new ComponentSoldOut();
        return (CoffeeBeans) powderyLooseCoffeeStorage.takeSomeComponent(componentQuantity);
    }


    public Water getSomeWater(double componentQuantity) throws ComponentSoldOut {
        if(waterStorage.getVolumeInMilliliters()<componentQuantity)
            throw new ComponentSoldOut();
        return (Water) waterStorage.takeSomeComponent(componentQuantity);
    }

    public Milk getSomeMilk(double componentQuantity) throws ComponentSoldOut {
        if(milkStorage.getVolumeInMilliliters()<componentQuantity)
            throw new ComponentSoldOut();
        return (Milk) milkStorage.takeSomeComponent(componentQuantity);
    }

    public Cocoa getSomeCocoa(double componentQuantity) throws ComponentSoldOut {
        if(cocoaStorage.getWeightInGrams() < componentQuantity)
            throw new ComponentSoldOut();
        return (Cocoa) cocoaStorage.takeSomeComponent(componentQuantity);
    }

    public BigCup getBigCup() throws ComponentSoldOut {
        if(bigCups.isEmpty())
            throw new ComponentSoldOut();
        return bigCups.get(0);
    }

    public SmallCup getSmallCup() throws ComponentSoldOut {
        if(bigCups.isEmpty())
            throw new ComponentSoldOut();
        return smallCups.get(0);
    }
}
