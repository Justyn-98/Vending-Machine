package VendingMachine.ProductManagers.ProductCreator;

import VendingMachine.ProductManagers.ProductsAvailabilityManager.ProductAvailabilityManager;
import VendingMachine.Products.Components.Component;
import VendingMachine.Products.Components.Fluid.FluidComponent;
import VendingMachine.Products.Components.Fluid.Milk;
import VendingMachine.Products.Components.Fluid.Water;
import VendingMachine.Products.Components.Others.BigCup;
import VendingMachine.Products.Components.Others.SmallCup;
import VendingMachine.Products.Components.Powdery.Cocoa;
import VendingMachine.Products.Components.Powdery.CoffeeBeans;
import VendingMachine.Products.Components.Powdery.PowderyComponent;
import VendingMachine.Products.Components.Powdery.Sugar;

public class ComponentStorageAggregate {

   public static void addComponentToStorage(Component component, ComponentStorage componentStorage){
       if (CoffeeBeans.getInstance().getComponentType().equals(component.getComponentType())){
           componentStorage.getCoffeeBeansStorage().addSomeComponent((PowderyComponent) component);
       }else if (Cocoa.getInstance().getComponentType().equals(component.getComponentType())){
            componentStorage.getCocoaStorage().addSomeComponent((PowderyComponent) component);
        }else if (Sugar.getInstance().getComponentType().equals(component.getComponentType())){
            componentStorage.getSugarStorage().addSomeComponent((PowderyComponent) component);
        }else if (Water.getInstance().getComponentType().equals(component.getComponentType())){
            componentStorage.getWaterStorage().addSomeComponent((FluidComponent) component);
        }else if (Milk.getInstance().getComponentType().equals(component.getComponentType())){
            componentStorage.getMilkStorage().addSomeComponent((FluidComponent) component);
        }else if (SmallCup.getInstance().getComponentType().equals(component.getComponentType())){
            componentStorage.getSmallCupsStorage().add((SmallCup) component);
        }else if (BigCup.getInstance().getComponentType().equals(component.getComponentType())){
           componentStorage.getBigCupsStorage().add((BigCup) component);
        }
        ProductAvailabilityManager.setNeedToCheckStatusOfProductsAvailability(true);
    }
}
