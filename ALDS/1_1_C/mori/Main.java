import java.util.Scanner;
public class Main {
	int n;
	int list[];
	boolean sieve[];
	public static void main(String main[]) {
		new Main();
	}
	Main() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		list = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			list [i] = scan.nextInt();
			max = Math.max(max, list[i]);
		}
		sieve = new boolean[max + 1];
		int sqMax = (int)Math.round(Math.sqrt(max));
		for (int i = 2; i <= sqMax; i++) {
			if (sieve[i])continue;
			int j = 2;
			while (i * j < max + 1) {
				sieve[i * j] = true;
				j++;
			}
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (!sieve[list[i]]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
