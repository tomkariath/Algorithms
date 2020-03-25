package dataStructures;

public class LLStack {
	
	LinkedList<String> root;
	
	public void push(String element) {
		
		if(root == null) {
			root = new LinkedList<String>(element);
		}
		else {
			LinkedList<String> newNode = new LinkedList<String>(element, root);
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
		
		LinkedList<String> node = stack.root;
		
		while (node!=null) {
			System.out.println(node.element);
			node = node.nextNode;
		}
	}
}
