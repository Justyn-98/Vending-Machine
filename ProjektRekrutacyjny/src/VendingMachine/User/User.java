package VendingMachine.User;

import VendingMachine.Coins.Coin;
import VendingMachine.Coins.PLN_Coin;
import VendingMachine.Products.Drinks.Drink;

import java.util.ArrayList;

public interface User {
    Coin giveCoin();
    void takeDrink(Drink drink);
    void takeMoney(ArrayList<PLN_Coin> money);
    void takeCoin(Coin coin);
    }
