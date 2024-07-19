package intermediate.labOne.designPatterns.composite.component;

import intermediate.exceptions.MenuException;
import intermediate.labOne.designPatterns.composite.menuComponents.MenuComponent;

public class Waitress {
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        try {
            var menusIterator = allMenus.createIterator();
            while(menusIterator.hasNext()){
                var component = menusIterator.next();
                component.print();
            }
        } catch (MenuException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
