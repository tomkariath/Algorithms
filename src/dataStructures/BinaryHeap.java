package dataStructures;

public class BinaryHeap {

	ResizingArray heapArray = new ResizingArray();

	// insertion
	private void insert(String value) {
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
	private void deleteMax() {
		if (heapArray.getLength() == 0) {
			return;
		}
		swap(0, heapArray.getLength() - 1);
		heapArray.setLength(heapArray.getLength() - 1);

		// TODO sink logic
		if (getMaxChild(0) != -1 && heapArray.get(0).compareToIgnoreCase(heapArray.get(getMaxChild(0))) < 0) {
			sink(0);
		}
	}

	// sink
	private void sink(int index) {
		int maxChildIndex = getMaxChild(index);
		swap(index, maxChildIndex);
		index = maxChildIndex;
		if (getMaxChild(index) != -1
				&& heapArray.get(index).compareToIgnoreCase(heapArray.get(getMaxChild(index))) < 0) {
			sink(index);
		}
	}

	private int getMaxChild(int index) {
		int child1 = (index + 1) * 2;
		int child2 = ((index + 1) * 2) - 1;

		if (child1 < heapArray.getLength() - 1 && (child2 > heapArray.getLength()
				|| heapArray.get(child1).compareToIgnoreCase(heapArray.get(child2)) > 0)) {
			return child1;
		} else if (child2 < heapArray.getLength() - 1 && (child1 > heapArray.getLength()
				|| heapArray.get(child1).compareToIgnoreCase(heapArray.get(child2)) < 0)) {
			return child2;
		} else {
			return -1;
		}
	}

	// process
	private void process(String command) {
		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i) == '-') {
				this.deleteMax();
			} else {
				this.insert(Character.toString(command.charAt(i)));
			}
		}
	}

	// get Children

	@Override
	public String toString() {
		return heapArray.toString();
	}

	public static void main(String[] args) {
		BinaryHeap bHeap = new BinaryHeap();

		// bHeap.process("12345-");
		bHeap.process("-1-2-348-569-7-");

		System.out.println(bHeap);
	}

}
