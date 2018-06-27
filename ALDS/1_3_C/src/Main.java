import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	DoublyLinkedList first;
	DoublyLinkedList last;
	public static void main(String args[]) {
		new Main().run();
	}
	public void run() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		first = new DoublyLinkedList();
		last = first;
		try {
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				int num;
				if (line.charAt(0) == 'i') {
					num = Integer.parseInt(line.substring(7));
					insertHead(num);
				} else {
					switch(line.charAt(6)) {
					case ' ':
						num = Integer.parseInt(line.substring(7));
						deleteKey(num);
						break;
					case 'F':
						deleteFirst();
						break;
					case 'L':
						deleteLast();
						break;
					}
				}
			}
			printList();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.out.println(e);
		}
	}
	public void insertHead(int n) {
		DoublyLinkedList dll = new DoublyLinkedList(n);
		if (first.isGenerated()) {
			// 要素がゼロ個の場合
			first = dll;
			last = first;
		} else
		if (first == last) {
			// 要素が一つしかない場合
			dll.setNext(last);
			last.setBack(dll);
			first = dll;
		} else {
			// 要素が複数個ある場合
			dll.setNext(first);
			first.setBack(dll);
			first = dll;
		}
	}

	public void deleteKey(int n) {
		DoublyLinkedList dll = first;
		while (true) {
			if (dll.num == n) {
				if (dll == first) {
					// 先頭要素の場合
					deleteFirst();
				} else
				if (dll == last) {
					// 終端要素の場合
					deleteLast();
				} else {
					// 先頭でも最後でもない要素の場合
					dll.next.setBack(dll.back);
					dll.back.setNext(dll.next);
				}
				return;
			}
			if (dll  == last) {
				return;
			}
			dll = dll.next;
		}
	}
	public void deleteFirst() {
		if (first.next != null) {
			first.next.setBack(null);
			first = first.next;
		} else {
			// 要素が一つしかない場合
			first = new DoublyLinkedList();
			last = first;
		}

	}
	public void deleteLast() {
		if (last.back != null) {
			last.back.setNext(null);
			last = last.back;
		} else {
			// 要素が一つしかない場合
			last = new DoublyLinkedList();
			first = last;
		}
	}
	public void printList() {
		DoublyLinkedList dll = first;
		boolean flag = true;
		while (dll != null) {
			System.out.print((flag?"":" ") + dll.num);
			dll = dll.next;
			flag = false;
		}
		System.out.println();
	}
}

class DoublyLinkedList {
	int num;
	boolean exist;
	DoublyLinkedList next,back;
	DoublyLinkedList() {
		exist = false;
	}
	DoublyLinkedList(int n) {
		num = n;
		exist = true;
	}
	public boolean isGenerated() {
		return !exist;
	}
	public void setNext(DoublyLinkedList dll) {
		next = dll;
	}
	public void setBack(DoublyLinkedList dll) {
		back = dll;
	}
}