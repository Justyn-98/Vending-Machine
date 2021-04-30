package VendingMachine.Coins;

import VendingMachine.MoneyService.CoinIsNotPLNCoin;

public class PLN_Coin extends Coin implements Comparable{

    public PLN_Coin(Double value) throws CoinIsNotPLNCoin {
        super(value);
        if (!isPLN_Coin())
            throw new CoinIsNotPLNCoin();
    }
    private boolean isPLN_Coin(){
        return PLN_CoinDenomination.getPLN_CoinDenominationValues().contains(value);
    }

    @Override
    public int compareTo(Object o) {
        PLN_Coin pln_coin = (PLN_Coin) o;
        return this.value.compareTo(pln_coin.value);
    }
}
