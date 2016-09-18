package coursera;

public class CanReach {

    static String canReach(int a, int b, int c, int d) {
        // System.out.println("a : " + a + ", b : " + b);
        // System.out.println("c : " + c + ", d : " + d);
        if (a == c && b == d) {
            return "Yes";
        }
        if (a > c || b > d) {
            return "No";
        }
        String canMoveLeft = canReach(a + b, b, c, d);
        String canMoveDown = canReach(a, a + b, c, d);
        if (canMoveLeft.equals("Yes") || canMoveDown.equals("Yes")) {
            return "Yes";
        } else {
            return "No";
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
