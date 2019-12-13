package VendingMachine;

import VendingMachine.Products.ProductList;

import java.util.Scanner;

public class MachineKeyboard {

    private final int DEFAULT_MIN_NUMBER = 1;
    private final int MENU_CHOICE_MAX_NUMBER = 4;
    private final int PRODUCT_CHOICE_MAX_NUMBER = 6;
    private final int PURCHASE_CONFIRMED_MAX_NUMBER = 2;
    private final int MIN_SUGAR_PORTION = 0;
    private final int MAX_SUGAR_PORTION = 5;

    private Scanner scanner = new Scanner(System.in);
    private KeyboardDecoder keyboardDecoder = new KeyboardDecoder();
    private int pickedNumber;

    public int pickNumberToMenuChoice() {
        pickedNumber = scanner.nextInt();
        if (pickedNumber >= DEFAULT_MIN_NUMBER && pickedNumber <= MENU_CHOICE_MAX_NUMBER) {
            return pickedNumber;
        } else {
            return pickNumberToMenuChoice();
        }
    }

    public ProductList pickProduct() throws ClassNotFoundException {
        pickedNumber = scanner.nextInt();
        if (pickedNumber >= DEFAULT_MIN_NUMBER && pickedNumber <= PRODUCT_CHOICE_MAX_NUMBER) {
            return keyboardDecoder.searchProductByNumber(pickedNumber);
        } else {
            return pickProduct();
        }
    }

    public int pickNumberToConfirmPurchase() {
        pickedNumber = scanner.nextInt();
        if (pickedNumber >= DEFAULT_MIN_NUMBER && pickedNumber <= MAX_SUGAR_PORTION) {
            return pickedNumber;
        } else {
            return pickNumberToConfirmPurchase();
        }
    }

    public double pickNumberOfSugarPortion() {
        pickedNumber = scanner.nextInt();
        if (pickedNumber >= MIN_SUGAR_PORTION && pickedNumber <= PURCHASE_CONFIRMED_MAX_NUMBER) {
            return pickedNumber;
        } else {
            return pickNumberOfSugarPortion();
        }
    }

    public void closeScanner() {
        scanner.close();
    }

    public int getMENU_CHOICE_MAX_NUMBER() {
        return MENU_CHOICE_MAX_NUMBER;
    }

    public int getPickedNumber() {
        return pickedNumber;
    }

}
