package algorithms.sortingAlgorithms;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = new int[] {10, 4, 1, 6, 3, 8, 2, 9};
        sort(arr);
        print(arr);
    }

    public static void sort(int arr[]) {
        int left = 0, right = arr.length - 1;
        quickSort(arr, left, right);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1,  right);
        }
    }

    private static int partition(int arr[], int left, int right) {
        int pivotValue = arr[right];
        int i = left - 1;

        for(int j = left; j <= right - 1; j++) {
            if(arr[j] < pivotValue) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i+1, right);
        return i+1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int arr[]) {
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
