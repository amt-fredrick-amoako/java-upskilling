package labTwo.dataStructures.queue;

public class Program {
    public static void main(String... args) {
        String [] orders = {"green curry","pad thai","gyoza","cucumber salad","pad see ew", "brown rice","red curry","salad rolls"};

        RestaurantOrders foodOrders = new RestaurantOrders();

        foodOrders.assign(orders);
    }
}
