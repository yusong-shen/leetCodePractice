package coursera;

import java.util.*;

public class ComputingGroups {

    private static int n;
	private static int m;
    // group id : group size
	private static HashMap<Integer, Integer> map = new HashMap<>();
    
    public static void dfs(int[][] grid, int i, int j, int id) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return ;
        }
        if (grid[i][j] == 1) {
            // mark it as visited with group id
            // System.out.println("island!");
            grid[i][j] = id;
            dfs(grid, i - 1, j, id);
            dfs(grid, i + 1, j, id);
            dfs(grid, i, j - 1, id);
            dfs(grid, i, j + 1, id);
        }
    }
    
    public static int numIslands(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        n = grid.length;
        if (n == 0) {
            return 0;
        }
        m = grid[0].length;
        if (m == 0) {
            return 0;
        }

        int result = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    // search
                    dfs(grid, i, j, result + 2);
                    result++;
                }
            }
        }
        
         for (int i = 0; i < grid.length; i++) {
             for (int j = 0; j < grid[i].length; j++) {
                 System.out.print(grid[i][j] + " ");
                 if (grid[i][j] != 0 && !map.containsKey(grid[i][j])) {
                	 map.put(grid[i][j], 1);
                 } else if (grid[i][j] != 0 && map.containsKey(grid[i][j])) {
                	 int curSize = map.get(grid[i][j]);
                	 map.put(grid[i][j], curSize + 1);
                 }
             }
             System.out.println("");
         }
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {
				{1, 1, 0, 0, 0},
				{1, 1, 0, 0, 0},
				{0, 0, 1, 0, 0},
				{0, 0, 0, 1, 1}
		};
		System.out.println(3 == numIslands(grid));
		
		// iterate hashmap
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			System.out.format("Group id is %d, group size is %d\n", key, value);
		}
	}

}
