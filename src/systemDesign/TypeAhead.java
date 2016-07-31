package systemDesign;
import java.util.*;

public class TypeAhead {
    public HashMap<String, List<String>> map;
    // @param dict A dictionary of words dict
    public TypeAhead(Set<String> dict) {
        // do initialize if necessary
        this.map = new HashMap<>();
        
        for (String word : dict) {
            int len = word.length();
            for (int i = 0; i < len; i++) {
                for (int j = i; j <= len; j++) {
                    String sub = word.substring(i, j);
                    // System.out.println(sub);
                    List<String> words = new ArrayList<String>();
                    if (!map.containsKey(sub)) {
                        words.add(word);
                        map.put(sub, words);
                    } else {
                        words = map.get(sub);
                        if (!words.contains(word)) {
                            words.add(word);
                        }
                        map.put(sub, words);
                    }
                }
                
            }
            
        }
        
    }

    // @param str: a string
    // @return a list of words
    public List<String> search(String str) {
        // Write your code here
        List<String> result = new ArrayList<String>();
        if (map.containsKey(str)) {
            result = map.get(str);
        }
        
        return result;
    }
}
