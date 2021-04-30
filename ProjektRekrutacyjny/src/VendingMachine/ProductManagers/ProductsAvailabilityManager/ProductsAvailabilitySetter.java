package VendingMachine.ProductManagers.ProductsAvailabilityManager;

import VendingMachine.Products.Components.Component;
import VendingMachine.Products.Components.Powdery.Sugar;
import VendingMachine.Products.Drinks.*;
import VendingMachine.Products.ProductList;

import java.util.ArrayList;

class ProductsAvailabilitySetter {

    void changeStatusAvailabilityOfProducts(ArrayList<Component> components) {
        for (Component checkingComponent : components) {
            if (SmallCoffee.getInstance().isComponentRequired(checkingComponent)) {
                ProductList.SMALL_COFFEE.setAvailable(false);
            }
            if (BigCoffee.getInstance().isComponentRequired(checkingComponent)) {
                ProductList.BIG_COFFEE.setAvailable(false);
            }
            if (SmallMilkCoffee.getInstance().isComponentRequired(checkingComponent)) {
                ProductList.SMALL_MILK_COFFEE.setAvailable(false);
            }
            if (BigMilkCoffee.getInstance().isComponentRequired(checkingComponent)) {
                ProductList.BIG_MILK_COFFEE.setAvailable(false);
            }
            if (SmallHotChocolate.getInstance().isComponentRequired(checkingComponent)) {
                ProductList.SMALL_HOT_CHOCOLATE.setAvailable(false);
            }
            if (BigHotChocolate.getInstance().isComponentRequired(checkingComponent)) {
                ProductList.BIG_HOT_CHOCOLATE.setAvailable(false);
            }
            if (checkingComponent instanceof Sugar) {
                ProductList.SUGAR.setAvailable(false);
            }
        }
    }

}
