package intermediate.labOne.algorithms.greedyAlgorithm;

import java.util.Arrays;

public class GreedyAlgorithm {
    static class Item {
        double value;
        double weight;
        double ratio;

        // Constructor
        public Item(double value, double weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = value / weight;
        }
    }

    // Function to calculate the maximum value
    public static double fractionalKnapsack(int capacity, Item[] items) {
        // Sort items by descending value-to-weight ratio
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0.0;
        for (Item item : items) {
            double currentWeight = item.weight;
            double currentValue = item.value;


            if (capacity - currentWeight >= 0) {
                // If the item can be completely taken
                capacity -= currentWeight;
                totalValue += currentValue;
            } else {
                // Take fraction of the item that fits
                totalValue += currentValue * ((double) capacity / currentWeight);
                break;  // The knapsack is full
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        // Example items
        Item[] items = {new Item(60, 10), new Item(100, 20), new Item(120, 30)};
        int capacity = 50;

        // Calculate maximum value
        double maxValue = fractionalKnapsack(capacity, items);
        System.out.println("Maximum value in knapsack = " + maxValue);
    }
}
