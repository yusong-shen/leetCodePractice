package coursera;

import java.util.PriorityQueue;

public class ArrayReduction {

	public ArrayReduction() {
		// TODO Auto-generated constructor stub
	}
	
	public static int reductionCost(int[] num) {
		// num.length >= 2
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int totalCost = 0;
		for (int i = 0; i < num.length; i++) {
			pq.add(num[i]);
		}
		
		while (pq.size() > 1) {
			int num1 = pq.poll();
			int num2 = pq.poll();
			int cost = num1 + num2;
			totalCost += cost;
			pq.add(cost);
		}
		return totalCost;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// input : {1, 2, 3}
		// output : 9
		int[] num = {1, 2, 3};
		System.out.println(9 == reductionCost(num));
		num = new int[]{1, 7, 5, 8, 2};
		System.out.println(49 == reductionCost(num));
//		num = {1, 2, 3};
//		System.out.println(9 == reductionCost(num));
	}

}
