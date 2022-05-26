package algorithms;

class DisjointedSetQuickUnion implements DisjointedSet{
    private final int[] root;

    public DisjointedSetQuickUnion(int size) {
        root = new int[size];
        for (int i=0; i<size; i++){
            root[i] = i;
        }
    }

    public int getRoot(int a) {
        if (a == root[a]){
            return a;
        }
        return root[a] = getRoot(root[a]);
    }

    public void connect(int x, int y) {
        int rootX = getRoot(x);
        int rootY = getRoot(y);

        if (rootY != rootX){
            root[rootY] = rootX;
        }
    }

    public boolean isConnected(int x, int y) {
        return getRoot(x) == getRoot(y);
    }

    public static void main(String[] args) {
        DisjointedSetQuickUnion uf = new DisjointedSetQuickUnion(10);
        // 1-2-5-6-7 3-8-9 4
        uf.connect(1, 2);
        uf.connect(2, 5);
        uf.connect(5, 6);
        uf.connect(6, 7);
        uf.connect(3, 8);
        uf.connect(8, 9);
        System.out.println(uf.isConnected(1, 5)); // true
        System.out.println(uf.isConnected(5, 7)); // true
        System.out.println(uf.isConnected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.connect(9, 4);
        System.out.println(uf.isConnected(4, 9)); // true
        uf.connect(5,8);
        System.out.println(uf.getRoot(4));
    }
}
