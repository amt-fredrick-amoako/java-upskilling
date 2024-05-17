package labTwo.algorithms.sortingAlgorithms.selectionSort;

/**
 * The SelectionSort class provides a method for sorting an array of integers using selection sort algorithm.
 * Selection sort is a simple comparison-based algorithm.
 * The worst-case, average-case and best-case time complexity of selection sort is O(n^2), where n is the number of elements in the array.
 */
public class SelectionSort {
    void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort.selectionSort(arr);
        System.out.println("Sorted array using Selection Sort");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}