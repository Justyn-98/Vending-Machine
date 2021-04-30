package VendingMachine.MoneyService;

import VendingMachine.Coins.PLN_Coin;
import VendingMachine.Coins.PLN_CoinDenomination;

public class MoneyStorageChecker {

    public static boolean needToCheckMoneyStorageStatus = false;

    private static Double oneTenthPLNsValue = 0.0;
    private static Double oneFifthPLNsValue = 0.0;
    private static Double halfPLNsValue = 0.0;
    private static Double onePLNsValue = 0.0;
    private static Double twoPLNsValue = 0.0;


    public static boolean isMachineCanGiveTheChange(MoneyStorage moneyStorage) {
        if(needToCheckMoneyStorageStatus) {
            resetCounters();
            calculateNumberOfCoins(moneyStorage);
            return isMinimalNumberOfCoinsInMoneyStorage();
        }
        else
            return true;
    }

    public static void setNeedToCheckMoneyStorageStatus(boolean needToCheckMoneyStorageStatus) {
        MoneyStorageChecker.needToCheckMoneyStorageStatus = needToCheckMoneyStorageStatus;
    }

    private static boolean isMinimalNumberOfCoinsInMoneyStorage() {
        needToCheckMoneyStorageStatus = false;
        Double firstCombination = oneFifthPLNsValue + oneTenthPLNsValue;
        Double secondCombination = firstCombination + halfPLNsValue;
        Double thirdCombination = secondCombination + onePLNsValue + twoPLNsValue;
        return oneTenthPLNsValue.compareTo(0.1) >= 0 && firstCombination.compareTo(0.4) >= 0
                && secondCombination.compareTo(0.9) >= 0
                && thirdCombination.compareTo(4.9) >= 0;
    }

    private static void calculateNumberOfCoins(MoneyStorage moneyStorage) {
        for (PLN_Coin currentCoin : moneyStorage.getMoneyStorage()) {
            if (currentCoin.getValue().compareTo(PLN_CoinDenomination.ONE_TENTH_PLN.getValue()) == 0) {
                oneTenthPLNsValue += PLN_CoinDenomination.ONE_TENTH_PLN.getValue();
            } else if (currentCoin.getValue().compareTo(PLN_CoinDenomination.ONE_FIFTH.getValue()) == 0) {
                oneFifthPLNsValue += PLN_CoinDenomination.ONE_FIFTH.getValue();
            } else if (currentCoin.getValue().compareTo(PLN_CoinDenomination.HALF_PLN.getValue()) == 0) {
                halfPLNsValue += PLN_CoinDenomination.HALF_PLN.getValue();
            } else if (currentCoin.getValue().compareTo(PLN_CoinDenomination.ONE_PLN.getValue()) == 0) {
                onePLNsValue += PLN_CoinDenomination.ONE_PLN.getValue();
            } else if (currentCoin.getValue().compareTo(PLN_CoinDenomination.TWO_PLN.getValue()) == 0) {
                twoPLNsValue += PLN_CoinDenomination.TWO_PLN.getValue();
            }
        }
    }

    private static void resetCounters() {
        oneTenthPLNsValue = 0.0;
        oneFifthPLNsValue = 0.0;
        halfPLNsValue = 0.0;
        onePLNsValue = 0.0;
        twoPLNsValue = 0.0;
    }

}
