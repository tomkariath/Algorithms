package algorithms;

public interface DisjointedSet {
    int getParent(int a);
    void connect(int a, int b);
    boolean isConnected (int a, int b);
}
