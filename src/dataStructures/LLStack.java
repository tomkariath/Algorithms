package dataStructures;

public class LLStack {
	
	LinkedList root;
	
	public void push(String element) {
		
		if(root == null) {
			root = new LinkedList(element);
		}
		else {
			LinkedList newNode = new LinkedList(element, root);
			root = newNode;
		}
	}
	
	public void pop () {
		if(root!=null) {
			root = root.nextNode;
		}
	}
	
	public void process (String command) {
		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i)=='-') {
				this.pop();
			}
			else {
				this.push(String.valueOf(command.charAt(i)));
			}
		}
	}
	
	public static void main(String[] args) {
		LLStack stack = new LLStack();
		
		stack.process("-1-2-34-567");
		
		/*
		 * stack.push("1"); stack.push("2"); stack.push("3"); stack.push("4");
		 * stack.push("5"); stack.push("6"); stack.pop(); stack.pop(); stack.push("7");
		 * stack.pop();
		 */
		LinkedList node = stack.root;
		
		while (node!=null) {
			System.out.println(node.element);
			node = node.nextNode;
		}
	}
}
