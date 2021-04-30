package VendingMachine.ProductManagers.ProductCreator;

import VendingMachine.Products.Drinks.*;
import VendingMachine.Products.ProductList;

class ProductCreator {


    Drink createProduct(ProductList productName, ComponentStorage componentStorage) throws ClassNotFoundException {
        if (productName.equals(ProductList.SMALL_COFFEE)) {
            return createSmallCoffee(componentStorage);
        } else if (productName.equals(ProductList.BIG_COFFEE)) {
            return createBigCoffee(componentStorage);
        } else if (productName.equals(ProductList.SMALL_MILK_COFFEE)) {
            return createSmallMilkCoffee(componentStorage);
        } else if (productName.equals(ProductList.BIG_MILK_COFFEE)) {
            return createBigMilkCoffee(componentStorage);
        } else if (productName.equals(ProductList.SMALL_HOT_CHOCOLATE)) {
            return createSmallHotChocolate(componentStorage);
        } else if (productName.equals(ProductList.BIG_HOT_CHOCOLATE)) {
            return createBigHotChocolate(componentStorage);
        } else {
            throw new ClassNotFoundException();
        }
    }

    private BigCoffee createBigCoffee(ComponentStorage componentStorage) {
        return new BigCoffee(componentStorage.getBigCup(),
                componentStorage.getSomeWater(ProductRecipe.BIG_COFFEE_WATER.getComponentQuantity()),
                componentStorage.getSomeCoffeeBeans((ProductRecipe.BIG_COFFEE_BEANS.getComponentQuantity())));

    }

    private SmallCoffee createSmallCoffee(ComponentStorage componentStorage) {
        return new SmallCoffee(componentStorage.getSmallCup(),
                componentStorage.getSomeWater(ProductRecipe.SMALL_COFFEE_WATER.getComponentQuantity()),
                componentStorage.getSomeCoffeeBeans((ProductRecipe.SMALL_COFFEE_BEANS.getComponentQuantity())));
    }

    private BigMilkCoffee createBigMilkCoffee(ComponentStorage componentStorage) {
        return new BigMilkCoffee(componentStorage.getBigCup(),
                componentStorage.getSomeWater(ProductRecipe.BIG_MILK_COFFEE_WATER.getComponentQuantity()),
                componentStorage.getSomeCoffeeBeans((ProductRecipe.BIG_COFFEE_BEANS.getComponentQuantity())),
                componentStorage.getSomeMilk(ProductRecipe.BIG_COFFEE_MILK.getComponentQuantity()));
    }

    private SmallMilkCoffee createSmallMilkCoffee(ComponentStorage componentStorage) {
        return new SmallMilkCoffee(componentStorage.getSmallCup(),
                componentStorage.getSomeWater(ProductRecipe.SMALL_MILK_COFFEE_WATER.getComponentQuantity()),
                componentStorage.getSomeCoffeeBeans(ProductRecipe.SMALL_COFFEE_BEANS.getComponentQuantity()),
                componentStorage.getSomeMilk(ProductRecipe.SMALL_COFFEE_MILK.getComponentQuantity()));
    }

    private BigHotChocolate createBigHotChocolate(ComponentStorage componentStorage) {
        return new BigHotChocolate(componentStorage.getBigCup(),
                componentStorage.getSomeCocoa(ProductRecipe.BIG_HOT_CHOCOLATE_COCOA.getComponentQuantity()),
                componentStorage.getSomeMilk(ProductRecipe.BIG_HOT_CHOCOLATE_MILK.getComponentQuantity()));
    }

    private SmallHotChocolate createSmallHotChocolate(ComponentStorage componentStorage) {
        return new SmallHotChocolate(componentStorage.getSmallCup(),
                componentStorage.getSomeCocoa(ProductRecipe.SMALL_HOT_CHOCOLATE_COCOA.getComponentQuantity()),
                componentStorage.getSomeMilk(ProductRecipe.SMALL_HOT_CHOCOLATE_MILK.getComponentQuantity()));
    }


}
