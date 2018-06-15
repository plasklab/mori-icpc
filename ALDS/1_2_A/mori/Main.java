import java.util.Scanner;
public class Main {
	int n;
	int list[];
	public static void main(String args[]) {
		new Main();
	}
	Main() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = scan.nextInt();
		}
		boolean flag = true;
		int cnt = 0;
		while (flag) {
			flag = false;
			for (int i = 1; i < n; i++) {
				if (list[i] < list[i-1]) {
					int tmp = list[i];
					list[i] = list[i-1];
					list[i-1] = tmp;
					cnt++;
					flag = true;
				}
			}
		}
		this.writeArray();
		System.out.println(cnt);
	}
	public void writeArray() {
		System.out.print(list[0]);
		for (int i = 1; i < n; i++) {
			System.out.print(" " + list[i]);
		}
		System.out.println();
	}
}
