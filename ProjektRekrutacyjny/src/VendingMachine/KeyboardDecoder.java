package VendingMachine;

import VendingMachine.Products.ProductList;

public class KeyboardDecoder {
     public ProductList searchProductByNumber(int chosenProduct) throws ClassNotFoundException {
        if (chosenProduct == 1) {
            return ProductList.SMALL_COFFEE;
        } else if (chosenProduct == 2) {
            return ProductList.BIG_COFFEE;
        } else if (chosenProduct == 3) {
            return ProductList.SMALL_MILK_COFFEE;
        } else if (chosenProduct == 4) {
            return ProductList.BIG_MILK_COFFEE;
        } else if (chosenProduct == 5) {
            return ProductList.BIG_HOT_CHOCOLATE;
        } else if (chosenProduct == 6) {
            return ProductList.SMALL_HOT_CHOCOLATE;
        }
        else
            throw new ClassNotFoundException();

    }
}
