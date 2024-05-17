package labTwo.algorithms.searchingAlgorithms.linearSearch;

public class LinearSearch {
    static int search(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                return i;
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
