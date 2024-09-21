import java.util.*;

public class binarySearch {
    public static int binary(int arr[], int key) {
        int start = 0;
        int last = (arr.length) - 1;
        
        while (start <= last) {
            int mid = (start + last) / 2;
            if (arr[start] == key) {
                return start;
            } else if (arr[last] == key) {
                return last;
            } else if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                last = mid - 1;
            } else if (arr[mid] < key) {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 5, 8, 9, 10, 13, 14 };
        int key = 1;
        int index = binary(arr, key);

        if (index == -1) {
            System.out.println("Key not found");
        } else {
            System.out.println("Key foud at index: " + index);
        }

    }
}
