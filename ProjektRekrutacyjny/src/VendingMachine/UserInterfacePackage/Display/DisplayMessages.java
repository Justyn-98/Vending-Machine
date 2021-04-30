package VendingMachine.UserInterfacePackage.Display;

import VendingMachine.Products.ProductList;

public enum DisplayMessages {

    MENU("Wprowadź na klwiaturze:" +
            " \n1 aby Wrzuć monetę" +
            "\n2 aby Wybierać produkt" +
            "\n3 aby Zabrać pieniądze z automatu" +
            "\n4 aby Odejdść od automatu"),

    PRODUCT_LIST("1 " + ProductList.SMALL_COFFEE.toString() +
            "\n2 " + ProductList.BIG_COFFEE.toString() +
            "\n3 " + ProductList.SMALL_MILK_COFFEE.toString() +
            "\n4 " + ProductList.BIG_MILK_COFFEE.toString() +
            "\n5 " + ProductList.SMALL_HOT_CHOCOLATE.toString() +
            "\n6 " + ProductList.BIG_HOT_CHOCOLATE.toString()),

    PURCHASE_CONFIRM_REQUEST("Czy potwierdzasz zakup? Wpisz TAK jeśli potwierdzasz."),
    NOT_CONFIRMED_PURCHASE("Nie potwierdzono zakupu"),
    CONFIRMED_PURCHASE("Potwierdzono zakup"),

    SUGAR_QUANTITY_REQUEST("Ilość cukru: Wprowadz od 0-5 dowolnych znaków\nIlość znaków oznacza ilość porcji cukru" +
            "\nJeżeli wprowadzisz więcej niż 5 znaków, automat domyslnie ustawi ilość cukru na 5"),

    SUGAR_QUANTITY_CONFIRM("Wybrana ilość cukru: "),
    PRODUCT_NOT_AVAILABLE("Produkt niedostępny"),
    NOT_ENOUGH_MONEY("Nie wrzucono wymaganej ilości pieniędzy "),

    NOT_AVAILABLE_PRODUCTS_LIST("UWAGA!!!\nZ powodu braku składników " +
            "nieiedostępne są następujące produkty:\n" +
             displayIfProductIsNotAvailable(ProductList.BIG_COFFEE) +
             displayIfProductIsNotAvailable(ProductList.SMALL_COFFEE) +
             displayIfProductIsNotAvailable(ProductList.BIG_MILK_COFFEE) +
             displayIfProductIsNotAvailable(ProductList.SMALL_MILK_COFFEE) +
             displayIfProductIsNotAvailable(ProductList.BIG_HOT_CHOCOLATE) +
             displayIfProductIsNotAvailable(ProductList.SMALL_HOT_CHOCOLATE)),
    SUGAR_NOT_AVAILABLE("UWAGA w maszynie nie ma cukru!!!\n"),

    COIN_IS_NOT_PLN_COIN("Maszyna przyjmuje wyłącznie polskie monety"),
    INVALID_USER_INPUT("Wprowadzono nieprawidłową wartość "),
    NOT_FOUND_PRODUCT("Nie znaleziono wybranego produktu"),
    SUGAR_IS_NOT_AVAILABLE("Z powodu braku cukry jego wartość zostanie ustawiona na 0"),
    NO_MORE_MONEY_IN_STORAGE("Maszyna nieczynna z powodu braku monet do wydawania reszty"),
    USER_HAS_NOT_COINS("Użytkownik nie ma  monet"),
    INVALID_WORK_KEYBOARD_DECODER("Wystąpił błąd związany z działaniem klawiatury");


    private String message;

    DisplayMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private static String displayIfProductIsNotAvailable(ProductList product) {
        if (!product.isAvailable())
            return product.toString() + "\n";
        else return "";
    }
}
