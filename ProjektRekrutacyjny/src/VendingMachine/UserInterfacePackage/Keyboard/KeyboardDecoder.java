package VendingMachine.UserInterfacePackage.Keyboard;

import VendingMachine.Products.ProductList;

public class KeyboardDecoder {
    public ProductList decodeProductListChoice(String enteredString) throws InvalidUserInputException {
        if (enteredString.equals("1")) {
            return ProductList.SMALL_COFFEE;
        } else if (enteredString.equals("2")) {
            return ProductList.BIG_COFFEE;
        } else if (enteredString.equals("3")) {
            return ProductList.SMALL_MILK_COFFEE;
        } else if (enteredString.equals("4")) {
            return ProductList.BIG_MILK_COFFEE;
        } else if (enteredString.equals("5")) {
            return ProductList.BIG_HOT_CHOCOLATE;
        } else if (enteredString.equals("6")) {
            return ProductList.SMALL_HOT_CHOCOLATE;
        } else {
            throw new InvalidUserInputException("Nie znaleziono produktu");
        }
    }

    public String decodeMenuChoice(String enteredString) throws InvalidUserInputException {
        if (enteredString.equals("1")) {
            return "insertCoin";
        } else if (enteredString.equals("2")) {
            return "drinkPurchase";
        } else if (enteredString.equals("3")) {
            return "takeMoneyFromMachine";
        } else if (enteredString.equals("4")) {
            return "goAwayFromMachine";
        } else {
            throw new InvalidUserInputException("Nie prawidłowy wybór");
        }
    }

    public boolean decodePurchaseConfirmChoice(String enteredString) {
        enteredString = enteredString.toUpperCase();
        enteredString = enteredString.trim();
        return enteredString.equals("TAK");
    }

    public int decodeSugarQuantity(String enteredString) {
        if(enteredString.length() < 5)
            return enteredString.length();
        else
            return 5;
    }
}
