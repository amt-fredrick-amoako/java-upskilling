package intermediate.labTwo.designPatterns.behavioral.strategy;

public class BubbleSortStrategy  implements  SortingStrategy{
    @Override
    public void sort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (data[j] > data[j+1]) {
                    // swap temp and data[i]
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
    }
}
