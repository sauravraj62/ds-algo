package algorithms.searchingAlgorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchInRotatedArray {
    public static void main(String[] args) {
        List<Integer> integerList1 = Arrays.asList(11, 12, 13, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> integerList2 = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 1);

        System.out.println("Searching in list 1");
        search(integerList1, 6);
        search(integerList1, 13);
        search(integerList1, 1);
        search(integerList1, 14);
        search(integerList1, 9);
        search(integerList1, 12);
        search(integerList1, 7);

        System.out.println("Searching in list 2");
        search(integerList2, 6);
        search(integerList2, 13);
        search(integerList2, 1);
        search(integerList2, 14);
        search(integerList2, 9);
        search(integerList2, 12);
        search(integerList2, 7);
    }

    public static void search(List<Integer> integerList, int data) {
        int left = 0, right = integerList.size() - 1;
        int index = -1;
        while(left <= right) {
            int mid = (left + right)/2;
            if(integerList.get(mid) == data) {
                index = mid;
                break;
            }
            if(integerList.get(left) <= integerList.get(mid)) {
                if(integerList.get(left) <= data && integerList.get(mid) >= data) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(integerList.get(right) >= data && integerList.get(mid) <= data) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        if(index != -1) {
            System.out.println(data + " found at index " + index);
        } else {
            System.out.println(data + " not found");
        }
    }
}
