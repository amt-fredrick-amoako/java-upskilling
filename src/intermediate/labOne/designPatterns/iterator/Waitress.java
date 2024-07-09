package intermediate.labOne.designPatterns.iterator;

import intermediate.labOne.designPatterns.iterator.menu.DinnerMenu;
import intermediate.labOne.designPatterns.iterator.menu.Menu;
import intermediate.labOne.designPatterns.iterator.menu.PancakeHouseMenu;
import intermediate.labOne.designPatterns.iterator.menuItem.MenuItem;

import java.util.ArrayList;
import java.util.Iterator;

public class Waitress {
    Menu pancakeHouseMenu;
    Menu dinnerMenu;

    ArrayList<Menu> menus;

    public Waitress(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    public void printMenu(){
        Iterator<Menu> menuIterator = menus.iterator();
        while(menuIterator.hasNext()){
            Menu menu = menuIterator.next();
            printMenu(menu.createIterator());
        }

    }

    void printMenu(Iterator<Object> iterator){
        while(iterator.hasNext()){
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }

    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        ArrayList<Object> breakfastItems = pancakeHouseMenu.getMenuItems();

        DinnerMenu dinnerMenu = new DinnerMenu();
        MenuItem[] lunchItems = dinnerMenu.getMenuItems();

        for(int i = 0; i < breakfastItems.size(); i++){
            MenuItem menuItem = (MenuItem) breakfastItems.get(i);
            System.out.println(menuItem.getName() + " ");
            System.out.println(menuItem.getPrice() + " ");
            System.out.println(menuItem.getDescription());
        }

        for(int i = 0; i < lunchItems.length; i++){
            MenuItem menuItem = lunchItems[i];
            System.out.println(menuItem.getName() + " ");
            System.out.println(menuItem.getPrice() + " ");
            System.out.println(menuItem.getDescription());
        }
    }
}
