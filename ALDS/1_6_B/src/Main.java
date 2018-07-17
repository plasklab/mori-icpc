import java.util.Scanner;

public class Main {

	int n;
	int array[];
	public static void main(String args[]) {
		new Main().run();
	}
	Main() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scan.nextInt();
		}
	}
	void run() {
		int p = partition(array,0,n);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (p == i)
				sb.append((i==0?"":" ") + "[" + array[i] + "]");
			else 
				sb.append((i==0?"":" ") + array[i]);
		}
		System.out.println(sb);
	}
	int partition(int[] A, int p, int r) {
		int x = A[r-1];
		int i = p - 1;
		for (int j = p; j < r- 1; j++) {
			if (A[j] <= x) {
				i++;
				int tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
			}
 		}
		int tmp = A[i+1];
		A[i+1] = A[r-1];
		A[r-1] = tmp;
		return i+1;
	}
}
