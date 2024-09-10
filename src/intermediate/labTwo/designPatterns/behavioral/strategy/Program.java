package intermediate.labTwo.designPatterns.behavioral.strategy;

import java.util.Arrays;

public class Program {
    private SortingStrategy strategy;

    public Program(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void sortArray(int[] data) {
        strategy.sort(data);
    }

    public static void main(String[] args) {
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};

        Program sorter = new Program(new BubbleSortStrategy());
        sorter.sortArray(numbers);
        System.out.println("Bubble sorted: " + Arrays.toString(numbers));

        sorter.setStrategy(new QuickSortStrategy());
        sorter.sortArray(numbers);
        System.out.println("Quick sorted: " + Arrays.toString(numbers));

    }
}
