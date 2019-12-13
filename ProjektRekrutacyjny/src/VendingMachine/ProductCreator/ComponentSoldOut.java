package VendingMachine.ProductCreator;



public class ComponentSoldOut extends Exception {
    public ComponentSoldOut() {
        super("Brak składników");
    }
}
