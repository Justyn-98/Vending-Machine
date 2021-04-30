package VendingMachine.ProductManagers.ProductCreator;


import VendingMachine.Products.Drinks.Drink;

class SugarManager {

    void setSugarQuantity(Drink drink, int sugarPortions, ComponentStorage componentStorage) {
        for (int i = 0; i < sugarPortions; i++) {
            drink.addSugarPortion(
                    componentStorage.getSomeSugar(ProductRecipe.SUGAR_PORTION.getComponentQuantity()));
        }
    }

}
