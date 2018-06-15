import java.util.Scanner;
public class Main {
	int n;
	int[] array;
	public static void main(String args[]) {
		Main main = new Main();
	}
	Main() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scan.nextInt();
		}
		this.writeArray();
		for (int i = 1; i < n; i++) {
			int v = array[i];
			int j = i - 1;
			for(; j >= 0 && array[j] > v; j--) {
				array[j+1] = array[j];
			}
			array[j+1] = v;
			this.writeArray();
		}
	}
	public void writeArray() {
		for (int i = 0; i < n; i++) {
			if (i < n - 1)
				System.out.print(array[i] + " ");
			else
				System.out.println(array[i]);
		}
	}
}
