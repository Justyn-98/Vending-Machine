package VendingMachine.Products.Components.Others;

public class BigCup extends Cup {

    double volume = 320.0;

    public BigCup(){
    }

    public static BigCup getInstance(){
        return new BigCup();
    }

    @Override
    public String getComponentType() {
        return this.getClass().getTypeName();
    }

}
