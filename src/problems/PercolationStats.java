package problems;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private double[] thresholdArray;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials){
        if (n<=0 || trials<=0){
            throw new IllegalArgumentException("Enter non-zero positive values");
        }

        thresholdArray = new double[trials];
        Percolation sim;
        int row,col;

        for (int i = 0; i < trials; i++) {
            sim = new Percolation(n);
            while(!sim.percolates()){
                row= StdRandom.uniform(1,n+1);
                col=StdRandom.uniform(1,n+1);
                sim.open(row,col);
            }
            thresholdArray[i] = (double) sim.numberOfOpenSites()/(n*n);
        }
    }

    // sample mean of percolation threshold
    public double mean(){
        return StdStats.mean(thresholdArray);
    }

    // sample standard deviation of percolation threshold
    public double stddev(){
        return StdStats.stddev(thresholdArray);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo(){
        return this.mean()-((1.96*this.stddev())/Math.sqrt(thresholdArray.length));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi(){
        return this.mean()+((1.96*this.stddev())/Math.sqrt(thresholdArray.length));
    }

    // test client (see below)
    public static void main(String[] args){
        int matrixSize= StdIn.readInt();
        int trials=StdIn.readInt();

        PercolationStats stats = new PercolationStats(matrixSize,trials);
        System.out.println("mean=\t"+stats.mean());
        System.out.println("stddev=\t"+stats.stddev());
        System.out.println("95% confidence interval=\t["+stats.confidenceLo()+", "+stats.confidenceHi()+"]");
    }
}