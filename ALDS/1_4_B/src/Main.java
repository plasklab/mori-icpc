import java.util.Scanner;

public class Main {
	int n;
	int s[];
	int q;
	int t[];
	public static void main(String args[]) {
		new Main().run();
	}
	Main() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		s = new int[n];
		for (int i = 0; i < n; i++) {
			s[i] = scan.nextInt();
		}
		q = scan.nextInt();
		t = new int[n];
		for (int i = 0; i < q; i++) {
			t[i] = scan.nextInt();
		}
		scan.close();
	}
	public void run() {
		int cnt = 0;
		for (int j = 0; j < q; j++) {
			int left = 0;
			int right = n;
			while (left < right) {
				int mid = (left + right) / 2;
				if (s[mid] == t[j]) {
					cnt++;
					break;
				}
				if (s[mid] <= t[j]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
		}
		System.out.println(cnt);
	}
}
