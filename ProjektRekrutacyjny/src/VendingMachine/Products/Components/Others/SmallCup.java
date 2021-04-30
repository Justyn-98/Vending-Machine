package VendingMachine.Products.Components.Others;

public class SmallCup extends Cup {

    double volume = 220.0;

    public SmallCup(){
    }

    @Override
    public String getComponentType() {
        return this.getClass().getTypeName();
    }

    public static SmallCup getInstance(){
        return new SmallCup();
    }
}
