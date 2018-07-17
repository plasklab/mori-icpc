import java.util.Scanner;

public class Main {
	int n;
	int array[];
	int q;
	int m[];
	Scanner scan;
	public static void main(String args[]) {
		new Main().run();
	}
	Main() {
		scan = new Scanner(System.in);
		n = scan.nextInt();
		array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scan.nextInt();
		}

	}

	void run() {
		boolean ans[] = new boolean[2 << n];
		for (int i = 0; i < 2 << n; i++) {
			boolean bits[] = toBoolean(i);
			int num = 0;
			for (int j = 0; j < n; j++) {
				if (bits[j]) {
					num += array[j];
				}
			}
			ans[num] = true;
		}
		q = scan.nextInt();
		for (int i = 0; i < q; i++) {
			int m = scan.nextInt();
			if (m < ans.length && ans[m]) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

	boolean[] toBoolean(int num) {
		boolean[] bits = new boolean[n];
		for (int i = 0; i < n; i ++) {
			bits[i] = (num & 1) == 1;
			num = num >>> 1;
		}
		return bits;
	}
}
