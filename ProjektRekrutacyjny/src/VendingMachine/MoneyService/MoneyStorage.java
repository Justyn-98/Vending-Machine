package VendingMachine.MoneyService;

import VendingMachine.Coins.*;

import java.util.ArrayList;

public class MoneyStorage {

    private ArrayList<FivePLN> fivePLNS = new ArrayList<>();
    private ArrayList<TwoPLN> twoPLNS = new ArrayList<>();
    private ArrayList<OnePLN> onePLNS = new ArrayList<>();
    private ArrayList<HalfPLN> halfPLNS = new ArrayList<>();
    private ArrayList<OneFifthPLN> oneFifthPLNS = new ArrayList<>();
    private ArrayList<OneTenthPLN> oneTenthPLNS = new ArrayList<>();

    public ArrayList<PLNCoin> getCoins(double coinsValue) throws MoneyOutException {
        ArrayList<PLNCoin> coinsToReturn = new ArrayList<>();
        while (coinsValue != 0) {
            if (coinsValue >= 5.0 && !fivePLNS.isEmpty()) {
                coinsValue -= 5.0;
                coinsToReturn.add(fivePLNS.get(0));
            } else if (coinsValue >= 2.0 && !twoPLNS.isEmpty()) {
                coinsValue -= 2.0;
                coinsToReturn.add(twoPLNS.get(0));
            } else if (coinsValue >= 1.0 && !onePLNS.isEmpty()) {
                coinsValue -= 1.0;
                coinsToReturn.add(onePLNS.get(0));
            } else if (coinsValue >= 0.5 && !halfPLNS.isEmpty()) {
                coinsValue -= 0.5;
                coinsToReturn.add(halfPLNS.get(0));
            } else if (coinsValue >= 0.2 && !oneFifthPLNS.isEmpty()) {
                coinsValue -= 0.2;
                coinsToReturn.add(oneFifthPLNS.get(0));
            } else if (coinsValue >= 0.1 && !oneTenthPLNS.isEmpty()) {
                coinsValue -= 0.1;
                coinsToReturn.add(oneTenthPLNS.get(0));
            }
        }
        return coinsToReturn;
    }


    public void saveCoins(ArrayList<PLNCoin> coinsFromBuffer) {
        for (Object currentCoin : coinsFromBuffer) {
            if (currentCoin instanceof HalfPLN) {
                halfPLNS.add((HalfPLN) currentCoin);
            } else if (currentCoin instanceof OneFifthPLN) {
                oneFifthPLNS.add((OneFifthPLN) currentCoin);
            } else if (currentCoin instanceof OneTenthPLN) {
                oneTenthPLNS.add((OneTenthPLN) currentCoin);
            } else if (currentCoin instanceof FivePLN) {
                fivePLNS.add((FivePLN) currentCoin);
            } else if (currentCoin instanceof TwoPLN) {
                twoPLNS.add((TwoPLN) currentCoin);
            } else if (currentCoin instanceof OnePLN) {
                onePLNS.add((OnePLN) currentCoin);
            }
        }
    }
}
