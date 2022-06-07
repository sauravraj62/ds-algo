package algorithms.sortingAlgorithms;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = new int[] {10, 4, 1, 6, 3, 8, 2, 9};
        sort(arr);
        print(arr);
    }

    private static void sort(int[] arr) {
        int left = 0, right = arr.length - 1;
        mergeSort(arr, left, right);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int l1 = mid - left + 1;
        int l2 = right - mid;
        int leftSubArray[] = new int[l1];
        int rightSubArray[] = new int[l2];

        for(int i=0;i<l1;i++) {
            leftSubArray[i] = arr[left + i];
        }

        for(int i=0;i<l2;i++) {
            rightSubArray[i] = arr[mid + 1 + i];
        }

        int i=0, j=0, index=left;

        while(i<l1 && j<l2) {
            if(leftSubArray[i] < rightSubArray[j]) {
                arr[index] = leftSubArray[i];
                i++;
            } else {
                arr[index] = rightSubArray[j];
                j++;
            }
            index++;
        }

        while(i<l1) {
            arr[index++] = leftSubArray[i++];
        }

        while(j<l2) {
            arr[index++] = rightSubArray[j++];
        }
    }


    public static void print(int arr[]) {
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
