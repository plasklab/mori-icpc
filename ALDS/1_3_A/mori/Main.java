import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String args[]) {
		new Main().solve();
	}
	void solve() {
		Scanner scan = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		String[] strArray = scan.nextLine().split(" ");
		for (int i = 0; i < strArray.length; i++) {
			String str = strArray[i];
			int x,y;
			switch(str.charAt(0)) {
			case '+':
				y = stack.pop();
				x = stack.pop();
				stack.add(x + y);
				break;
			case '-':
				y = stack.pop();
				x = stack.pop();
				stack.add(x - y);
				break;
			case '*':
				y = stack.pop();
				x = stack.pop();
				stack.add(x * y);
				break;
			default:
				stack.add(Integer.parseInt(str));
				break;
			}
		}
		System.out.println(stack.pop());
	}
}
