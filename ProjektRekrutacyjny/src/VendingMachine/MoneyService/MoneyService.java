package VendingMachine.MoneyService;

import VendingMachine.Coins.Coin;
import VendingMachine.Coins.PLNCoin;

import java.util.ArrayList;

public class MoneyService {

    private MoneyStorage moneyStorage = new MoneyStorage();
    private ArrayList<PLNCoin> moneyBuffer = new ArrayList<>();
    private double  bufferValue = 0;

    public double getBufferValue() {
        return bufferValue;
    }

    public void addCoinToBuffer(Coin coin){
            moneyBuffer.add((PLNCoin) coin);
            bufferValue += coin.getValue();
    }


    public ArrayList<PLNCoin> getCoinsFromBuffer(){
        ArrayList<PLNCoin> coinsToReturn = (ArrayList<PLNCoin>) moneyBuffer.clone();
        moneyBuffer.clear();
        return coinsToReturn;
    }


    public void updateStatus(double productPrice) throws MoneyOutException {
    transferCoinsFromBufferToStorage();
    transferRestFromStorageToBuffer(calculateRest(productPrice));
    }

    public boolean isEnoughCash(double price) {
        return price < bufferValue;
    }

    private void transferCoinsFromBufferToStorage(){
        moneyStorage.saveCoins(getCoinsFromBuffer());
    }

    private void transferRestFromStorageToBuffer(double rest) throws MoneyOutException {
            moneyBuffer.addAll(moneyStorage.getCoins(rest));
    }
    private double calculateRest(double productPrice){
        return bufferValue - productPrice;
    }
}
