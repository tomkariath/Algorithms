package dataStructures;

public class PriorityQueue<Item extends Comparable<Item>> extends LLQueue<Item>{
	
	@Override
	public void enqueue(Item element) {
		super.enqueue(element);
	}
	
	@Override
	public void dequeue() {
		if(head!=null) {
			if(head==tail) {
				tail=null;
				head=null;
			}
			else {
				dequeue(getSmallestElement());
			}
		}
	}
	
	private void dequeue(Item smallestElement) {
		if (head == tail) {
			head = tail = null;
		} else if (smallestElement == head.element) {
			head = head.nextNode;
		} else {
			Node<Item> previousNode = this.head;
			
			while(previousNode.getNextNode().element!=smallestElement) {
				previousNode = previousNode.getNextNode();
			}
			
			previousNode.setNextNode(previousNode.getNextNode().getNextNode());
		}
	}

	private Item getSmallestElement() {
		Node<Item> currentNode = this.head;
		Item smallest = currentNode.element;
		
		while(currentNode!=null) {
			if (smallest==null || smallest.compareTo(currentNode.element)>0) {
				smallest = currentNode.element;
			}
			currentNode = currentNode.getNextNode();
		}
		return smallest;
	}

	@Override
	public void process(String command) {
		super.process(command);
	}
	
	public static void main(String[] args) {

		PriorityQueue<String> queue = new PriorityQueue<String>();
		
		queue.process("-1-2-348-569-7-");

		for (String element : queue) {
			System.out.println(element);
		}
	
	}
}
