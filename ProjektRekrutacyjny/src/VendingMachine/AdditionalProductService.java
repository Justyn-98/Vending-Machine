package VendingMachine;

import VendingMachine.Products.Components.Powdery.Sugar;
import VendingMachine.Products.Drinks.Drink;

public class AdditionalProductService {

    private final double SUGAR_PORTION_IN_GRAMS = 4.5;

    public void setSugarQuantity(Drink drink,double sugarPortions) {
        for(int i = 0; i < sugarPortions;i++){
            drink.addSugarPortion(new Sugar(SUGAR_PORTION_IN_GRAMS));
        }
    }
}
