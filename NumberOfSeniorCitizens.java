//Leetcode probelm 2678. Number of Senior Citizens
public class NumberOfSeniorCitizens {
    public int countSeniorCitizens(String[] details) {
        int count = 0;
        for (String detail : details) {
            int age = Integer.parseInt(detail.substring(11, 13));
            if (age > 60) {
                count++;
            }
        }
        return count;
    }
}