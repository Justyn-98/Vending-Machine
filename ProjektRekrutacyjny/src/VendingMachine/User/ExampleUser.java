package VendingMachine.User;

import VendingMachine.Coins.Coin;
import VendingMachine.Coins.PlnCoinsService;
import VendingMachine.Coins.PLN_Coin;
import VendingMachine.Products.Drinks.Drink;

import java.util.ArrayList;
import java.util.Collections;

public class ExampleUser implements User {

    private ArrayList<Coin> wallet = new ArrayList<>();
    private ArrayList<Drink> boughtDrink = new ArrayList<>();

    @Override
    public void takeCoin(Coin coin){
        wallet.add(coin);
    }

   @Override
    public Coin giveCoin(){
        return giveRandomCoinFromWallet();
    }

    @Override
    public void takeDrink(Drink drink){
        userInfo("Kupiono produkt: " + drink.toString() );
        boughtDrink.add(drink);
    }

    @Override
    public void takeMoney(ArrayList<PLN_Coin> money){
        wallet.addAll(money);
        userInfo("otrzymano następujące monety: \n" + PlnCoinsService.getStringWithCoinsValues(money));
    }

    public Coin giveRandomCoinFromWallet() {
        Collections.shuffle(wallet);
            Coin coin = wallet.get(0);
            wallet.remove(0);
            userInfo("Wrzucono losową monetę z portfela. Jej wartość to: " + coin.getValue());
            return coin;
    }

    private void userInfo(String message){
        System.out.print("User info: ");
        System.out.println(message);
    }


}
