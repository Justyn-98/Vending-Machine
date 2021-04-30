package VendingMachine.ProductManagers.ProductsAvailabilityManager;

import VendingMachine.ProductManagers.ProductCreator.ComponentStorage;
import VendingMachine.Products.ProductList;
import VendingMachine.UserInterfacePackage.Display.Display;
import VendingMachine.UserInterfacePackage.Display.DisplayMessages;

public class ProductAvailabilityManager {

    private static ComponentsAvailabilityChecker componentsAvailabilityChecker =
            new ComponentsAvailabilityChecker();
    private static ProductsAvailabilitySetter productsAvailabilitySetter =
            new ProductsAvailabilitySetter();

    private static boolean needToCheckStatusOfProductsAvailability = false;


    public static void procedureCheckingProductsAvailability(ComponentStorage componentStorage){
        if (isNeedToCheckStatusOfProductsAvailability()) {
            updateAvailabilityStatusOfProducts(componentStorage);
        }
        if (existUnavailableProducts()) {
            Display.info(DisplayMessages.NOT_AVAILABLE_PRODUCTS_LIST.getMessage());
        }
        if(!ProductList.SUGAR.isAvailable()){
            Display.info(DisplayMessages.SUGAR_NOT_AVAILABLE.getMessage());
        }
    }

    public static void setNeedToCheckStatusOfProductsAvailability(boolean changeOfStatus) {
        needToCheckStatusOfProductsAvailability = changeOfStatus;
    }

    private static boolean isNeedToCheckStatusOfProductsAvailability() {
        return needToCheckStatusOfProductsAvailability;
    }

    private static void updateAvailabilityStatusOfProducts(ComponentStorage componentStorage) {
        if (componentsAvailabilityChecker.checkIfNotMissingComponentInMachine(componentStorage)) {
            productsAvailabilitySetter.changeStatusAvailabilityOfProducts(componentsAvailabilityChecker.getMissingComponents());
        }
    }

    private static boolean existUnavailableProducts() {
        return ProductList.isUnavailableProducts();
    }
}
