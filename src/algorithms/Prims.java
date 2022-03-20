package algorithms;

import dataStructures.Edge;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

public class Prims {
    static List<List<Integer>> graph = new ArrayList<>();
    static int size = 8;

    public static void main(String[] args) {
        fillVertices(graph, size);
        addDoubleEdge(graph, 0, 1, 10);
        addDoubleEdge(graph, 1, 4, 0);
        addDoubleEdge(graph, 4, 7, 8);
        addDoubleEdge(graph, 7, 6, 12);
        addDoubleEdge(graph, 6, 3, 7);
        addDoubleEdge(graph, 3, 0, 4);
        addDoubleEdge(graph, 0, 2, 1);
        addDoubleEdge(graph, 2, 5, 8);
        addDoubleEdge(graph, 5, 7, 9);
        addDoubleEdge(graph, 1, 2, 3);
        addDoubleEdge(graph, 2, 3, 2);
        addDoubleEdge(graph, 4, 5, 1);
        addDoubleEdge(graph, 5, 6, 6);
        addDoubleEdge(graph, 3, 5, 2);

        printGraph(graph, size);

        List<Edge> edges = getMST();

        for (Edge edge : edges){
            System.out.println(edge.getStart() +" "+ edge.getEnd() +" "+ edge.getWeight());
        }
    }

    private static List<Edge> getMST (){
        List<Edge> mstEdges = new ArrayList<>();
        PriorityBlockingQueue<Edge> queue = new PriorityBlockingQueue<>();
        List<Integer> visited = new ArrayList<>();

        visited.add(0);

        addEdgesToPriorityQueue(queue, visited, 0);

        while (queue.size() > 0 || mstEdges.size()==size){
            Edge edge = queue.poll();

            if (edge!=null && !visited.contains(edge.getEnd())){
                mstEdges.add(edge);
                visited.add(edge.getEnd());
                addEdgesToPriorityQueue(queue, visited, edge.getEnd());
            }
        }

        return mstEdges;
    }

    private static void addEdgesToPriorityQueue(PriorityBlockingQueue<Edge> queue, List<Integer> visited, int index){
        for (int i=0; i<size; i++){
            int weight = graph.get(index).get(i);
            if (weight!=-1 && !visited.contains(i)){
                queue.add(new Edge(index, i, weight));
            }
        }
    }

    private static void fillVertices(List<List<Integer>> graph, int size){
        for (int i=0; i<size; i++){
            graph.add(new ArrayList<>());
            for (int j=0; j<size; j++){
                graph.get(i).add(-1);
            }
        }
    }

    private static void addEdge(List<List<Integer>> graph, int start, int end, int weight){
        graph.get(start).set(end, weight);
    }

    private static void addDoubleEdge(List<List<Integer>> graph, int start, int end, int weight){
        addEdge(graph, start, end, weight);
        addEdge(graph, end, start, weight);
    }

    private static void printGraph(List<List<Integer>> graph, int size){
        for (int i=0; i<size; i++){
            System.out.print(i + " -> ");
            for (int j=0; j<size; j++){
                System.out.print(graph.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }
}
