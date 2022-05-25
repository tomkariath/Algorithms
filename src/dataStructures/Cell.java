package dataStructures;

import java.util.LinkedList;
import java.util.List;

public class Cell implements Comparable<Cell>{
    int x;
    int y;

    int distanceFromTarget;
    int distanceFromStart;
    int totalDistance;

    boolean isVisited;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
    }

    void set(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setDistance(int distanceFromStart, Cell target){
        this.distanceFromStart = distanceFromStart;
        this.distanceFromTarget = getDiagonalDistance(x, y, target.x, target.y);
        this.totalDistance = this.distanceFromStart + this.distanceFromTarget;
    }

    private int getManhattanDistance(int cellX, int cellY, int targetX, int targetY){
        return Math.abs(targetX - cellX) + Math.abs(targetY - cellY);
    }

    private int getDiagonalDistance(int cellX, int cellY, int targetX, int targetY){
        int dx = Math.abs(targetX - cellX);
        int dy = Math.abs(targetY - cellY);

        return Math.max(dy, dx);
    }

    private int getEuclideanDistance(int cellX, int cellY, int targetX, int targetY){
        int dx = Math.abs(targetX - cellX);
        int dy = Math.abs(targetY - cellY);

        return (int) Math.pow(Math.pow(dx,2)+Math.pow(dy,2), 0.5);
    }

    public List<Cell> getNeighbours(int size){
        List<Cell> neighbours = new LinkedList<>();

        if (x==0){
            if(y==0){
                //bottom left corner
                neighbours.add(getNeighbourAtN(x,y));
                neighbours.add(getNeighbourAtNE(x,y));
                neighbours.add(getNeighbourAtE(x,y));
            }
            else if (y==size-1){
                //top left corner
                neighbours.add(getNeighbourAtS(x,y));
                neighbours.add(getNeighbourAtSE(x,y));
                neighbours.add(getNeighbourAtE(x,y));
            }
            else {
                //left edge
                neighbours.add(getNeighbourAtN(x,y));
                neighbours.add(getNeighbourAtNE(x,y));
                neighbours.add(getNeighbourAtE(x,y));
                neighbours.add(getNeighbourAtS(x,y));
                neighbours.add(getNeighbourAtSE(x,y));
            }
        }
        else if (y==0){
            if (x==size-1){
                //bottom right corner
                neighbours.add(getNeighbourAtN(x,y));
                neighbours.add(getNeighbourAtNW(x,y));
                neighbours.add(getNeighbourAtW(x,y));
            }
            else {
                //bottom edge
                neighbours.add(getNeighbourAtN(x,y));
                neighbours.add(getNeighbourAtNW(x,y));
                neighbours.add(getNeighbourAtW(x,y));
                neighbours.add(getNeighbourAtNE(x,y));
                neighbours.add(getNeighbourAtE(x,y));
            }
        }
        else if (x==size-1){
            if (y==size-1){
                //top right corner
                neighbours.add(getNeighbourAtS(x,y));
                neighbours.add(getNeighbourAtSW(x,y));
                neighbours.add(getNeighbourAtW(x,y));
            }
            else {
                //right edge;
                neighbours.add(getNeighbourAtS(x,y));
                neighbours.add(getNeighbourAtSW(x,y));
                neighbours.add(getNeighbourAtW(x,y));
                neighbours.add(getNeighbourAtN(x,y));
                neighbours.add(getNeighbourAtNW(x,y));
            }
        }
        else if (y==size-1){
            //top edge
            neighbours.add(getNeighbourAtS(x,y));
            neighbours.add(getNeighbourAtSW(x,y));
            neighbours.add(getNeighbourAtSE(x,y));
            neighbours.add(getNeighbourAtW(x,y));
            neighbours.add(getNeighbourAtE(x,y));
        }
        else {
            neighbours.add(getNeighbourAtS(x,y));
            neighbours.add(getNeighbourAtW(x,y));
            neighbours.add(getNeighbourAtE(x,y));
            neighbours.add(getNeighbourAtN(x,y));
            neighbours.add(getNeighbourAtNE(x,y));
            neighbours.add(getNeighbourAtNW(x,y));
            neighbours.add(getNeighbourAtSE(x,y));
            neighbours.add(getNeighbourAtSW(x,y));
        }

        return neighbours;
    }

    private Cell getNeighbourAtN(int x, int y){
        return new Cell(x, y+1);
    }
    private Cell getNeighbourAtNE(int x, int y){
        return new Cell(x+1, y+1);
    }
    private Cell getNeighbourAtNW(int x, int y){
        return new Cell(x-1, y+1);
    }
    private Cell getNeighbourAtW(int x, int y){
        return new Cell(x-1, y);
    }
    private Cell getNeighbourAtE(int x, int y){
        return new Cell(x+1, y);
    }
    private Cell getNeighbourAtS(int x, int y){
        return new Cell(x, y-1);
    }
    private Cell getNeighbourAtSE(int x, int y){
        return new Cell(x+1, y-1);
    }
    private Cell getNeighbourAtSW(int x, int y){
        return new Cell(x-1, y-1);
    }

    @Override
    public int compareTo(Cell cell) {
        if (totalDistance > cell.totalDistance){
            return 1;
        }
        else if (totalDistance < cell.totalDistance){
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }

        if (!(obj instanceof Cell cell)){
            return false;
        }

        return x==cell.x && y== cell.y;
    }

    @Override
    public String toString() {
        return "x:"+x+" y:"+y+" distance:"+totalDistance;
    }
}