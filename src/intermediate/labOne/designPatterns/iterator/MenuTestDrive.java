package intermediate.labOne.designPatterns.iterator;

import intermediate.labOne.designPatterns.iterator.menu.DinnerMenu;
import intermediate.labOne.designPatterns.iterator.menu.Menu;
import intermediate.labOne.designPatterns.iterator.menu.PancakeHouseMenu;

import java.util.ArrayList;

public class MenuTestDrive {
    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinnerMenu dinnerMenu = new DinnerMenu();
        ArrayList<Menu> menuList = new ArrayList<>();

        menuList.add(pancakeHouseMenu);
        menuList.add(dinnerMenu);

        Waitress waitress = new Waitress(menuList);
        waitress.printMenu();
    }
}
