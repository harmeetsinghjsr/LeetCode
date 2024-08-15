//Leetcode problem :860. Lemonade Change
public class LemonadeChallenge {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        LemonadeChallenge obj = new LemonadeChallenge();
        int[] bills = {5,5,5,10,20};
        System.out.println(obj.lemonadeChange(bills));
    }
}
