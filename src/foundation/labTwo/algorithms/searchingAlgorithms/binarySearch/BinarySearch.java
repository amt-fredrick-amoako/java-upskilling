package foundation.labTwo.algorithms.searchingAlgorithms.binarySearch;


import static java.lang.Math.floorDiv;

public class BinarySearch {
     static int search(int[] arr, int target){
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = floorDiv(left + right, 2);
            int midValue = arr[mid];
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] searchable = {1, 2, 7, 8, 22, 28, 41, 58, 67, 71, 94};
        int target = 94;

        System.out.println(search(searchable, target));
    }
}
