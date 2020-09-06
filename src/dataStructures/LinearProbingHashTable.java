package dataStructures;

public class LinearProbingHashTable<Key, Value> {

	int size = 13;
	Object[] keys = new Object[size];
	Object[] values = new Object[size];
	boolean[] deleted = new boolean[size];

	private int getHash(Key key) {
		return (key.hashCode() & 0x7fffffff) % size;
	}

	public void insert(Key key, Value value) {
		int i = getHash(key);

		for (; keys[i] != null && deleted[i] == false; i++) {
			if (keys[i] == key) {
				values[i] = value;
				return;
			}
		}

		if (deleted[i]) {
			deleted[i]=false;
		}
		keys[i] = key;
		values[i] = value;
	}

	@SuppressWarnings("unchecked")
	public Value find(Key key) {
		int i = getHash(key);

		for (; keys[i] != null && deleted[i] == false; i++) {
			if (keys[i].equals(key)) {
				return (Value) values[i];
			}
		}

		return null;
	}

	public void delete(Key key) {
		int i = getHash(key);

		for (; keys[i] != null; i++) {
			if (keys[i].equals(key)) {
				keys[i] = null;
				values[i] = null;
				deleted[i] = true;
			}
		}
	}

	public static void main(String[] args) {
		LinearProbingHashTable<Integer, String> ht = new LinearProbingHashTable<Integer, String>();

		ht.insert(3, "Ennalakalle");
		ht.insert(2, "Freak Penne");
		ht.insert(4, "Aanakkallan");

		System.out.println(ht.find(2));
		ht.delete(2);
		System.out.println(ht.find(2));
		ht.insert(2, "Freak Penne");
	}

}
