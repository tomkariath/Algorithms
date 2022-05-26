package algorithms;

public interface DisjointedSet {
    int getRoot(int a);
    void connect(int a, int b);
    boolean isConnected (int a, int b);
}
