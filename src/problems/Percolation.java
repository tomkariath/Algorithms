package problems;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private WeightedQuickUnionUF percolationMatrix;
    private int source;
    private int destination;
    private boolean[] openArray;
    private int max;
    private int openCount;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        if (n<=0) {
            throw new IllegalArgumentException("Enter non-zero positive values");
        }
        max=n;
        int matrixSize=n*n;
        openCount=0;
        percolationMatrix = new WeightedQuickUnionUF(matrixSize+2);
        source=matrixSize;
        destination=matrixSize+1;
        openArray = new boolean[matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            openArray[i]=false;
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
        int element = getElement(row,col);

        if(!isOpen(row,col)){
            openArray[element]=true;
            openCount++;
        }

        if(row==1){
            percolationMatrix.union(element, source);
        }
        else if (row==max){
            percolationMatrix.union(element, destination);
        }

        if (row!=1 && isOpen(row - 1, col)) {
            percolationMatrix.union(element, getElement(row - 1, col));
        }
        if (row!=max && isOpen(row + 1, col)) {
            percolationMatrix.union(element, getElement(row + 1, col));
        }
        if (col!=1 && isOpen(row, col - 1)) {
            percolationMatrix.union(element, getElement(row, col - 1));
        }
        if (col!=max && isOpen(row, col + 1)) {
            percolationMatrix.union(element, getElement(row, col + 1));
        }
    }

    //convert row and column to element in array
    private int getElement(int row, int col){
        return (((max)*(row-1))+(col-1));
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        return openArray[getElement(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        return (percolationMatrix.find(getElement(row, col))==percolationMatrix.find(source));
    }

    // returns the number of open sites
    public int numberOfOpenSites(){
        return openCount;
    }

    // does the system percolate?
    public boolean percolates(){
        return (percolationMatrix.find(source)==percolationMatrix.find(destination));
    }

    // test client (optional)
    public static void main(String[] args){
        int matrixSize=-1;
        Percolation trial = new Percolation(matrixSize);
       int row,col;
       while(!trial.percolates()){
           row= StdRandom.uniform(1,matrixSize+1);
           col=StdRandom.uniform(1,matrixSize+1);
           trial.open(row,col);
           System.out.println(row+" "+col);
       }

        System.out.println("Percolates "+ trial.numberOfOpenSites() + trial.percolates());
    }
}