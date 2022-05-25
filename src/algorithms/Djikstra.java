package algorithms;

import java.util.*;

public class Djikstra {

    Map<Integer, int[]> graph;
    boolean[] visited;
    Queue<Integer> unvisited;

    int[]  minCost;
    int[] fromNode;

    Djikstra(Map<Integer, int[]> graph){
        this.graph = graph;
        int size = graph.size();
        visited = new boolean[size];
        unvisited = new PriorityQueue<>();

        minCost = new int[size];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        fromNode = new int[size];

        unvisited.add(0);
        minCost[0] = 0;
        fromNode[0] = -1;
    }

    public void process (){
        while (unvisited.size() != 0){
            int key = unvisited.poll();
            if(!visited[key]){
                int[] costArray = graph.get(key);
                for (int i=0; i<costArray.length; i++){
                    if (i == key){
                        continue;
                    }

                    if(costArray[i]<Integer.MAX_VALUE){
                        unvisited.add(i);

                        int actualCost = minCost[key]+costArray[i];
                        if (actualCost<minCost[i]){
                            minCost[i] = actualCost;
                            fromNode[i] = key;
                        }
                    }
                }
            }
        }
    }

    public void printMinCostWithPath(){
        for (int i=0; i<minCost.length; i++){
            System.out.println("Node:"+i+" Cost:"+minCost[i]+" previousNode:"+fromNode[i]);
        }
    }

    public void getShortestPath(int start, int finish){
        Stack<Integer> path = new Stack<>();

        int node = finish;
        while (node!=start){
            path.push(node);
            node = fromNode[node];
        }
        path.push(start);

        while(path.size() != 1){
            System.out.print(path.pop()+"->");
        }
        System.out.println(path.pop());
    }

    public static void main(String[] args) {
        Map<Integer, int[]> graph = new HashMap<>();

        graph.put(0, new int[]{0,1,5,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE});
        graph.put(1, new int[]{Integer.MAX_VALUE,0,2,2,1,Integer.MAX_VALUE});
        graph.put(2, new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,0,Integer.MAX_VALUE,2,Integer.MAX_VALUE});
        graph.put(3, new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0,3,1});
        graph.put(4, new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0,2});
        graph.put(5, new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0});

        Djikstra djikstra = new Djikstra(graph);
        djikstra.process();
        djikstra.printMinCostWithPath();
        djikstra.getShortestPath(0,5);
    }
}
