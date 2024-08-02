import java.util.*;

//Leetcode problem: 726. Number of Atoms
public class NumberOfAtoms {
    public static String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> currMap = new HashMap<>();
        int i = 0;
        
        while (i < formula.length()) {
            char c = formula.charAt(i);
            
            if (c == '(') {
                stack.push(currMap);
                currMap = new HashMap<>();
                i++;
            } else if (c == ')') {
                Map<String, Integer> tempMap = currMap;
                currMap = stack.pop();
                i++;
                
                int count = 0;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                
                count = count == 0 ? 1 : count;
                
                for (String key : tempMap.keySet()) {
                    currMap.put(key, currMap.getOrDefault(key, 0) + tempMap.get(key) * count);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                i++;
                
                while (i < formula.length() && Character.isLowerCase(formula.charAt(i))) {
                    sb.append(formula.charAt(i));
                    i++;
                }
                
                String element = sb.toString();
                
                int count = 0;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                
                count = count == 0 ? 1 : count;
                
                currMap.put(element, currMap.getOrDefault(element, 0) + count);
            }
        }
        
        StringBuilder result = new StringBuilder();
        List<String> elements = new ArrayList<>(currMap.keySet());
        Collections.sort(elements);
        
        for (String element : elements) {
            result.append(element);
            if (currMap.get(element) > 1) {
                result.append(currMap.get(element));
            }
        }
        
        return result.toString();
    }
    public static void main(String[] args) {
        String formula = "K4(ON(SO3)2)2";
        System.out.println(countOfAtoms(formula));
    }
}