//Leetcode Problem 476. Number Complement
public class NumberComplement {
    public int findComplement(int num) {
        int n = 0;
        while (n < num) {
            n = (n << 1) | 1;
        }
        return n - num;
    }   
}