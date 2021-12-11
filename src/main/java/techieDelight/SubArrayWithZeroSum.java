package techieDelight;

import java.util.HashSet;
import java.util.Set;

// Given an integer array, check if it contains a subarray having zero-sum.
public class SubArrayWithZeroSum {
    public static void main(String[] args) {
        int[] arr = new int[]{ 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };
        int[] arr1 = new int[]{ 1, 4, -4 };
        checkIfSubArrayWithZeroSumExist(arr);
        checkIfSubArrayWithZeroSumExist(arr1);
    }

    private static void checkIfSubArrayWithZeroSumExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int currentSum = 0;
        for(Integer integer : arr) {
            currentSum += integer;
            if(set.contains(currentSum)) {
                System.out.println("SubArray with zero sum found.");
                return;
            }
            set.add(integer);
        }
        System.out.println("SubArray with zero sum not found.");
    }
}
