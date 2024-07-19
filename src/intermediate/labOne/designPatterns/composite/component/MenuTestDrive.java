package intermediate.labOne.designPatterns.composite.component;

import intermediate.exceptions.MenuException;
import intermediate.labOne.designPatterns.composite.menuComponents.Menu;
import intermediate.labOne.designPatterns.composite.menuComponents.MenuComponent;
import intermediate.labOne.designPatterns.composite.menuComponents.MenuItem;

public class MenuTestDrive {
    public static void main(String[] args) {
        try {
            MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
            MenuComponent dinnerMenu = new Menu("DINNER MENU", "Lunch");
            MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
            MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");

            MenuComponent allMenus = new Menu("All Menus", "All Menus combined");

            allMenus.add(pancakeHouseMenu);
            allMenus.add(dinnerMenu);
            allMenus.add(cafeMenu);

            dinnerMenu.add(new MenuItem("Pasta", "Spaghetti with Marinara Sauce and a slice of sourdough bread", true, 3.89));
            dinnerMenu.add(new MenuItem("Apple Pie", "Apple pie with flakey crust, topped with vanilla icecream", true, 1.59));
            dinnerMenu.add(dessertMenu);

            Waitress waitress = new Waitress(allMenus);
            waitress.printMenu();
        } catch (MenuException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
