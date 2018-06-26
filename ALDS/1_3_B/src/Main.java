import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	int n,q;
	Queue<Process> process;
	public static void main(String args[]) {
		new Main().run();
	}
	Main() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		q = scan.nextInt();
		process = new ArrayDeque<Process>();
		for (int i = 0; i < n; i++) {
			Process p = new Process(scan.next(),scan.nextInt());
			process.add(p);
		}
	}
	void run() {
		int sumTime = 0;
		while (true) {
			Process p = process.poll();
			if (p == null) break;
			if (p.time > q) {
				p.time -= q;
				process.add(p);
				sumTime += q;
			} else if (p.time <= q) {
				sumTime += p.time;
				System.out.println(p.name + " " + sumTime);
			}
		}
	}
}
class Process {
	String name;
	int time;
	Process(String txt, int num) {
		name = txt;
		time = num;
	}
	public String toString() {
		return name + " : " + time;
	}
}