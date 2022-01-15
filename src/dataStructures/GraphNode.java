package dataStructures;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GraphNode {
    private int nodeValue;
    private List<GraphNode> connections;
    private boolean isVisited;
    private boolean isQueued;

    public GraphNode(int nodeValue){
        this.nodeValue = nodeValue;
        connections = new LinkedList<>();
    }

    public int getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(int nodeValue) {
        this.nodeValue = nodeValue;
    }

    public List<GraphNode> getConnections() {
        return connections;
    }

    public void setConnections(GraphNode... connectedNodes) {
        Collections.addAll(connections, connectedNodes);
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
}
