package algorithms;

import dataStructures.GraphNode;
import edu.princeton.cs.algs4.Stack;

/**
 * 1-2 4-6
 * | |/  |
 * 3-5---|
 *
 * 1
 * 2,3
 * 5
 * 4,6
 *
 * 1,3,5,6,4,2
 */

public class DepthFirstSearch {
    GraphNode rootNode;
    Stack<GraphNode> dfsStack;

    private void initGraph(){
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);
        GraphNode node6 = new GraphNode(6);

        node1.setConnections(node2, node3);
        node2.setConnections(node1, node5);
        node3.setConnections(node1, node5);
        node4.setConnections(node2, node5, node6);
        node5.setConnections(node2, node4, node6);
        node6.setConnections(node4, node5);

        this.rootNode = node1;
        this.dfsStack = new Stack<>();
    }

    void doBFSTraversal(){
        while (this.dfsStack.size() != 0){
            visitNode(this.dfsStack.pop());
        }
    }

    void visitNode(GraphNode node){
        for (GraphNode connectedNode : node.getConnections()){
            if (!connectedNode.isVisited() && !connectedNode.isQueued()){
                this.dfsStack.push(connectedNode);
                connectedNode.setQueued(true);
            }
        }

        node.setVisited(true);
        System.out.print(node.getNodeValue());
    }

    public static void main(String[] args) {
        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.initGraph();

        dfs.dfsStack.push(dfs.rootNode);
        dfs.doBFSTraversal();
    }
}
