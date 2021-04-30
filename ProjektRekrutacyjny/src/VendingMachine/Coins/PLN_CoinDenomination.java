package VendingMachine.Coins;

import java.util.ArrayList;

public enum PLN_CoinDenomination {

    ONE_TENTH_PLN(0.1),
    ONE_FIFTH(0.2),
    HALF_PLN(0.5),
    ONE_PLN(1.0),
    TWO_PLN(2.0),
    FIVE_PLN(5.0);

    Double value;

    PLN_CoinDenomination(Double value) {
    this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public  static ArrayList<Double> getPLN_CoinDenominationValues() {
        ArrayList<Double> PLN_CoinDenominations = new ArrayList<>();
        PLN_CoinDenominations.add(ONE_TENTH_PLN.value);
        PLN_CoinDenominations.add(ONE_FIFTH.value);
        PLN_CoinDenominations.add(HALF_PLN.value);
        PLN_CoinDenominations.add(ONE_PLN.value);
        PLN_CoinDenominations.add(TWO_PLN.value);
        PLN_CoinDenominations.add(FIVE_PLN.value);
        return PLN_CoinDenominations;
    }
}
