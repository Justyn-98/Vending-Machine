package VendingMachine;

import VendingMachine.Coins.Coin;
import VendingMachine.Coins.PLN_Coin;
import VendingMachine.MoneyService.*;
import VendingMachine.ProductManagers.ProductCreator.ComponentStorageAggregate;
import VendingMachine.ProductManagers.ProductsAvailabilityManager.ProductAvailabilityManager;
import VendingMachine.ProductManagers.ProductCreator.ComponentStorage;
import VendingMachine.ProductManagers.ProductCreator.ProductManager;
import VendingMachine.Products.Components.Component;
import VendingMachine.Products.Drinks.Drink;
import VendingMachine.Products.ProductList;
import VendingMachine.User.User;
import VendingMachine.UserInterfacePackage.Display.Display;
import VendingMachine.UserInterfacePackage.Display.DisplayMessages;
import VendingMachine.UserInterfacePackage.Keyboard.InvalidUserInputException;
import VendingMachine.UserInterfacePackage.UserInterface;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class VendingMachine {

    private MoneyManager moneyManager = new MoneyManager();
    private ProductManager productManager = new ProductManager();
    private UserInterface userInterface = new UserInterface();
    private ComponentStorage componentStorage = new ComponentStorage();

    private User user;

    public void run(User user) throws Throwable {
        this.user = user;
        ProductAvailabilityManager.setNeedToCheckStatusOfProductsAvailability(true);
        MoneyStorageChecker.setNeedToCheckMoneyStorageStatus(true);
        while (true) {
            ProductAvailabilityManager.procedureCheckingProductsAvailability(componentStorage);
            try {
                moneyManager.checkMoneyStorageStatus();
                String userAction = userInterface.menuSelectionProcedure(moneyManager.getBufferValue());
                findMenuMethod(userAction);
            } catch (InvalidUserInputException ex) {
                Display.error(DisplayMessages.INVALID_USER_INPUT.getMessage());
            }catch (NoMoreMoneyInStorage ex){
                System.exit(0);
            }
        }
    }

    public void addComponentToTheStorage(Component component) {
        ComponentStorageAggregate.addComponentToStorage(component,componentStorage);
    }

    public void addCoinsToTheMoneyStorage(ArrayList<PLN_Coin> coins){
        moneyManager.getMoneyStorage().addCoins(coins);
    }

    private void insertCoin() {
        Coin coin = null;
        try {
            coin = user.giveCoin();
            moneyManager.addCoinToBuffer(coin);
        } catch (CoinIsNotPLNCoin ex) {
            Display.error(DisplayMessages.COIN_IS_NOT_PLN_COIN.getMessage());
            user.takeCoin(coin);
        }catch (Exception e){
            Display.error(DisplayMessages.USER_HAS_NOT_COINS.getMessage());
        }
    }

    private void  drinkPurchase()  {
        try {
            ProductList product = userInterface.productSelectionProcedure();
            if (drinkPurchaseIsPossible(product)) {
                procedureCratingDrink(product);
            }
        } catch (InvalidUserInputException ex) {
            Display.error(DisplayMessages.INVALID_USER_INPUT.getMessage());
        }
    }

    private void takeMoneyFromMachine() {
        user.takeMoney(moneyManager.getCoinsFromBuffer());
    }

    private void goAwayFromMachine() {
        System.exit(0);
    }

    private boolean drinkPurchaseIsPossible(ProductList product) {
        if (!product.isAvailable())
            Display.error(DisplayMessages.PRODUCT_NOT_AVAILABLE.getMessage());
        return product.isAvailable() && moneyManager.isEnoughCash(product.getPrice()) && purchaseIsConfirmed();
    }

    private boolean purchaseIsConfirmed() {
        return userInterface.purchaseConfirmProcedure();
    }

    private void procedureCratingDrink(ProductList product) {
        int sugarQuantity = userInterface.sugarQuantityChoiceProcedure();
        try {
            Drink drink = productManager.prepareProduct(product, sugarQuantity, componentStorage);
            moneyManager.updateStatusAfterPurchase(product.getPrice());
            user.takeDrink(drink);
        } catch (ClassNotFoundException ex) {
            Display.error(DisplayMessages.NOT_FOUND_PRODUCT.getMessage());
        }
    }

    private void findMenuMethod(String method) throws Throwable {
        try {
            Method reflectedMethod = this.getClass().getDeclaredMethod(method);
            reflectedMethod.setAccessible(true);
            reflectedMethod.invoke(this);
        } catch (NoSuchMethodException | IllegalAccessException exception) {
            Display.error(DisplayMessages.INVALID_WORK_KEYBOARD_DECODER.getMessage());
        } catch (InvocationTargetException exception) {
            throw new Exception(exception.getTargetException().getMessage());
        }
    }
}
