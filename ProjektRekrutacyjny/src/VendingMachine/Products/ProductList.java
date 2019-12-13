package VendingMachine.Products;

public enum ProductList {
    SMALL_COFFEE("Mała kawa", 2.2),
    BIG_COFFEE("Duża Kawa", 3.2),
    SMALL_MILK_COFFEE("Małą kawa z mlekiem", 2.5),
    BIG_MILK_COFFEE("Duża kawa z mlekiem", 3.5),
    SMALL_HOT_CHOCOLATE("Mała gorąca czekolada", 2.0),
    BIG_HOT_CHOCOLATE("Duża gorąca czekolada", 3.0);

    private String name;
    private double price;

    ProductList(String name, double price) {
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Produkt " +
                 name  +
                ", cena = " + price;
    }
}
