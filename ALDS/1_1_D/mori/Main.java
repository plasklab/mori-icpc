import java.util.Scanner;
public class Main {
	int n;
	int[] r;
	public static void main(String args[]) {
		new Main();
	}
	Main() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		r = new int[n];
		for (int i = 0; i < n; i++) {
			r[i] = scan.nextInt();
		}
		int min = r[0];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < n; i++) {
			max = Math.max(max, r[i] - min);
			min = Math.min(r[i],min);
		}
		System.out.println(max);
	}
}
