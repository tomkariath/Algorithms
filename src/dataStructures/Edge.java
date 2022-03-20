package dataStructures;

public class Edge implements Comparable<Edge>{
    private int start;
    private int end;

    private int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        if (weight > o.weight){
            return 1;
        }
        if (weight < o.weight){
            return -1;
        }
        return 0;
    }
}
