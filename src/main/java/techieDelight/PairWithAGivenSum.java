package techieDelight;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an unsorted integer array, find a pair with the given sum in it.
 */
public class PairWithAGivenSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5, 4};
        int[] arr1 = new int[]{1, 2, 3, 3, 4};
        int target = 6;

        printPairWithSum(arr, target);
        printPairWithSum(arr1, target);
    }

    private static void printPairWithSum(int[] arr, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            if(indexMap.containsKey(target - arr[i])) {
                System.out.println("Pair found : "+ i + " " + indexMap.get(target - arr[i]));
                return;
            }
            indexMap.put(arr[i], i);
        }
        System.out.println("No pair found");
    }
}
