//Leetcode Problem 1813. Sentence Similarity III
public class SentenceSimilarityIII {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        if(s1.length == s2.length) {
            return sentence1.equals(sentence2);
        }
        if(s1.length > s2.length) {
            return check(s1, s2);
        }
        return check(s2, s1);
    }
    
    public boolean check(String[] s1, String[] s2) {
        int i = 0;
        int j = 0;
        while(i < s1.length && j < s2.length) {
            if(s1[i].equals(s2[j])) {
                i++;
                j++;
            } else {
                if(i == s1.length - 1) {
                    return s1[i].equals(s2[j]);
                }
                if(s1[i + 1].equals(s2[j])) {
                    i++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}