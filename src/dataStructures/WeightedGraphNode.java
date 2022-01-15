package dataStructures;

import java.util.LinkedList;
import java.util.List;

public class WeightedGraphNode {

    private int nodeValue;
    private List<WeightedGraphNode> connections;
    private boolean isVisited;
    private boolean isQueued;
    private List<Edge> edges;

    public WeightedGraphNode(int nodeValue){
        this.nodeValue = nodeValue;
        edges = new LinkedList<>();
    }

    public int getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(int nodeValue) {
        this.nodeValue = nodeValue;
    }

    public List<WeightedGraphNode> getConnections() {
        return connections;
    }

    public void setConnections(List<WeightedGraphNode> connections) {
        this.connections = connections;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean isQueued() {
        return isQueued;
    }

    public void setQueued(boolean queued) {
        isQueued = queued;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public void setEdge(WeightedGraphNode node, int weight) {
        Edge edge1 = new Edge();
        edge1.connectionNode = node;
        edge1.weight = weight;
        this.edges.add(edge1);

        Edge edge2 = new Edge();
        edge2.connectionNode = this;
        edge2.weight = weight;
        node.edges.add(edge2);
    }

    public static class Edge {
        public WeightedGraphNode connectionNode;
        public int weight;
    }
}
