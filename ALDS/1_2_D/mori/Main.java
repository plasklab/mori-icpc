import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	int cnt;
	int n;
	int m;
	int array[];
	ArrayList<Integer> g;
	public static void main(String args[]) {
		Main m = new Main();
		m.shellSort();
		m.printAnswer();
	}
	public Main() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scan.nextInt();
		}
		g = new ArrayList<Integer>();
	}
	public void printAnswer() {
		System.out.println(g.size());
		for(int i = 0; i < g.size(); i++) {
			System.out.print((i == 0?"":" ") + g.get(i));
		}
		System.out.println();
		System.out.println(cnt);

		for(int i = 0; i < n; i++) {
			System.out.print((i == 0?"":"\n") + array[i]);
		}
	}
	public void insertionSort(int g) {
		for (int i  = g; i < n; i++) {
			int v = array[i];
			int j = i;
			while (j >= g && array[j - g] > v){
				array[j] = array[j - g];
				j -= g;
				cnt++;
			}
			array[j] = v;
		}
	}
	public void shellSort() {
		cnt = 0;
		m = 0;
		while(true){
			int tm = m * 3 + 1;
			if (m > n / 9) break;
			m = tm;
		}
		while (m > 0) {
			insertionSort(m);
			g.add(m);
			m /= 3;
		}
	}
}
