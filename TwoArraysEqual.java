import java.util.Arrays;
public class TwoArraysEqual {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
    public static void main(String[] args) {
        TwoArraysEqual obj = new TwoArraysEqual();
        int[] target = {1, 2, 3, 4};
        int[] arr = {2, 4, 1, 3};
        System.out.println(obj.canBeEqual(target, arr));
    }
}