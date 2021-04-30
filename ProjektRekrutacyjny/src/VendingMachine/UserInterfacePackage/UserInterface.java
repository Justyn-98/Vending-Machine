package VendingMachine.UserInterfacePackage;

import VendingMachine.Products.ProductList;
import VendingMachine.UserInterfacePackage.Display.DisplayMessages;
import VendingMachine.UserInterfacePackage.Display.Display;
import VendingMachine.UserInterfacePackage.Keyboard.InvalidUserInputException;
import VendingMachine.UserInterfacePackage.Keyboard.KeyboardDecoder;
import VendingMachine.UserInterfacePackage.Keyboard.Keyboard;

public class UserInterface {

    private Keyboard keyboard = new Keyboard();
    private KeyboardDecoder keyboardDecoder = new KeyboardDecoder();

    public String menuSelectionProcedure(double accountBalance) throws InvalidUserInputException {
        Display.accountBalanceInfo(accountBalance);
        Display.info(DisplayMessages.MENU.getMessage());
        return keyboardDecoder.decodeMenuChoice(keyboard.enterString());
    }

    public ProductList productSelectionProcedure() throws InvalidUserInputException {
        Display.info(DisplayMessages.PRODUCT_LIST.getMessage());
        return keyboardDecoder.decodeProductListChoice(keyboard.enterString());
    }

    public boolean purchaseConfirmProcedure(){
        Display.info(DisplayMessages.PURCHASE_CONFIRM_REQUEST.getMessage());
        boolean purchaseConfirm = keyboardDecoder.decodePurchaseConfirmChoice(keyboard.enterString());
        if (purchaseConfirm){
            Display.info(DisplayMessages.CONFIRMED_PURCHASE.getMessage());
        }else {
            Display.info(DisplayMessages.NOT_CONFIRMED_PURCHASE.getMessage());
        }
        return purchaseConfirm;
    }

    public int sugarQuantityChoiceProcedure(){
        if (ProductList.SUGAR.isAvailable()) {
            Display.info(DisplayMessages.SUGAR_QUANTITY_REQUEST.getMessage());
            int sugarQuantity = keyboardDecoder.decodeSugarQuantity(keyboard.enterString());
            Display.info(DisplayMessages.SUGAR_QUANTITY_CONFIRM.getMessage() + sugarQuantity);
            return sugarQuantity;
        }else {
            Display.info(DisplayMessages.SUGAR_IS_NOT_AVAILABLE.getMessage());
            return 0;
        }
    }

}
