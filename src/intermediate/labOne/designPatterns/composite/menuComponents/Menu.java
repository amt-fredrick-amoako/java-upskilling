package intermediate.labOne.designPatterns.composite.menuComponents;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Menu extends MenuComponent {
    ArrayList<MenuComponent> menuComponents = new ArrayList<>();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
         menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
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
    public void print() {
        System.out.println("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("---------------------");

        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            menuComponent.print();
        }
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        return new CompositeIterator(menuComponents.iterator());
    }

    public static class CompositeIterator implements Iterator<MenuComponent> {

        Stack<Iterator<MenuComponent>> stack = new Stack<>();

        public CompositeIterator(Iterator<MenuComponent> iterator){
            this.stack.push(iterator);
        }

        @Override
        public boolean hasNext() {
           if(stack.isEmpty()){
               return false;
           }else{
               Iterator<MenuComponent> iterator = stack.peek();
               if(!iterator.hasNext()){
                   stack.pop(); // when element is not a menu or a composite, remove it from the stack
                   return hasNext(); // call hasNext() recursively to empty the stack.
               }else{
                   return true;
               }
           }
        }

        @Override
        public MenuComponent next() {
            // check what's on the stack and use it's iterator to iterate over the components
            if(hasNext()){
                Iterator<MenuComponent> iterator = stack.peek();
                MenuComponent component = iterator.next();
                if(component instanceof Menu){
                    stack.push(component.createIterator()); // push component on stack if it's a menu
                }
                return component;
            }else{
                return null;
            }
        }
    }
}
