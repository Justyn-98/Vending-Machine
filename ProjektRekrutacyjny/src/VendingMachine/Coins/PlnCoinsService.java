package VendingMachine.Coins;

import VendingMachine.MoneyService.CoinIsNotPLNCoin;

import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;

public class PlnCoinsService {

    public static Double getValueOfPLN_Coins(ArrayList<PLN_Coin> coins) {
        Double value = 0.0;
        for (PLN_Coin coin : coins) {
            value += coin.getValue();
        }
        return value;
    }

    public static String getStringWithCoinsValues(ArrayList<PLN_Coin> coins) {
        StringBuffer stringBuffer = new StringBuffer();
        for (PLN_Coin coin : coins) {
            stringBuffer.append(coin.value + "\n");
        }
        return stringBuffer.toString();
    }

    public static ArrayList<PLN_Coin> crateListWithCoins(Double coinValue, int numberOfCoins) throws CoinIsNotPLNCoin {
        ArrayList<PLN_Coin> pln_coins = new ArrayList<>();
        for (int i = 0; i < numberOfCoins; i++) {
            pln_coins.add(new PLN_Coin(coinValue));
        }
        return pln_coins;
    }

}
