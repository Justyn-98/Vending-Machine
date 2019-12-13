package VendingMachine.MoneyService;

public class MoneyOutException extends Exception {
    public MoneyOutException(String message) {
        super(message);
    }
}
