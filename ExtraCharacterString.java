//Leetcode Problem: 2707. Extra Characters in a String
public class ExtraCharacterString {
    public int minExtraChar(String s, String[] dictionary){
        int min =Integer.MAX_VALUE;
        for(String word: dictionary){
            int count = 0;
            int i = 0;
            int j = 0;
            while(i < s.length() && j < word.length()){
                if(s.charAt(i) == word.charAt(j)){
                    i++;
                    j++;
                }else{
                    count++;
                    i++;
                return min;
            }
        }
            if(j != word.length()){
                count += word.length() - j;
            }
            min = Math.min(min, count);
        }
    }
}