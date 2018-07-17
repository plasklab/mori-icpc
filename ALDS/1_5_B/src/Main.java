import java.util.Scanner;

public class Main {
	int n;
	int ary[];
	int cnt;
	public static void main(String args[]) {
		new Main().run();
	}

	Main() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		ary = new int[n];
		for (int i = 0; i < n; i++) {
			ary[i] = scan.nextInt();
		}
	}

	void run() {
		mergeSort(ary,0,n);
		for (int i = 0; i < n; i++) {
			System.out.print((i!=0?" ":"") + ary[i]);
		}
		System.out.println();
		System.out.println(cnt);
	}
	void mergeSort(int[] ary, int left, int right) {
		if (left + 1 < right) {
			int mid = (left + right ) / 2;
			mergeSort(ary, left, mid);
			mergeSort(ary, mid, right);
			merge(ary, left, mid, right);
		}
	}
	void merge(int[] ary, int left, int mid, int right) {
		int n1 = mid - left;
		int n2 = right - mid;
		int l[] = new int[n1+1];
		int r[] = new int[n2+1];
		for (int i = 0; i < n1; i++) {
			l[i] = ary[left + i];
		}
		for (int i = 0; i < n2; i++) {
			r[i] = ary[mid + i];
		}
		l[n1] = Integer.MAX_VALUE;
		r[n2] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		for (int k = left; k < right; k++) {
			if (l[i] <= r[j]) {
				ary[k] = l[i];
				i++;
			} else {
				ary[k] = r[j];
				j++;
			}
			cnt++;
		}
	}
}