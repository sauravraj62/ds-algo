package algorithms.sortingAlgorithms;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {5, 4, 3, 2, 1};
        sort(arr);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for(int x : arr) {
            System.out.print(x + " ");
        }
    }

    private static void sort(int[] arr) {
        for(int i = 1; i < arr.length ; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
