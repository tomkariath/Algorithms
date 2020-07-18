package dataStructures;

public class BinaryHeap {

	private ResizingArray heapArray = new ResizingArray();
	
	public int getSize() {
		return heapArray.getLength();
	}

	// insertion
	public void insert(String value) {
		heapArray.put(value);
		if (heapArray.getLength() > 1 && value.compareToIgnoreCase(getParent(heapArray.getLength() - 1)) > 0) {
			swim(heapArray.getLength() - 1);
		}
	}

	// swim
	private void swim(int index) {
		swap(index, index / 2);
		index = index / 2;
		if (index > 0 && heapArray.get(index).compareToIgnoreCase(getParent(index)) > 0) {
			swim(index);
		}
	}

	private void swap(int firstIndex, int secondIndex) {
		String temp = heapArray.get(firstIndex);
		heapArray.put(firstIndex, heapArray.get(secondIndex));
		heapArray.put(secondIndex, temp);
	}

	// getParent
	private String getParent(int index) {
		return heapArray.get(index / 2);
	}

	// getMax
	public String getMax() {
		return heapArray.get(0);
	}

	// deleteMax
	public String deleteMax() {
		if (heapArray.getLength() == 0) {
			return null;
		}
		String max = getMax();
		swap(0, heapArray.getLength() - 1);
		heapArray.setLength(heapArray.getLength() - 1);

		int maxChild = getMaxChild(0);
		// sink logic
		if (maxChild != -1 && 
				heapArray.get(0).compareToIgnoreCase(heapArray.get(maxChild)) < 0) {
			sink(0, maxChild);
		}
		return max;
	}

	// sink
	private void sink(int index, int maxChild) {
		int maxChildIndex = maxChild;
		if (maxChildIndex!=-1) {
			swap(index, maxChildIndex);
		}
		
		index = maxChildIndex;
		maxChild = getMaxChild(index);
		if (maxChild != -1 && 
				heapArray.get(index).compareToIgnoreCase(heapArray.get(maxChild)) <= 0) {
			sink(index, maxChild);
		}
	}

	//get Child with Max value
	private int getMaxChild(int index) {
		int child1 = (index*2) + 1;
		int child2 = (index*2) + 2;

		/*
		 * System.out.println("Leangth "+heapArray.getLength() + child1 + child2);
		 * System.out.println(heapArray.get(child1) +"vs"+ heapArray.get(child2));
		 */
		if (child1 < heapArray.getLength() && (child2 > heapArray.getLength()
				|| heapArray.get(child1).compareToIgnoreCase(heapArray.get(child2)) >= 0)) {
			return child1;
		} else if (child2 < heapArray.getLength() && (child1 > heapArray.getLength()
				|| heapArray.get(child1).compareToIgnoreCase(heapArray.get(child2)) < 0)) {
			return child2;
		} else {
			return -1;
		}
	}

	// process
	public void process(String command) {
		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i) == '-') {
				this.deleteMax();
			} else {
				this.insert(Character.toString(command.charAt(i)));
			}
		}
	}

	@Override
	public String toString() {
		return heapArray.toString();
	}

	public static void main(String[] args) {
		BinaryHeap bHeap = new BinaryHeap();

		 //bHeap.process("12345--");
		bHeap.process("-1-2-348-569-7-");
		//bHeap.process("aruvilibertysong");

		System.out.println(bHeap);
		
		System.out.println("Size = "+ bHeap.getSize());
	}

}
