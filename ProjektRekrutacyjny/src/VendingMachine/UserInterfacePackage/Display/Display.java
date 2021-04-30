package VendingMachine.UserInterfacePackage.Display;

public class Display {

    public static void info(String message) {
        System.out.println(message);

    }

    public static void error(String message){
        System.err.println(message);
    }

    public static void accountBalanceInfo(double amountToDisplay) {
        System.out.format("Dostępne środki: %.1f PLN\n", amountToDisplay);
    }
}
