package VendingMachine;

import VendingMachine.Coins.Coin;
import VendingMachine.Coins.PLNCoin;
import VendingMachine.MoneyService.MoneyOutException;
import VendingMachine.MoneyService.MoneyService;
import VendingMachine.ProductCreator.ComponentSoldOut;
import VendingMachine.ProductCreator.ProductCreator;
import VendingMachine.Products.Drinks.Drink;
import VendingMachine.Products.ProductList;

import java.util.ArrayList;

public class VendingMachine {

    private MoneyService moneyService = new MoneyService();
    private ProductCreator productCreator = new ProductCreator();
    private MachineDisplay machineDisplay = new MachineDisplay();
    private MachineKeyboard machineKeyboard = new MachineKeyboard();
    private AdditionalProductService additionalProductService = new AdditionalProductService();

    public void run(User user) {
        do {
            machineDisplay.machineInfo(moneyService.getBufferValue());
            switch (machineKeyboard.pickNumberToMenuChoice()) {
                case 1:
                    insertCoin(user.giveCoinFromWallet());
                    break;
                case 2:
                    try {
                        Drink drink = buyDrink();
                        machineDisplay.sugarQuantityRequestInfo();
                        additionalProductService.setSugarQuantity(drink, machineKeyboard.pickNumberOfSugarPortion());
                        user.takeMoney(getRest());
                        user.takeDrink(drink);
                    } catch (ComponentSoldOut componentSoldOut) {
                        componentSoldOut.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    } catch (NotSuccessfulPurchase notSuccessfulPurchase) {
                        notSuccessfulPurchase.printStackTrace();
                    } catch (MoneyOutException moneyOutException) {
                        moneyOutException.printStackTrace();
                    }
                    break;
                case 3:
                    cancelPurchase(user);
                    break;
                default:
                    break;
            }
        } while (machineKeyboard.getPickedNumber() != machineKeyboard.getMENU_CHOICE_MAX_NUMBER());
        machineKeyboard.closeScanner();
    }

    private void insertCoin(Coin coin) {
        moneyService.addCoinToBuffer(coin);
    }


    private Drink buyDrink() throws ComponentSoldOut, ClassNotFoundException, NotSuccessfulPurchase, MoneyOutException {
        ProductList product = choiceProduct();
        machineDisplay.confirmRequestInfo();
        if (purchaseConfirmed() && moneyService.isEnoughCash(product.getPrice())) {
            return executionProcedureCreationProduct(product);
        }
        throw new NotSuccessfulPurchase("Nie udany zakup");
    }

    private Drink executionProcedureCreationProduct(ProductList product) throws ComponentSoldOut, ClassNotFoundException, MoneyOutException {
        moneyService.updateStatus(product.getPrice());
        machineDisplay.purchaseInfo(product);
        Drink drink = productCreator.createProduct(product);
        machineDisplay.displayPurchaseConfirm();
        return drink;
    }

    private ArrayList<PLNCoin> getRest() {
        return moneyService.getCoinsFromBuffer();
    }

    private boolean purchaseConfirmed() {
        int number = machineKeyboard.pickNumberToConfirmPurchase();
        return number == 1;
    }

    private ProductList choiceProduct() throws ClassNotFoundException {
        machineDisplay.productChoiceRequestInfo();
        ProductList productList = machineKeyboard.pickProduct();
        return productList;
    }

    private void cancelPurchase(User user) {
        user.takeMoney(moneyService.getCoinsFromBuffer());
        machineDisplay.CancelPurchaseInfo();
    }
}
