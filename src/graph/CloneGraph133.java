package graph;

import java.util.HashMap;
import java.util.Map;

import library.UndirectedGraphNode;

public class CloneGraph133 {
	/**
	 * Definition for undirected graph.
	 * class UndirectedGraphNode {
	 *     int label;
	 *     List<UndirectedGraphNode> neighbors;
	 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	 * };
	 */
	
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if (node == null) return null;
    	Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		return dfs(node, map);
        
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode graph, 
    		Map<UndirectedGraphNode, UndirectedGraphNode> map ){
    	// since graph may consist cycle, we use a hash map to track every node we visited
    	if (map.containsKey(graph)){
    		return map.get(graph);
    	} 
    	UndirectedGraphNode graphCopy = new UndirectedGraphNode(graph.label);
    	map.put(graph, graphCopy);
    	// DFS by recursion
    	for (UndirectedGraphNode neighbor : graph.neighbors){
    		graphCopy.neighbors.add(dfs(neighbor, map));
    	}
		return graphCopy;
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
