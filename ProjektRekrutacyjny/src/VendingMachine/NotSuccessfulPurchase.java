package VendingMachine;

public class NotSuccessfulPurchase extends Exception {
    public NotSuccessfulPurchase(String message) {
        super(message);
    }
}
