package VendingMachine.MoneyService;

import VendingMachine.UserInterfacePackage.Display.Display;

public class NoMoreMoneyInStorage extends Exception {
    public NoMoreMoneyInStorage(String s) {
        Display.error(s);
    }
}
