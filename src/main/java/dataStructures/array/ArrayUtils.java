package dataStructures.array;

public class ArrayUtils {
    public static void printArray(int arr[]) {
        int n = arr.length;
        for(int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
