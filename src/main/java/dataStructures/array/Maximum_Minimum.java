package dataStructures.array;

// Second maximum
public class Maximum_Minimum {
    public static void main(String[] args) {
        int arr[] = new int[] {10, 1, 2, 3, 4, 5, 9, 13};
        int arr1[] = new int[] {10, 1, 2, 3, 4, 5, 9, 13, 6};
        int arr2[] = new int[] {15, 15, 1, 2, 3, 4, 5, 9, 13};
        int arr3[] = new int[] {5, 5, 5, 5, 5, 5, 5, 5};
        int arr4[] = new int[] {1, 2, 3, 4, 5, 5};
        int arr5[] = new int[] {1, 2, 3, 4, 5, 5};
        int arr6[] = new int[] {1, 2, 2, 3};

        // 1, 2, 3, 4, 5, 5
        // FM, SM : 5
        // FM : 5, SM : 4
        secondUniqueMaximum(arr2);
        secondMaximum(arr2);
        secondUniqueMaximum(arr6);
    }

    private static void secondMaximum(int[] arr) {
        int n = arr.length;
        int current_maximum = Integer.MIN_VALUE;
        int second_current_maximum = Integer.MIN_VALUE;
        for(int x : arr) {
            if(x > current_maximum) {
                second_current_maximum = current_maximum;
                current_maximum = x;
            }
            else if(second_current_maximum <= x) {
                second_current_maximum = x;
            }
        }

        if(second_current_maximum == Integer.MIN_VALUE) {
            System.out.println("0");
        } else {
            System.out.println("Second Maximum : " + second_current_maximum);
        }
    }

    private static void secondUniqueMaximum(int[] arr) {
        int n = arr.length;
        int current_maximum = Integer.MIN_VALUE;
        int second_current_maximum = Integer.MIN_VALUE;
        for(int x : arr) {
            if(x > current_maximum) {
                second_current_maximum = current_maximum;
                current_maximum = x;
            }
            else if(second_current_maximum < x && x != current_maximum) {
                second_current_maximum = x;
            }
        }

        if(second_current_maximum == Integer.MIN_VALUE) {
            System.out.println("0");
        } else {
            System.out.println("Second Maximum : " + second_current_maximum);
        }
    }
}
