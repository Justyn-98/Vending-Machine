package VendingMachine.MoneyService;

import VendingMachine.Coins.PlnCoinsService;
import VendingMachine.Coins.PLN_Coin;

import java.util.ArrayList;
import java.util.Collections;

public class MoneyStorage {

    private ArrayList<PLN_Coin> moneyStorage = new ArrayList<>();


    ArrayList<PLN_Coin> getCoins(Double coinsToTakeValue) {
        ArrayList<PLN_Coin> coinsToReturn = new ArrayList<>();
        ArrayList<PLN_Coin> coinsToCheck = (ArrayList<PLN_Coin>) moneyStorage.clone();
        for (PLN_Coin currentCoin:coinsToCheck) {
           Double remainingAmount = coinsToTakeValue - PlnCoinsService.getValueOfPLN_Coins(coinsToReturn) + 0.01;
            if (currentCoin.getValue().compareTo(remainingAmount) < 0 ){
                coinsToReturn.add(currentCoin);
                moneyStorage.remove(currentCoin);
            }
        }
        MoneyStorageChecker.setNeedToCheckMoneyStorageStatus(true);
        return coinsToReturn;
    }

    ArrayList<PLN_Coin> getMoneyStorage() {
        return moneyStorage;
    }

    public void addCoins(ArrayList<PLN_Coin> coins){
        moneyStorage.addAll(coins);
        Collections.sort(moneyStorage);
        Collections.reverse(moneyStorage);
    }
}

