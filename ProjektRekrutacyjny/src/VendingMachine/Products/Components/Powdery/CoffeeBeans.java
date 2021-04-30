package VendingMachine.Products.Components.Powdery;

import VendingMachine.Products.Components.Fluid.FluidComponent;

public class CoffeeBeans extends PowderyComponent {

    public CoffeeBeans(double weightInGrams) {
        super(weightInGrams);
    }

    private CoffeeBeans(){

    }
    @Override
    public CoffeeBeans takeSomeComponent(double componentQuantity) {
        this.weightInGrams -= componentQuantity;
        return new CoffeeBeans(componentQuantity);
    }
    @Override
    public void addSomeComponent(PowderyComponent componentQuantity) {
        if (componentQuantity instanceof CoffeeBeans)
            this.weightInGrams = this.getQuantityOfComponent() + componentQuantity.getQuantityOfComponent();
    }
    public static CoffeeBeans getInstance(){
        return new CoffeeBeans();
    }

    @Override
    public String getComponentType() {
        return this.getClass().getTypeName();
    }

}
