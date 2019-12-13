package VendingMachine;

import VendingMachine.Coins.Coin;
import VendingMachine.Coins.TwoPLN;
import VendingMachine.Coins.PLNCoin;
import VendingMachine.Products.Drinks.Drink;

import java.util.ArrayList;

public class User {

    private String name;
    private ArrayList<PLNCoin> wallet = new ArrayList<>();
    private ArrayList<Drink> boughtDrink = new ArrayList<>();

    public void addCoinToWallet(PLNCoin coin){
        wallet.add(coin);
    }
    public Coin giveCoinFromWallet() {
        return wallet.get(0);
    }

    public void takeDrink(Drink drink){
        boughtDrink.add(drink);
    }

    public void takeMoney(ArrayList<PLNCoin> money){
        wallet.addAll(money);
    }
}
