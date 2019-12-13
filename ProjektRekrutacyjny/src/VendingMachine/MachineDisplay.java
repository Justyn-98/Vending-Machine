package VendingMachine;

import VendingMachine.Products.ProductList;

import java.time.LocalTime;

public class MachineDisplay {

    private LocalTime localTime = LocalTime.now();

    public void machineInfo(double amount ){
        currentTimeInfo();
        accountBalanceInfo(amount);
        productListInfo();
        menuInfo();
    }
    public void purchaseInfo(ProductList product){
        System.out.println("Zakupiono produkt " + product);
    }

    public void productChoiceRequestInfo(){
        System.out.println("Wprawadź numer produkty");
    }

    public void confirmRequestInfo(){
        System.out.println("Wprowadź 1 aby potwierdzić");
        System.out.println("Wprowadź 2 aby anulować");
    }

    public void displayPurchaseConfirm(){
        System.out.println("Transakcja zakończona");
        System.out.println("Proszę odebrać produkt");
    }


    private void currentTimeInfo(){
        System.out.println(localTime);
    }

    private void productListInfo(){
        System.out.println("1 " + ProductList.SMALL_COFFEE.toString());
        System.out.println("2 " + ProductList.BIG_COFFEE.toString());
        System.out.println("3 " + ProductList.SMALL_MILK_COFFEE.toString());
        System.out.println("4 " + ProductList.BIG_MILK_COFFEE.toString());
        System.out.println("5 " + ProductList.SMALL_HOT_CHOCOLATE.toString());
        System.out.println("6 " + ProductList.BIG_HOT_CHOCOLATE.toString());
    }

    private void accountBalanceInfo(double amountToDisplay){
        System.out.println("Dostępne środki: "+ amountToDisplay);
    }

    private void menuInfo(){
        System.out.println("Wprowadź na klwiaturze: ");
        System.out.println("1 Wrzuć monetę:");
        System.out.println("2: Wybierz produkt");
        System.out.println("3 Anuluj");
        System.out.println("4. Odejdź od automatu");
    }

    public void CancelPurchaseInfo() {
        System.out.println("Anulowano zakup");
    }

    public void sugarQuantityRequestInfo() {
        System.out.println("Podaj ilość cukru od 0-5");
    }
}
