package VendingMachine.Products.Drinks;

import VendingMachine.Products.Components.Component;
import VendingMachine.Products.Components.Fluid.FluidComponent;
import VendingMachine.Products.Components.Others.Cup;
import VendingMachine.Products.Components.Powdery.PowderyComponent;
import VendingMachine.Products.Components.Powdery.Sugar;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public abstract class Drink {

    Cup cup;
    ArrayList<FluidComponent> fluidComponents = new ArrayList<>();
    ArrayList<PowderyComponent> powderyComponents = new ArrayList<>();

    public void addSugarPortion(Sugar sugar) {
        this.powderyComponents.add(sugar);
    }


    public boolean isComponentRequired(Component component) {
        Class[] constructorParametersTypes = getConstructorParameters();
        for (Class checkingType : constructorParametersTypes) {
            if (checkingType.getTypeName().equals(component.getComponentType())) {
                return true;
            }
        }
        return false;
    }

    private Class[] getConstructorParameters() {
        Constructor<?>[] constructors = this.getClass().getDeclaredConstructors();
        Constructor defaultConstructor = constructors[0];
        return defaultConstructor.getParameterTypes();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
