package VendingMachine.Coins;

public abstract class Coin {
    Double value;

    public Coin(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }
}
