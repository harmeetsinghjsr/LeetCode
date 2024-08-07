import java.util.Scanner;

public class ValidMountainArray {
    public static boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false;
        }
        int i = 0;
        while (i+1<n && arr[i]<arr[i+1]) {
            i++;
        }
        if (i==0 || i == n-1) {
            return false;
        }
        while (i+1<n && arr[i]>arr[i+1]) {
            i++;
        }
        return i == n - 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(validMountainArray(arr));
        sc.close();
    }
}