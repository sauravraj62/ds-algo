package dataStructures.array;

// 1. Given Array sorted in increasing order array
// 2. There an element with frequency > n/2
// 3. Find that element

public class UnionIntersection {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 8};
        int arr2[] = {0, 1, 2, 3, 4, 5, 6, 7, 8};

        // union
        printUnion(arr1, arr2);
        // intersection
        printIntersection(arr1, arr2);
    }

    private static void printIntersection(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        int n1 = arr1.length, n2 = arr2.length;
        System.out.println("Intersection : ");
        while(i < n1 && j < n2) {
            if(arr1[i] < arr2[j]) {
                i++;
            } else if(arr1[i] > arr2[j]) {
                j++;
            } else {
                int temp = arr1[i];
                System.out.print(arr1[i] + " ");
                while(i < n1 && arr1[i] == temp) {
                    i++;
                }
                while(j < n2 && arr2[j] == temp) {
                    j++;
                }
            }
        }
    }

    private static void printUnion(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        int n1 = arr1.length, n2 = arr2.length;
        System.out.println("Union : ");
        while(i < n1 && j < n2) {
            if(arr1[i] < arr2[j]) {
                System.out.print(arr1[i] + " ");
                i++;
            } else if(arr1[i] > arr2[j]) {
                System.out.print(arr2[j] + " ");
                j++;
            } else {
                System.out.print(arr1[i] + " ");
                int temp = arr1[i];
                while(i < n1 && arr1[i] == temp) {
                    i++;
                }
                while(j < n2 && arr2[j] == temp) {
                    j++;
                }
            }
        }

        while(i < n1) {
            System.out.print(arr1[i++] + " ");
        }

        while(j < n2) {
            System.out.print(arr2[j++] + " ");
        }
    }
}
