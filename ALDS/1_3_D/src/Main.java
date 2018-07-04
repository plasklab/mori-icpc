import java.util.Scanner;
import java.util.Stack;

public class Main {
	String input;
	public static void main(String args[]) {
		new Main().run();
	}
	Main() {
		Scanner scan = new Scanner(System.in);
		input = scan.nextLine();
	}
	void run() {
		int len = input.length();
		Stack<Area> areaStack = new Stack<Area>();
		Stack<Integer> slash = new Stack<Integer>();
		for (int i = 0; i < len; i++) {
			switch(input.charAt(i)) {
			case '\\':
				slash.push(i);
				break;
			case '/':
				if (!slash.isEmpty()) {
					Area v = new Area(slash.pop(),i);
					while (!areaStack.isEmpty()) {
						Area latest = areaStack.pop();
						if (!v.isChild(latest)) {
							areaStack.push(latest);
							break;
						}
						v.addSize(latest.getSize());
					}
					areaStack.push(v);
				}
				break;
			case '_':
				break;
			}
		}
		int[] areaSize = new int[areaStack.size()];
		int sum = 0;
		for (int i = 0; i < areaSize.length; i++) {
			areaSize[i] = areaStack.pop().getSize();
			sum += areaSize[i];
		}
		System.out.println(sum);
		System.out.print(areaSize.length);
		for (int i = areaSize.length - 1; i >= 0; i--) {
			System.out.print(" " + areaSize[i]);
		}
		System.out.println();
	}
	class Area {
		private int left;
		private int right;
		private int size;
		Area() {
			left = 0;
			right = 0;
		}
		Area(int l,int r){
			left = l;
			right = r;
			size = right - left;
		}
		public void addSize(int i) {
			size += i;
		}
		public boolean isChild(Area area) {
			return left < area.getLeft() && right > area.getRight();
		}
		public int getLeft() {
			return left;
		}
		public int getRight() {
			return right;
		}
		public int getSize() {
			return size;
		}
	}
}
