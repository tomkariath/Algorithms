package dataStructures;

public class SeperateChainingHashTable<Key, Value> {
	
	private static class Node {
		public Node(Object key, Object value) {
			this.key = key;
			this.value = value;
			next = null;
		}

		Object key;
		Object value;
		
		Node next;
	}
	
	private int size = 13;
	Node[] table = new Node[size];
	
	private int getHash(Key key) {
		return (key.hashCode() & 0x7fffffff) % size;
	}
	
	public void insert (Key key, Value value) {
		int hash = getHash(key);

		Node x = table[hash];
		for (; x!=null; x = x.next) {
			if (x.key.equals(key)) {
				x.value = value;
				return;
			}
		}
		table[hash] = new Node(key, value);
	}
	
	@SuppressWarnings("unchecked")
	public Value find (Key key) {
		int hash = getHash(key);
		
		for (Node x = table[hash]; x!=null; x = x.next) {
			if (x.key.equals(key)) {
				return (Value) x.value;
			}
		}
		
		return null;
	}
	
	public void delete(Key key) {
		int hash = getHash(key);
		
		for (Node x = table[hash]; x!=null; x = x.next) {
			if (x.key.equals(key)) {
				table[hash] = null;
				return;
			}
			if (x.next.key.equals(key)) {
				x.next = x.next.next;
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		SeperateChainingHashTable<Integer, String> ht 
			= new SeperateChainingHashTable<Integer, String>();
		
		ht.insert(5, "Omanichumma");
		ht.insert(1, "Pokkiri Song");
		ht.insert(4, "Mambazhakalam");
		
		System.out.println(ht.find(1));
		ht.delete(1);
		System.out.println(ht.find(1));
	}
}
