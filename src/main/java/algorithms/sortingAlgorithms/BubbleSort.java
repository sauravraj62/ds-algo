package algorithms.sortingAlgorithms;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {4, 2, 5, 6, 1, 9};
        sort(arr);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for(int x : arr) {
            System.out.print(x + " ");
        }
    }
    public static void sort(int arr[]) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
