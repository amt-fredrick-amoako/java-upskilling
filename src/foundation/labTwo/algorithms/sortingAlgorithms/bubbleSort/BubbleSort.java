package foundation.labTwo.algorithms.sortingAlgorithms.bubbleSort;

/**
 * The BubbleSort class provides a method for sorting an array of integers using bubble sort algorithm.
 * Bubble sort is a simple comparison-based algorithm.
 * The worst-case and average time complexity of bubble sort is O(n^2), where n is the number of elements in the array.
 * This happens when the input array is reverse sorted. The best-case time complexity is O(n) when the input array is already sorted.
 */
public class BubbleSort {
    void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort.bubbleSort(arr);
        System.out.println("Sorted array using Bubble Sort");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}