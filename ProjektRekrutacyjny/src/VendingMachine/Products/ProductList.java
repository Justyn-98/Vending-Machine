package VendingMachine.Products;

public enum ProductList {
    SMALL_COFFEE("Mała kawa", 2.2, true),
    BIG_COFFEE("Duża Kawa", 3.2, true),
    SMALL_MILK_COFFEE("Mała kawa z mlekiem", 2.5, true),
    BIG_MILK_COFFEE("Duża kawa z mlekiem", 3.5, true),
    SMALL_HOT_CHOCOLATE("Mała gorąca czekolada", 2.0, true),
    BIG_HOT_CHOCOLATE("Duża gorąca czekolada", 3.0, true),
    SUGAR("Cukier",0.0,true);

    private String name;
    private Double price;
    private boolean isAvailable;

    ProductList(String name, Double price, boolean isAvailable) {
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Produkt " +
                name +
                ", cena = " + price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public static void resetAvailabilityOfProducts(){
        SMALL_COFFEE.setAvailable(true);
        BIG_COFFEE.setAvailable(true);
        SMALL_MILK_COFFEE.setAvailable(true);
        BIG_MILK_COFFEE.setAvailable(true);
        SMALL_HOT_CHOCOLATE.setAvailable(true);
        BIG_HOT_CHOCOLATE.setAvailable(true);
        SUGAR.setAvailable(true);
    }

    public static boolean isUnavailableProducts(){
        return !SMALL_COFFEE.isAvailable || !BIG_COFFEE.isAvailable || !SMALL_MILK_COFFEE.isAvailable
                || !BIG_MILK_COFFEE.isAvailable || !SMALL_HOT_CHOCOLATE.isAvailable ||
                !BIG_HOT_CHOCOLATE.isAvailable || !SUGAR.isAvailable;
    }

}
