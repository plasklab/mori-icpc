import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Card[] card = new Card[n];
		for (int i = 0; i < n; i++) {
			String str = scan.next();
			char ch = str.charAt(0);
			char num = str.charAt(1);
			card[i] = new Card(num,ch);
		}
		// bubble sort
		Card[] bCard = Arrays.copyOf(card, card.length);
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 1; i < n; i++) {
				if (bCard[i].value < bCard[i-1].value) {
					Card tmp = bCard[i];
					bCard[i] = bCard[i-1];
					bCard[i-1] = tmp;
					flag = true;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print((i==0?"":" ") + bCard[i]);
		}
		System.out.println();
		System.out.println("Stable");

		// Selection sort
		Card[] sCard = Arrays.copyOf(card, card.length);
		for (int i = 0; i < n; i++) {
			int minj = i;
			for (int j = i; j < n; j++) {
				if (sCard[minj].value > sCard[j].value)
					minj = j;
			}
			if (i != minj) {
				Card tmp = sCard[i];
				sCard[i] = sCard[minj];
				sCard[minj] = tmp;
			}
		}
		boolean stable = true;
		for (int i = 0; i < n; i++) {
			System.out.print((i==0?"":" ") + sCard[i]);
			if (bCard[i] != sCard[i]) stable = false;
		}
		System.out.println();
		System.out.println(stable?"Stable":"Not stable");

	}
}

class Card {
	char value;
	char suit;
	Card(char value, char suit) {
		this.value = value;
		this.suit = suit;
	}
	public String toString() {
		return new String(suit + "" + value);
	}
}