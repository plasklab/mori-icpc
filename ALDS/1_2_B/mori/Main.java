import java.util.Scanner;
public class Main {
	int n,cnt;
	int[] ary;
	public static void main(String args[]) {
		new Main().run();
	}
	public void run() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		cnt = 0;
		ary = new int[n];
		for (int i = 0; i < n; i++) {
			ary[i] = scan.nextInt();
		}
		for (int i = 0; i < n; i++) {
			int minj = i;
			for (int j = i; j < n; j++) {
				if (ary[minj] > ary[j])
					minj = j;
			}
			if (i != minj) {
				int tmp = ary[i];
				ary[i] = ary[minj];
				ary[minj] = tmp;
				cnt++;
			}
		}
		writeArray();
		System.out.println(cnt);
	}
	public void writeArray() {
		System.out.print(ary[0]);
		for (int i = 1; i < n; i++) {
			System.out.print(" " + ary[i]);
		}
		System.out.println();
	}
}
