package VendingMachine.Products.Components.Powdery;

public class Sugar extends PowderyComponent {

    public Sugar(double weightInGrams) {
        super(weightInGrams);
    }

    private Sugar(){

    }

    @Override
    public Sugar takeSomeComponent(double componentQuantity) {
        this.weightInGrams -= componentQuantity;
        return new Sugar(componentQuantity);
    }

    @Override
    public void addSomeComponent(PowderyComponent componentQuantity) {
        if (componentQuantity instanceof Sugar)
            this.weightInGrams = this.getQuantityOfComponent() + componentQuantity.getQuantityOfComponent();
    }
    public static Sugar getInstance(){
        return new Sugar();
    }

    @Override
    public String getComponentType() {
        return this.getClass().getTypeName();
    }

}
