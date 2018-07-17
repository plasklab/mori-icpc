import java.util.HashMap;
import java.util.Scanner;

public class Main {
	int n;
	Card array[];
	HashMap<Card, Integer> map;
	public static void main(String args[]) {
		new Main().run();
	}
	Main() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		array = new Card[n];
		map = new HashMap<Card,Integer>();
		for (int i = 0; i < n; i++) {
			String a = scan.next();
			array[i] = new Card(a.charAt(0), scan.nextInt());
			map.put(array[i], i);
		}
	}
	void run() {
		quicksort(array,0,n);
		Card bef = array[0];
		boolean stable = true;
		for (int i = 1; i < n; i++) {
			if (bef.num == array[i].num) {
				if (map.get(bef) >= map.get(array[i])) {
					stable = false;
					break;
				}
			}
			bef = array[i];
		}
		System.out.println(stable?"Stable":"Not stable");
		for (int i = 0; i < n; i++) {
				System.out.println(array[i]);
		}
	}
	int partition(Card[] A, int p, int r) {
		int x = A[r-1].num;
		int i = p - 1;
		for (int j = p; j < r- 1; j++) {
			if (A[j].num <= x) {
				i++;
				Card tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
			}
 		}
		Card tmp = A[i+1];
		A[i+1] = A[r-1];
		A[r-1] = tmp;
		return i+1;
	}
	void quicksort(Card[] A, int p, int r) {
		if (p < r) {
			int q = partition(A,p,r);
			quicksort(A,p,q);
			quicksort(A,q+1,r);
		}
	}
	class Card {
		char suit;
		int num;
		Card before;
		Card(char a, int b) {
			suit = a;
			num = b;
		}
		public String toString() {
			return suit + " " + num;
		}
	}
}
