import java.util.HashMap;
import java.util.Scanner;

public class Main {
	int n;
	HashMap<String,String> dictionary;
	public static void main(String args[]) {
		new Main().run();
	}
	Main() {
		dictionary = new HashMap<String,String>();
	}
	public void run() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			String order = scan.next();
			String str = scan.next();
			if (order.charAt(0) == 'i') {
				dictionary.put(str, str);
			} else {
				if (dictionary.get(str) != null) { 
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			}
		}
	}
}
