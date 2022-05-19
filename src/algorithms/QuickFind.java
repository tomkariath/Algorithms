package algorithms;

public class QuickFind implements DisjointedSet {

    private static final int SIZE = 10;

    int[] root = new int[SIZE];

    QuickFind(){
        for (int i=0; i<SIZE; i++){
            root[i] = i;
        }
    }
    // 1-2-5-6-7 3-8-9 4

    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind();
        quickFind.connect(1,2);
        quickFind.connect(2,5);
        quickFind.connect(5,6);
        quickFind.connect(6,7);
        quickFind.connect(3,8);
        quickFind.connect(8,9);

        System.out.println(quickFind.isConnected(1, 5));
        System.out.println(quickFind.isConnected(5, 7));
        System.out.println(quickFind.isConnected(4, 9));
    }

    @Override
    public int getParent(int a) {
        return root[a];
    }

    @Override
    public void connect(int a, int b) {
        if (root[a] != root[b]){
            for (int i=0; i<SIZE; i++){
                if (root[i] == root[b]) {
                    root[i] = root[a];
                }
            }
        }
    }

    @Override
    public boolean isConnected(int a, int b) {
        return root[a] == root[b];
    }
}
