import java.util.Scanner;

public class Main {
	int n;
	int w[];
	int k;
	public static void main(String args[]) {
		new Main().run();
	}
	Main() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		k = scan.nextInt();
		w = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = scan.nextInt();
		}
	}

	void run() {
		int left = 1;
		int right = 100000 * 10000;
		int p = Integer.MAX_VALUE;
		while(left < right) {
			int mid = (left + right) / 2;
			int cnt = 1;
			int sumWeight = 0;
			for (int i = 0; i < w.length; i++) {
				if (w[i] > mid) {
					cnt = Integer.MAX_VALUE;
					break;
				}
				sumWeight += w[i];
				if (sumWeight > mid) {
					sumWeight = w[i];
					cnt++;
				}
				if (cnt > k) {
					break;
				}
			}
			if (cnt <= k) {
				p = Math.min(p, mid);
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(p);
	}
}
