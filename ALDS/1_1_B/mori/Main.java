import java.util.Scanner;
public class Main {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		while(true){
			int rem = 0;
			if (x > y) {
				rem = x % y;
				x = rem;
				if (rem == 0) {
					System.out.println(y);
					return;
				}
			} else {
				rem = y % x;
				y = rem;
				if (rem == 0) {
					System.out.println(x);
					return;
				}
			}
		}
	}
}