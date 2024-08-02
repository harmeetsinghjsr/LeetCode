//Problem 2037
//Leetcode Problem: https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/
import java.util.Arrays;
public class MinMovesToSeatEveryone {
    public static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        
        int moves = 0;
        for (int i = 0; i < students.length; i++) {
            moves += Math.abs(students[i] - seats[i]);
        }
        
        return moves;
    }
    public static void main(String[] args) {
        int[] seats = {1,4,5,9};
        int[] students = {1,2,3,9};
        System.out.println(minMovesToSeat(seats, students));
    }
}