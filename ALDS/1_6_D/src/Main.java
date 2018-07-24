import java.util.Arrays;
import java.util.Scanner;

public class Main {
	int n, min, w[], sorted[];
	boolean checked[];
	public static void main(String args[]) {
		new Main().run();
	}
	Main() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		min = Integer.MAX_VALUE;
		w = new int[n];
		sorted = new int[n];
		checked = new boolean[n];
		for (int i = 0; i < n; i++) {
			w[i] = scan.nextInt();
			sorted[i] = w[i];
			min = Math.min(min,w[i]);
		}
		Arrays.sort(sorted);
	}
	void run() {
		int sumCost = 0;
		for (int i = 0; i < n; i++) {
			if (checked[i])continue;
			int trueIndex = getTrueIndex(w[i]);
			if (i == trueIndex) {
				checked[i] = true;
				continue;
			} else {
				int circleSize = 1;
				int num = w[i];
				int minInCircle = num;
				int cost = num;
				checked[i] = true;
				while(true) {
					minInCircle = Math.min(minInCircle, w[trueIndex]);
					cost += w[trueIndex];
					checked[trueIndex] = true;
					trueIndex = getTrueIndex(w[trueIndex]);
					circleSize++;
					if (num == w[trueIndex])
						break;
				}
				cost += Math.min((circleSize - 2) * minInCircle,(circleSize + 1) * min + minInCircle);
				sumCost += cost;
			}
		}
		System.out.println(sumCost);
	}
	int getTrueIndex(int num) {
		int i;
		for (i = 0; i < n; i++) {
			if(sorted[i] == num) {
				return i;
			}
		}
		// 該当なし
		return -1;
	}
}
