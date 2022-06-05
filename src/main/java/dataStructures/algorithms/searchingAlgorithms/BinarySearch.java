package dataStructures.algorithms.searchingAlgorithms;

import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(11, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Collections.sort(integerList);
        search(integerList, 6);
        search(integerList, 11);
        search(integerList, 1);
        search(integerList, 12);
    }

    public static void search(List<Integer> integerList, int data) {
        int left = 0, right = integerList.size() - 1;
        int index = -1;
        while(left <= right) {
            int mid = (left + right)/2;
            if(integerList.get(mid) == data) {
                index = mid;
                break;
            } else if (integerList.get(mid) < data) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if(index != -1) {
            System.out.println(data + " found at index " + index);
        } else {
            System.out.println(data + " not found");
        }
    }
}
