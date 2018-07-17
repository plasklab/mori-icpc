import java.util.Scanner;

public class Main {
	int n;
	public static void main(String args[]) {
		new Main().run();
	}
	Main() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
	}
	void run() {
		Node n1 = new Node(0,0);
		Node n2 = new Node(100,0);
		System.out.println(n1);
		koch(n1,n2,n);
		System.out.println(n2);
	}
	void koch(Node n1, Node n2,int depth) {
		if (depth == 0)
			return;
		double sx = (n1.x * 2 + n2.x) / 3;
		double sy = (n1.y * 2 + n2.y) / 3;
		Node s = new Node(sx,sy);
		double tx = (n1.x + n2.x * 2) / 3;
		double ty = (n1.y + n2.y * 2) / 3;
		Node t = new Node(tx,ty);
		double ux = (tx - sx) * Math.cos(Math.toRadians(60)) - (ty - sy) * Math.sin(Math.toRadians(60)) + s.x;
		double uy = (tx - sx) * Math.sin(Math.toRadians(60)) + (ty - sy) * Math.cos(Math.toRadians(60)) + s.y;
		Node u = new Node(ux,uy);
		koch(n1,s,depth-1);
		System.out.println(s);
		koch(s,u,depth-1);
		System.out.println(u);
		koch(u,t,depth-1);
		System.out.println(t);
		koch(t,n2,depth-1);
	}
}
class Node {
	double x,y;
	Node(double x,double y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return String.format("%.8f %.8f", this.x, this.y);
	}
}
