package com.moonheart.algs4.exercise.chapter1.subchapter2;

import edu.princeton.cs.algs4.*;
import java.lang.Math;

public class Ex01 {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        Point2D[] pa = new Point2D[n];
        //generate the 2d points
        for(int i=0; i<n; i++) {
            double x = StdRandom.uniform();
            double y = StdRandom.uniform();
            pa[i] = new Point2D(x, y);
        }

        //compute the closest distance between points
        double dist = Double.MAX_VALUE;
        for(int j=0; j<n; j++) {
            for(int k=j+1; k<n; k++) {
                double d = pa[j].distanceTo(pa[k]);
                if(dist > d) dist = d;
            }
        }
        StdOut.println("The smaller distance is: " + dist);

    }

    
}
