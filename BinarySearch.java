import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.print("BINARY SEARCH\n");
        Scanner in = new Scanner(System.in);

        System.out.println("ENTER THE NUMBER OF ELEMENTS:");
        int n = in.nextInt();
        int[] numbers = new int[n];

        System.out.println("ENTER THE INTEGER VALUES:");
        for (int i = 0; i < n; i++) {
            if (in.hasNextInt()) 
                numbers[i] = in.nextInt();
            else {
                System.out.println("Enter integer numbers only");
                return; // Exit gracefully
            }
        }

        // Sort the array for binary search
        Arrays.sort(numbers);

        System.out.println("ENTER THE KEY VALUE TO BE SEARCHED IN BINARY SEARCH LIST");
        int key = in.nextInt();

        // Call the BinarySearchIterative method
        int res = BinarySearchIterative(numbers, key);
        
        if (res == -1) {
            System.out.println(key + " IS NOT FOUND");
        } else {
            System.out.println(key + " FOUND IN THE ARRAY AT POSITION " + (res + 1));  // 1-based index
        }

        in.close();
    }

    // Binary search iterative method
    public static int BinarySearchIterative(int[] arr, int key) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // To avoid overflow

            if (arr[mid] == key) {
                return mid; // Element found
            } else if (arr[mid] < key) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return -1; // Element not found
    }
}
