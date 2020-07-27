package dataStructures;

public class SymbolTable<Key extends Comparable<Key>, Value extends Comparable<Value>> {
	
	private final ResizingArray<Key> keyArray = new ResizingArray<Key>();
	private final ResizingArray<Value> valueArray = new ResizingArray<Value>();
	
	//put
	public void put(Key key, Value value) {
		int index = search(key);
		
		if (keyArray.getLength() == 0) {
			keyArray.put(key);
			valueArray.put(value);
		}
		//replace existing
		else if (index>=0 && keyArray.get(index) != null && keyArray.get(index).compareTo(key) == 0) {
			valueArray.put(index, value);
		}
		//shifting of elements to make space for new element
		else {
			int i=keyArray.getLength()-1;
			//shift last element
			keyArray.put(keyArray.get(i));
			valueArray.put(valueArray.get(i));
			
			while (i>index+1) {
				i--;
				keyArray.put(i+1, keyArray.get(i));
				valueArray.put(i+1, valueArray.get(i));
			}
			
			//insert element in the desired position
			keyArray.put(index+1, key);
			valueArray.put(index+1, value);
		}
	}
	
	//get
	public Value get(Key key) {
		int index = search(key);
		if (keyArray.get(index) != null && keyArray.get(index).compareTo(key) == 0) {
			return valueArray.get(index);
		}
		else {
			return null;
		}
	}
	
	//search
	private int search (Key key) {
		int left = 0;
		int right = keyArray.getLength();
		
		int index = search(key, left, right);
		
		return index;
	}

	private int search(Key key, int left, int right) {
			int mid = (left+right)/2;
			int index =-1;
		
			//Insert as first element
			if (right<0) {
				index = right;
			}
			else if (left>right) {
				index = mid;
			}
			else if (keyArray.get(mid) == null)  {
				index = mid-1;
			}
			//if element exists
			else if (keyArray.get(mid).compareTo(key) == 0){
				index = mid;
			}
			else if (keyArray.get(mid).compareTo(key) < 0) {
				index = search(key, mid+1, right);
			}
			else if (keyArray.get(mid).compareTo(key) > 0) {
				index = search(key, left, mid-1);
			}
			return index;
	}
	
	//TODO remove
	
	public static void main(String[] args) {
		SymbolTable<String, Integer> symTable = new SymbolTable<String, Integer>();
		symTable.put("Johny", 1);
		symTable.put("Thomas", 2);
		symTable.put("Kariath", 3);
		symTable.put("Johny", 4);
		symTable.put("Aptha", 5);
		symTable.put("Liza", 8);
		symTable.put("John", 6);
		symTable.put("Nyra", 7);
		
		System.out.println(symTable.get("Johny"));
		System.out.println(symTable.get("Thomas"));
		System.out.println(symTable.get("Kariath"));
		System.out.println(symTable.get("Liza"));
		System.out.println(symTable.get("John"));
		System.out.println(symTable.get("Aptha"));
		System.out.println(symTable.get("Nyra"));
	}
}
