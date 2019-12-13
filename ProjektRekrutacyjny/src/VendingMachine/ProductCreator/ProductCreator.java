package VendingMachine.ProductCreator;

import VendingMachine.Products.Drinks.*;
import VendingMachine.Products.ProductList;

public class ProductCreator {

    private ComponentStorage componentStorage = new ComponentStorage();

    public Drink createProduct(ProductList productName) throws ComponentSoldOut, ClassNotFoundException {
        if (productName.equals(ProductList.SMALL_COFFEE)) {
            return createSmallCoffee();
        } else if (productName.equals(ProductList.BIG_COFFEE)) {
            return createBigCoffee();
        } else if (productName.equals(ProductList.SMALL_MILK_COFFEE)) {
            return createSmallMilkCoffee();
        } else if (productName.equals(ProductList.BIG_MILK_COFFEE)) {
            return createBigMilkCoffee();
        } else if (productName.equals(ProductList.SMALL_HOT_CHOCOLATE)) {
            return createSmallHotChocolate();
        } else if (productName.equals(ProductList.BIG_HOT_CHOCOLATE)) {
          return   createBigHotChocolate();
        } else {
            throw new ClassNotFoundException("Nie udało się wykonać produktu");
        }
        }



    private BigCoffee createBigCoffee() throws ComponentSoldOut {
        return new BigCoffee(componentStorage.getBigCup(),
                componentStorage.getSomeWater(ProductRecipe.BIG_COFFEE_WATER.componentQuantity),
                componentStorage.getSomeCoffeeBeans((ProductRecipe.BIG_COFFEE_BEANS.componentQuantity)));
    }

    private SmallCoffee createSmallCoffee() throws ComponentSoldOut {
        return new SmallCoffee(componentStorage.getSmallCup(),
                componentStorage.getSomeWater(ProductRecipe.SMALL_COFFEE_WATER.componentQuantity),
                componentStorage.getSomeCoffeeBeans((ProductRecipe.SMALL_COFFEE_BEANS.componentQuantity)));
    }

    private BigMilkCoffee createBigMilkCoffee() throws ComponentSoldOut {
        return new BigMilkCoffee(componentStorage.getBigCup(),
                componentStorage.getSomeWater(ProductRecipe.BIG_MILK_COFFEE_WATER.componentQuantity),
                componentStorage.getSomeCoffeeBeans((ProductRecipe.BIG_COFFEE_BEANS.componentQuantity)),
                componentStorage.getSomeMilk(ProductRecipe.BIG_COFFEE_MILK.componentQuantity));
    }

    private SmallMilkCoffee createSmallMilkCoffee() throws ComponentSoldOut {
        return new SmallMilkCoffee(componentStorage.getSmallCup(),
                componentStorage.getSomeWater(ProductRecipe.SMALL_COFFEE_WATER.componentQuantity),
                componentStorage.getSomeCoffeeBeans(ProductRecipe.SMALL_COFFEE_BEANS.componentQuantity),
                componentStorage.getSomeMilk(ProductRecipe.SMALL_COFFEE_MILK.componentQuantity));
    }

    private BigHotChocolate createBigHotChocolate() throws ComponentSoldOut {
        return new BigHotChocolate(componentStorage.getBigCup(),
                componentStorage.getSomeCocoa(ProductRecipe.BIG_HOT_CHOCOLATE_COCOA.componentQuantity),
                componentStorage.getSomeMilk(ProductRecipe.BIG_HOT_CHOCOLATE_MILK.componentQuantity));
    }

    private SmallHotChocolate createSmallHotChocolate() throws ComponentSoldOut {
        return new SmallHotChocolate(componentStorage.getSmallCup(),
                componentStorage.getSomeCocoa(ProductRecipe.SMALL_HOT_CHOCOLATE_COCOA.componentQuantity),
                componentStorage.getSomeMilk(ProductRecipe.SMALL_HOT_CHOCOLATE_MILK.componentQuantity));
    }
}
