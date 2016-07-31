public class Memcache {
    // key : [setTime, ttl, value]
    public HashMap<Integer, ArrayList<Integer>> map;


    public Memcache() {
        // Initialize your data structure here.
        this.map = new HashMap<Integer, ArrayList<Integer>>();
    }

    public int get(int curtTime, int key) {
        // Write your code here
        if (!map.containsKey(key)) {
            return Integer.MAX_VALUE;
        } else {
            ArrayList<Integer> values = map.get(key);
            // check if it is expired
            int setTime = values.get(0);
            int ttl = values.get(1);
            int value = values.get(2);
            // pinned to memory
            if (ttl == 0 || curtTime < setTime + ttl) {
                return value;
            }
            // expired
            return Integer.MAX_VALUE;
        }
    }

    public void set(int curtTime, int key, int value, int ttl) {
        // Write your code here
        ArrayList<Integer> values = new ArrayList<Integer>();
        values.add(curtTime);
        values.add(ttl);
        values.add(value);
        map.put(key, values);
    }

    public void delete(int curtTime, int key) {
        // Write your code here
        map.remove(key);
    }
    
    public int incr(int curtTime, int key, int delta) {
        // Write your code here
        if (!map.containsKey(key)) {
            return Integer.MAX_VALUE;
        } else {
            ArrayList<Integer> values = map.get(key);
            // check if it is expired
            int setTime = values.get(0);
            int ttl = values.get(1);
            int value = values.get(2);
            // pinned to memory  
            if (ttl == 0 || curtTime < setTime + ttl) {
                value += delta;
                values.remove(2);
                values.add(value);
                map.put(key, values);
                return value;
            }
            // expired
            return Integer.MAX_VALUE;
        }
    }

    public int decr(int curtTime, int key, int delta) {
        // Write your code here
        if (!map.containsKey(key)) {
            return Integer.MAX_VALUE;
        } else {
            ArrayList<Integer> values = map.get(key);
            // check if it is expired
            int setTime = values.get(0);
            int ttl = values.get(1);
            int value = values.get(2);
            // pinned to memory  
            if (ttl == 0 || curtTime < setTime + ttl) {
                value -= delta;
                values.remove(2);
                values.add(value);
                map.put(key, values);
                return value;
            }
            // expired
            return Integer.MAX_VALUE;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		get(1, 0);
//		>> 2147483647
		set(2, 1, 1, 2);
		get(3, 1);
//		>> 1
		get(4, 1);
//		>> 2147483647
		incr(5, 1, 1);
//		>> 2147483647
		set(6, 1, 3, 0);
		incr(7, 1, 1);
//		>> 4
		decr(8, 1, 1);
//		>> 3
		get(9, 1);
//		>> 3
		delete(10, 1);
		get(11, 1);
//		>> 2147483647
		incr(12, 1, 1);
//		>> 2147483647

	}
}