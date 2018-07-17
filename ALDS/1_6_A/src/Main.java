import java.io.IOException;
import java.util.Scanner;

public class Main {
	int n;
	int max;
	int a[];
	int b[];
	int c[];
	static final int MAX_INT = 10000;
	public static void main(String args[]) throws IOException {
		new Main().run();
	}
	Main() throws IOException {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		a = new int[n];
		b = new int[n];
		c = new int[MAX_INT + 1];
		max = 0;
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
			max = Math.max(max, a[i]);
		}
	}
	void run() {
		for (int j = 0; j < n; j++) {
			c[a[j]]++;
		}
		for (int i = 1; i < max + 1; i++) {
			c[i] = c[i] + c[i-1];
		}
		for (int j = n - 1; j >= 0; j--) {
			b[c[a[j]] - 1] = a[j];
			c[a[j]]--;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append((i == 0? "" : " ") + b[i]);
		}
		System.out.println(sb);
	}
}