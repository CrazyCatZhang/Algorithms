package com.catzhang.dijkstra;

import java.util.Arrays;

/**
 * @author: crazycatzhang
 * @date: 2020/8/7 6:52 PM
 * @description: Solve the shortest path by dijkstra algorithm
 */
public class Dijkstra {
    private static final int N = 65535;

    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};

        Graph graph = new Graph(vertex, matrix);
        graph.dijkstra(6);
    }
}

//Creat Graph
class Graph {
    public char[] vertex;
    public int[][] matrix;
    VisitedVertex visitedVertex;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    //List the graph
    public void list() {
        for (int[] arr :
                matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    //Define Dijkstra method
    public void dijkstra(int index) {
        this.visitedVertex = new VisitedVertex(this.vertex.length, index);
        updateVertex(index);
        for (int i = 1; i < this.vertex.length; i++) {
            updateVertex(this.visitedVertex.getNextVertex());
        }
        System.out.println(this.visitedVertex);
    }

    //Update the information of vertex
    public void updateVertex(int index) {
        int len = 0;
        for (int i = 0; i < this.matrix[index].length; i++) {
            len = this.visitedVertex.distance[index] + this.matrix[index][i];
            if (this.visitedVertex.alreadyVisitedVertex[i] == 0 && len < this.visitedVertex.getDistance(i)) {
                this.visitedVertex.updatePreVertex(i, index);
                this.visitedVertex.updateDistance(i, len);
            }
        }
    }
}

//Creat VisitedVertex
class VisitedVertex {
    public int[] alreadyVisitedVertex;
    public int[] preVertex;
    public int[] distance;

    public VisitedVertex(int length, int index) {
        this.alreadyVisitedVertex = new int[length];
        this.distance = new int[length];
        this.preVertex = new int[length];
        this.alreadyVisitedVertex[index] = 1;
        for (int i = 0; i < this.distance.length; i++) {
            this.distance[i] = 65535;
        }
        this.distance[index] = 0;
    }

    //Update vertex's Distance
    public void updateDistance(int index, int length) {
        this.distance[index] = length;
    }

    //Update vertex's preVertex
    public void updatePreVertex(int pre, int index) {
        this.preVertex[pre] = index;
    }

    //Get the distance from the starting point to the current vertex
    public int getDistance(int index) {
        return this.distance[index];
    }

    //Get the next unvisited vertex
    public int getNextVertex() {
        int min = 65535, index = 0;
        for (int i = 0; i < this.alreadyVisitedVertex.length; i++) {
            if (this.alreadyVisitedVertex[i] == 0 && this.distance[i] < min) {
                min = this.distance[i];
                index = i;
            }
        }
        this.alreadyVisitedVertex[index] = 1;
        return index;
    }

    @Override
    public String toString() {
        return "VisitedVertex{" +
                "alreadyVisitedVertex=" + Arrays.toString(alreadyVisitedVertex) +
                ", preVertex=" + Arrays.toString(preVertex) +
                ", distance=" + Arrays.toString(distance) +
                '}';
    }
}