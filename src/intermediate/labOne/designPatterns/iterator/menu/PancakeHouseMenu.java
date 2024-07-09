package intermediate.labOne.designPatterns.iterator.menu;

import intermediate.labOne.designPatterns.iterator.menuItem.MenuItem;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenu implements Menu {
    ArrayList<Object> menuItems;

    public PancakeHouseMenu() {
        this.menuItems = new ArrayList<>();

        addItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99);
        addItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99);
        addItem("Blueberry Pancakes", "Pancakes made with fresh blueberries", true, 3.49);
        addItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    public ArrayList<Object> getMenuItems() {
        return menuItems;
    }

    public Iterator<Object> createIterator(){
//        return new PancakeHouseMenuIterator(menuItems);
        return menuItems.iterator();
    }

    private static class PancakeHouseMenuIterator implements Iterator<Object> {
        public PancakeHouseMenuIterator(ArrayList<Object> menuItems) {
            this.menuItems = menuItems;
        }

        ArrayList<Object> menuItems;
        int position = 0;



        @Override
        public boolean hasNext() {
            return position < menuItems.size();
        }

        @Override
        public Object next() {
            MenuItem menuItem = (MenuItem) menuItems.get(position);
            position++;
            return menuItem;
        }
    }
}
