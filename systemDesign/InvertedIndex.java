
public class InvertedIndex {

    /**
     * @param docs a list of documents
     * @return an inverted index
     */
    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        // Write your code here
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        // loop through each word in document
        for (Document doc : docs) {
            String[] words = doc.content.replaceAll("\\s+", " ").split(" ");
            for (String word : words) {
                List<Integer> ids = new ArrayList<Integer>();
                if (map.containsKey(word)) {
                    ids = map.get(word);
                }
                if (!ids.contains(doc.id)) {
                    ids.add(doc.id);
                }
                map.put(word, ids);
            }
        }
        
        return map;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
