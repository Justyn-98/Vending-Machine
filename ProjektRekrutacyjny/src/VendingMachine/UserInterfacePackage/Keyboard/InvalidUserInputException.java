package VendingMachine.UserInterfacePackage.Keyboard;

import VendingMachine.UserInterfacePackage.Display.Display;

public class InvalidUserInputException extends Exception {
    public InvalidUserInputException(String message) {
        Display.error(message);
    }
}
