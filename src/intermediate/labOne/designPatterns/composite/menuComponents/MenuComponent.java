package intermediate.labOne.designPatterns.composite.menuComponents;

import intermediate.labOne.designPatterns.exceptions.NotImplementedException;

import java.util.Iterator;

public abstract class MenuComponent {
    public void add(MenuComponent menuComponent) throws NotImplementedException {
        throw new NotImplementedException("Method not Implemented!");
    }

    public void remove(MenuComponent menuComponent) throws NotImplementedException {
        throw new NotImplementedException("Method not Implemented!");
    }

    public MenuComponent getChild(int i) throws NotImplementedException {
        throw new NotImplementedException("Method not Implemented!");
    }

    public String getName() throws NotImplementedException {
        throw new NotImplementedException("Method not Implemented!");
    }

    public String getDescription() throws NotImplementedException {
        throw new NotImplementedException("Method not Implemented!");
    }

    public double getPrice() throws NotImplementedException {
        throw new NotImplementedException("Method not Implemented!");
    }

    public boolean isVegetarian() throws NotImplementedException {
        throw new NotImplementedException("Method not Implemented!");
    }

    public void print() throws NotImplementedException {
        throw new NotImplementedException("Method not Implemented!");
    }

    public Iterator<MenuComponent> createIterator() throws NotImplementedException {
        throw new NotImplementedException("Method not Implemented!");
    }
}
