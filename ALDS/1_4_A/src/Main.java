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
			for (int i = 0; i < n; i++) {
				if(s[i] == t[j]) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
