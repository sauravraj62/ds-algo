package dataStructures.array;

import static dataStructures.array.ArrayUtils.printArray;

public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = new int[] {10, 1, 2, 3, 4, 5, 9, 13};
        reverse(arr);
        printArray(arr);
    }

    private static void reverse(int[] arr) {
        int n = arr.length;
        for(int i = 0;i < n/2; i++) {
            swap(arr, i, n - 1 - i);
        }
    }

    private static void swap(int arr[], int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
