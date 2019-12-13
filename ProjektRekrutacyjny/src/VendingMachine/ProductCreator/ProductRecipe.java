package VendingMachine.ProductCreator;

public enum ProductRecipe {
    SMALL_COFFEE_WATER(180.0),
    BIG_COFFEE_WATER(300.0),
    SMALL_MILK_COFFEE_WATER(140.0),
    BIG_MILK_COFFEE_WATER(240.0),


    SMALL_COFFEE_BEANS(4.5),
    BIG_COFFEE_BEANS(6.0),
    SMALL_HOT_CHOCOLATE_COCOA(4.0),
    BIG_HOT_CHOCOLATE_COCOA(5.5),


    SMALL_COFFEE_MILK(40.0),
    BIG_COFFEE_MILK(60.0),
    SMALL_HOT_CHOCOLATE_MILK(180.0),
    BIG_HOT_CHOCOLATE_MILK(300.0);

    double componentQuantity;

    ProductRecipe(double componentAmount) {
        this.componentQuantity = componentAmount;
    }
}
