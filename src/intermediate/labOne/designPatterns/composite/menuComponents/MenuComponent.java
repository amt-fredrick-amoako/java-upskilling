package intermediate.labOne.designPatterns.composite.menuComponents;

import intermediate.exceptions.MenuException;

import java.util.Iterator;

public abstract class MenuComponent {
    public void add(MenuComponent menuComponent) throws MenuException {
        throw new MenuException("Action not supported");
    }

    public void remove(MenuComponent menuComponent) throws MenuException {
        throw new MenuException("Action not supported");
    }

    public MenuComponent getChild(int i) throws MenuException {
        throw new MenuException("Action not supported");
    }

    public String getName() throws MenuException {
        throw new MenuException("Action not supported");
    }

    public String getDescription() throws MenuException {
        throw new MenuException("Action not supported");
    }

    public double getPrice() throws MenuException {
        throw new MenuException("Action not supported");
    }

    public boolean isVegetarian() throws MenuException {
        throw new MenuException("Action not supported");
    }

    public void print() throws MenuException {
        throw new MenuException("Action not supported");
    }

    public Iterator<MenuComponent> createIterator() throws MenuException {
        throw new MenuException("Action not supported");
    }
}
