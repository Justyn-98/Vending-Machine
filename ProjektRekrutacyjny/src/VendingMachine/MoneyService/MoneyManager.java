package VendingMachine.MoneyService;

import VendingMachine.Coins.Coin;
import VendingMachine.Coins.PlnCoinsService;
import VendingMachine.Coins.PLN_Coin;
import VendingMachine.UserInterfacePackage.Display.Display;
import VendingMachine.UserInterfacePackage.Display.DisplayMessages;

import java.util.ArrayList;

public class MoneyManager {

    private ArrayList<PLN_Coin> moneyBuffer = new ArrayList<>();
    private MoneyStorage moneyStorage = new MoneyStorage();

    public MoneyStorage getMoneyStorage() {
        return moneyStorage;
    }

    public Double getBufferValue() {
        return PlnCoinsService.getValueOfPLN_Coins(moneyBuffer);
    }

    public void addCoinToBuffer(Coin coin) throws CoinIsNotPLNCoin {
        if(coin instanceof PLN_Coin) {
            moneyBuffer.add((PLN_Coin) coin);
        }else {
            throw new CoinIsNotPLNCoin();
        }
    }

    public ArrayList<PLN_Coin> getCoinsFromBuffer() {
        ArrayList<PLN_Coin> coinsToReturn = (ArrayList<PLN_Coin>) moneyBuffer.clone();
        moneyBuffer.clear();
        return coinsToReturn;
    }

    public void updateStatusAfterPurchase(Double productPrice) {
        Double rest = calculateRest(productPrice);
        transferCoinsFromBufferToStorage();
        transferRestFromStorageToBuffer(rest);
    }

    public boolean isEnoughCash(Double price) {
        if (price > getBufferValue())
            Display.info(DisplayMessages.NOT_ENOUGH_MONEY.getMessage());
        return price < getBufferValue();
    }

    public void checkMoneyStorageStatus() throws NoMoreMoneyInStorage {
        if(!MoneyStorageChecker.isMachineCanGiveTheChange(moneyStorage)){
            throw new NoMoreMoneyInStorage(DisplayMessages.NO_MORE_MONEY_IN_STORAGE.getMessage());
        }
    }

    private void transferCoinsFromBufferToStorage() {
        moneyStorage.addCoins(getCoinsFromBuffer());
    }

    private void transferRestFromStorageToBuffer(Double rest) {
        moneyBuffer.addAll(moneyStorage.getCoins(rest));
    }

    private Double calculateRest(Double productPrice) {
        return getBufferValue() - productPrice;
    }


}
