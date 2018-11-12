package data_structures;

public class AddToLinkedList {
	public static void main(String [] args) {
		Node head = new Node(5);
		head.appendToTail(7);
		head.appendToTail(10);
		head.appendToTail(15);
		head.appendToTail(20);
		
		
		Node current = head;
		
		while(current.next != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
}

class Node{
	Node next = null;
	int data;
	
	public Node(int data) {
		this.data = data;
	}
	
	public void appendToTail(int data) {
		Node b = new Node(data);
		Node a = this;
		
		while(a.next != null) {
			a = a.next;
		}
		
		a.next = b;
	}
}
