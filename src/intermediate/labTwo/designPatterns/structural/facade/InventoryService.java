package intermediate.labTwo.designPatterns.structural.facade;

public class InventoryService {
    public boolean checkInventory(String itemId) {
        // Dummy logic for inventory check
        return true; // Assume item is in stock
    }

    public void reserveInventory(String itemId, int quantity) {
        System.out.println("Inventory reserved for item: " + itemId + ", quantity: " + quantity);
    }
}