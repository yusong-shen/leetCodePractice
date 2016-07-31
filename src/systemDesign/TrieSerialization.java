package systemDesign;
import java.util.*;

class TrieNode {
     public NavigableMap<Character, TrieNode> children;
     public TrieNode() {
         children = new TreeMap<Character, TrieNode>();
     }
}
 
public class TrieSerialization {

    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a trie which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TrieNode root) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        Iterator iter = root.children.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character ch = (Character) entry.getKey();
            TrieNode child = (TrieNode) entry.getValue();
            // DFS
            sb.append(ch);
            sb.append(serialize(child));
        }
        sb.append('>');
        // System.out.println(sb.toString());
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TrieNode deserialize(String data) {
        // Write your code here
        if (data == null || data.length() == 0) {
            return null;
        }
        // DFS
        TrieNode root = new TrieNode();
        TrieNode curr = root;
        Stack<TrieNode> stack = new Stack<TrieNode>();
        for (int i = 0; i < data.length(); i++) {
            Character ch = data.charAt(i);
            if (ch == '<') {
                stack.push(curr);
            } else if (ch == '>') {
                stack.pop();
            } else {
                curr = new TrieNode();
                stack.peek().children.put(ch, curr);
            }
            
        }
        return root;
    }

}
