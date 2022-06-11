package dataStructures.hashing;

import java.util.HashMap;

// Find indexes of two pairs for which sum is 'target'
public class TwoSum {
    public static void main(String[] args) {
        int arr[]  = new int[] {5, 3, 7, 1, 9, 6, 3, 3};
        // 1, 3, 3, 3, 5, 6, 7, 9
        // Binary search : n * log(n) = nlog(n)

        // Two pointer solution : i = 0, j = 7
        int target = 6;
        printPairsForTargetSum(arr, target);
    }

    private static void printPairsForTargetSum(int[] arr, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < arr.length ; i++) {
            int remainingSum = target - arr[i];
            if(indexMap.containsKey(remainingSum)) {
                System.out.println("Pair found at indexes : " + i + " " + indexMap.get(remainingSum));
            }
            indexMap.put(arr[i], i);
        }
    }
}

