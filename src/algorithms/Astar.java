package algorithms;

import dataStructures.Cell;

import java.util.*;

public class Astar {

    Cell[][] grid;
    int size;

    public Astar(int size){
        grid = new Cell[size][size];
    }

    public void process(Cell start, Cell target){
        int length = grid.length;
        List<Cell> neighbours = start.getNeighbours(length);
    }

    public static void main(String[] args) {
        PriorityQueue<Cell> set = new PriorityQueue<>();
        //SortedSet<Cell> set = new TreeSet<>();
        Cell a = new Cell(1,2);
        Cell b = new Cell(1,2);
        Cell c = new Cell(1,2);
        b.setDistance(10, new Cell(10,10));
        c.setDistance(13, new Cell(10,10));

        System.out.println(a.equals(b));

        set.add(a);
        set.remove(c);
        set.add(c);

        set.forEach(System.out::println);
    }
}
