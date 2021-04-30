package VendingMachine.ProductManagers.ProductsAvailabilityManager;

import VendingMachine.ProductManagers.ProductCreator.ComponentStorage;
import VendingMachine.ProductManagers.ProductCreator.ProductRecipe;
import VendingMachine.Products.Components.Component;
import VendingMachine.Products.Components.Fluid.Milk;
import VendingMachine.Products.Components.Fluid.Water;
import VendingMachine.Products.Components.Others.BigCup;
import VendingMachine.Products.Components.Others.SmallCup;
import VendingMachine.Products.Components.Powdery.Cocoa;
import VendingMachine.Products.Components.Powdery.CoffeeBeans;
import VendingMachine.Products.Components.Powdery.Sugar;

import java.util.ArrayList;

class ComponentsAvailabilityChecker {

    private final double MIN_COFFEE_BEANS_QUANTITY = ProductRecipe.BIG_COFFEE_BEANS.getComponentQuantity();
    private final double MIN_WATER_QUANTITY = ProductRecipe.BIG_COFFEE_WATER.getComponentQuantity();
    private final double MIN_MILK_QUANTITY = ProductRecipe.BIG_HOT_CHOCOLATE_MILK.getComponentQuantity();
    private final double MIN_COCOA_QUANTITY = ProductRecipe.BIG_HOT_CHOCOLATE_COCOA.getComponentQuantity();
    private final double MIN_SUGAR_QUANTITY = ProductRecipe.SUGAR_PORTION.getComponentQuantity();

    private ArrayList<Component> missingComponents = new ArrayList<>();

    boolean checkIfNotMissingComponentInMachine(ComponentStorage componentStorage) {
        addMissingComponentsToTheList(componentStorage);
        ProductAvailabilityManager.setNeedToCheckStatusOfProductsAvailability(false);
        return missingComponents.size() > 0;
    }

    ArrayList<Component> getMissingComponents() {
        ArrayList<Component> listToReturn = (ArrayList<Component>) missingComponents.clone();
        missingComponents.clear();
        return listToReturn;
    }

    private void addMissingComponentsToTheList(ComponentStorage componentStorage) {
        if (componentStorage.getCoffeeBeansStorage().getQuantityOfComponent() < MIN_COFFEE_BEANS_QUANTITY) {
            missingComponents.add(CoffeeBeans.getInstance());
        }
        if (componentStorage.getWaterStorage().getQuantityOfComponent() < MIN_WATER_QUANTITY) {
            missingComponents.add(Water.getInstance());
        }
        if (componentStorage.getMilkStorage().getQuantityOfComponent() < MIN_MILK_QUANTITY) {
            missingComponents.add(Milk.getInstance());
        }
        if (componentStorage.getCocoaStorage().getQuantityOfComponent() < MIN_COCOA_QUANTITY) {
            missingComponents.add(Cocoa.getInstance());
        }
        if (componentStorage.getSugarStorage().getQuantityOfComponent() < MIN_SUGAR_QUANTITY) {
            missingComponents.add(Sugar.getInstance());
        }
        if (componentStorage.getBigCupsStorage().size() < 1) {
            missingComponents.add(BigCup.getInstance());
        }
        if (componentStorage.getSmallCupsStorage().size() < 1) {
            missingComponents.add(SmallCup.getInstance());
        }
    }
}
