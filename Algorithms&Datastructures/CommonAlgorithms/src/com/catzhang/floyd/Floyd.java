package com.catzhang.floyd;

import java.util.Arrays;

/**
 * @author: crazycatzhang
 * @date: 2020/8/8 9:58 AM
 * @description: Solve the shortest path problem through Floyd algorithm
 */
public class Floyd {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[]{0, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, 0, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, 0, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, 0, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, 0, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, 0, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, 0};
        Graph graph = new Graph(vertex, matrix);
        graph.floyd();
        graph.show();
    }
}

//Creat Graph
class Graph {
    private char[] vertex;
    private int[][] matrix;
    private int[][] preVertex;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
        this.preVertex = new int[this.vertex.length][this.vertex.length];
        for (int i = 0; i < this.preVertex.length; i++) {
            Arrays.fill(this.preVertex[i], i);
        }
    }

    //List the Graph
    public void show() {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        for (int i = 0; i < this.vertex.length; i++) {
            for (int j = 0; j < this.vertex.length; j++) {
                System.out.print(vertex[this.preVertex[i][j]] + " ");
            }
            System.out.println();
            for (int j = 0; j < this.vertex.length; j++) {
                System.out.print("(The shortest distance from " + this.vertex[i] + " to " + this.vertex[j] + " is " + this.matrix[i][j] + ")\t");
            }
            System.out.println();
        }
    }

    //Define Floyd method
    public void floyd() {
        int len = 0;
        for (int k = 0; k < this.vertex.length; k++) {
            for (int i = 0; i < this.vertex.length; i++) {
                for (int j = 0; j < this.vertex.length; j++) {
                    len = this.matrix[i][k] + this.matrix[k][j];
                    if (len < this.matrix[i][j]) {
                        this.matrix[i][j] = len;
                        this.preVertex[i][j] = this.preVertex[k][j];
                    }
                }
            }
        }
    }
}
