import VendingMachine.Coins.TwoPLN;
import VendingMachine.VendingMachine;
import VendingMachine.User;


public class Main {

    public static void main(String[] args) {
            VendingMachine vendingMachine = new VendingMachine();
            User user = new User();
            user.addCoinToWallet(new TwoPLN());
            user.addCoinToWallet(new TwoPLN());
            user.addCoinToWallet(new TwoPLN());
            user.addCoinToWallet(new TwoPLN());
            vendingMachine.run(user);
    }
}
