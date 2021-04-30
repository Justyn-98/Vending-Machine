package VendingMachine.ProductManagers.ProductCreator;
import VendingMachine.Products.Drinks.Drink;
import VendingMachine.Products.ProductList;


public class ProductManager {

    private ProductCreator productCreator = new ProductCreator();
    private SugarManager sugarManager = new SugarManager();


    public Drink prepareProduct(ProductList product, int sugarPortions, ComponentStorage componentStorage) throws ClassNotFoundException {
        Drink drink = productCreator.createProduct(product, componentStorage);
        sugarManager.setSugarQuantity(drink, sugarPortions, componentStorage);
        return drink;
    }


}
