package intermediate.labOne.designPatterns.composite.menuComponents;

import java.util.Iterator;

public class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void print(){
        System.out.println(" " + getName());
        if(isVegetarian()){
            System.out.println(" (v) ");
        }
        System.out.println(", " + getPrice());
        System.out.println("     -- " + getDescription());
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        return new NullIterator();
    }

    public static class NullIterator implements Iterator<MenuComponent> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public MenuComponent next() {
            return null;
        }
    }
}
