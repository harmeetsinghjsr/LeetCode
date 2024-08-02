import java.util.Scanner;

public class SubstringSize3DistinctChar {
    public int countGoodSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i + 1) != s.charAt(i + 2) && s.charAt(i) != s.charAt(i + 2)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        SubstringSize3DistinctChar obj = new SubstringSize3DistinctChar();
        System.out.println(obj.countGoodSubstrings(input));

        scanner.close();
    }
}