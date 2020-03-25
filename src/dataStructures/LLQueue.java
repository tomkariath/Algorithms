package dataStructures;

public class LLQueue {
	
	LinkedList head, tail;
	
	public void enqueue(String element) {
		if (head==null && tail==null) {
			head = new LinkedList(element);
			tail = head;
		}
		else {
			LinkedList newNode = new LinkedList(element);
			if (head!=tail) {
				tail.nextNode=newNode;
				tail=newNode;
			}
			else {
				tail=newNode;
				head.nextNode=tail;
			}
		}
	}
	
	public void dequeue() {
		if(head!=null) {
			if(head==tail) {
				tail=null;
				head=null;
			}
			else {
				head = head.nextNode;
			}
		}
	}
	
	public void process (String command) {
		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i)=='-') {
				this.dequeue();
			}
			else {
				this.enqueue(String.valueOf(command.charAt(i)));
			}
		}
	}
	
	public static void main(String[] args) {
		LLQueue queue = new LLQueue();
		
		queue.process("-1-2-348-569-7");
		LinkedList node = queue.head;
		
		while (node!=null) {
			System.out.println(node.element);
			node = node.nextNode;
		}
	}
}
