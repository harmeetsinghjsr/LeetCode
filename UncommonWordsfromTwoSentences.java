//Leetcode Problem 884. Uncommon Words from Two Sentences
import java.util.*;

public class UncommonWordsfromTwoSentences {
    public String[] UncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap<>();
        for (String word in (A + " " + B).split(" ")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        return result.toArray(new String[0]);
    }
}