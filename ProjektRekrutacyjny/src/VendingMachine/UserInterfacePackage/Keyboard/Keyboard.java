package VendingMachine.UserInterfacePackage.Keyboard;

import java.util.Scanner;

public class Keyboard {

    private Scanner scanner = new Scanner(System.in);

    public String enterString() {
        return scanner.nextLine();
    }

    public Scanner getScanner() {
        return scanner;
    }
}
