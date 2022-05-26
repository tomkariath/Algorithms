package algorithms;

import dataStructures.Cell;

import java.util.*;

public class AStar {

    Cell[][] grid;
    int size;
    PriorityQueue<Cell> unvisited;
    List<Cell> blocked;
    boolean isTargetReached;

    public AStar(int size, List<Cell> blocked){
        unvisited = new PriorityQueue<>();
        this.size = size;
        grid = new Cell[size][size];
        this.blocked = blocked;
        isTargetReached = false;
    }

    public void process(Cell start, Cell target){
        int length = grid.length;
        List<Cell> neighbours = start.getNeighbours(length);
        start.setPreviousCell(null);

        for (Cell neighbour : neighbours) {
            if (blocked.contains(neighbour)){
                continue;
            }
            neighbour.setDistance(1, target);
            neighbour.setPreviousCell(start);
            unvisited.add(neighbour);
        }

        while(unvisited.size()>0 && !isTargetReached){
            Cell currentCell = unvisited.poll();
            neighbours = currentCell.getNeighbours(length);

            for (Cell neighbour : neighbours) {
                if (neighbour.equals(target)){
                    target.setPreviousCell(currentCell);
                    isTargetReached = true;
                }

                if (blocked.contains(neighbour)){
                    continue;
                }

                neighbour.setDistance(currentCell.getDistanceFromStart()+1, target);

                int needChange = unvisitedAndDistanceFromStartMore(neighbour);
                if (needChange == 1){
                    unvisited.remove(neighbour); //removes based on equals method
                    neighbour.setPreviousCell(currentCell);
                    unvisited.add(neighbour);
                } else if (needChange == -1) {
                    neighbour.setPreviousCell(currentCell);
                    unvisited.add(neighbour);
                }
            }
        }

        if (isTargetReached){
            Cell node = target;
            while (node != null) {
                System.out.println(node);
                node = node.getPreviousCell();
            }
        }
    }

    private int unvisitedAndDistanceFromStartMore(Cell neighbour){
        for (Cell cell : unvisited){
            if (cell.equals(neighbour)){
                if (cell.getDistanceFromStart() > neighbour.getDistanceFromStart()){
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Cell> blocked = List.of(new Cell(2,2), new Cell(1,1), new Cell(2,3));
        AStar astar = new AStar(4, blocked);

        astar.process(new Cell(0,0), new Cell(3,3));
    }
}
