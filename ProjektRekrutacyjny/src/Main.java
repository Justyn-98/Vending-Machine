
import VendingMachine.Coins.PlnCoinsService;
import VendingMachine.Coins.PLN_Coin;
import VendingMachine.MoneyService.CoinIsNotPLNCoin;
import VendingMachine.Products.Components.Fluid.Milk;
import VendingMachine.Products.Components.Fluid.Water;
import VendingMachine.Products.Components.Others.BigCup;
import VendingMachine.Products.Components.Others.SmallCup;
import VendingMachine.Products.Components.Powdery.Cocoa;
import VendingMachine.Products.Components.Powdery.CoffeeBeans;
import VendingMachine.Products.Components.Powdery.Sugar;
import VendingMachine.User.User;
import VendingMachine.VendingMachine;
import VendingMachine.User.ExampleUser;

public class Main {


    //Example simulation of VendingMachine

    public static void main(String[] args) throws Throwable {
        VendingMachine vendingMachine = new VendingMachine();
        ExampleUser exampleUser = new ExampleUser();
        fillComponentStorageVendingMachine(vendingMachine);
        fillMoneyStorageVendingMachine(vendingMachine);
        giveUserSomeCoins(exampleUser);
        vendingMachine.run(exampleUser);
    }

    //not added Cocoa, Product hot chocolate will be unavailable
    private static void fillComponentStorageVendingMachine(VendingMachine vendingMachine){
        vendingMachine.addComponentToTheStorage(new CoffeeBeans(100));
        vendingMachine.addComponentToTheStorage(new Water(1000));
        vendingMachine.addComponentToTheStorage(new Sugar(100));
        //vendingMachine.addComponentToTheStorage(new Cocoa(1000));
        vendingMachine.addComponentToTheStorage(new Milk(1000));
        vendingMachine.addComponentToTheStorage(new SmallCup());
        vendingMachine.addComponentToTheStorage(new BigCup());
    }

    private static void fillMoneyStorageVendingMachine(VendingMachine vendingMachine) throws CoinIsNotPLNCoin {
        vendingMachine.addCoinsToTheMoneyStorage(PlnCoinsService.crateListWithCoins(0.1,10));
        vendingMachine.addCoinsToTheMoneyStorage(PlnCoinsService.crateListWithCoins(0.2,10));
        vendingMachine.addCoinsToTheMoneyStorage(PlnCoinsService.crateListWithCoins(0.5,10));
        vendingMachine.addCoinsToTheMoneyStorage(PlnCoinsService.crateListWithCoins(1.0,10));
        vendingMachine.addCoinsToTheMoneyStorage(PlnCoinsService.crateListWithCoins(2.0,10));
    }

    private static void giveUserSomeCoins(User exampleUser) throws CoinIsNotPLNCoin {
        exampleUser.takeCoin(new PLN_Coin(5.0));
        exampleUser.takeCoin(new PLN_Coin(5.0));
    }

}

