package com.catzhang.prim;

import java.util.Arrays;

/**
 * @author: crazycatzhang
 * @date: 2020/8/6 9:13 PM
 * @description: Solve road construction problems through prim algorithm
 */
public class Prim {
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] weight = new int[][]{
                {Integer.MAX_VALUE, 5, 7, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2},
                {5, Integer.MAX_VALUE, Integer.MAX_VALUE, 9, Integer.MAX_VALUE, Integer.MAX_VALUE, 3},
                {7, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 8, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 9, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 4, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 8, Integer.MAX_VALUE, Integer.MAX_VALUE, 5, 4},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 4, 5, Integer.MAX_VALUE, 6},
                {2, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, 4, 6, Integer.MAX_VALUE},};
        Graph graph = new Graph(data.length);
        graph.creatGraph(data, weight);
        MinimumTree minimumTree = new MinimumTree();
        minimumTree.prim(graph, 0);
    }
}

//Creat Minimum spanning tree
class MinimumTree {
    public void prim(Graph graph, int vertex) {
        int[] visited = new int[graph.vertex];
        visited[vertex] = 1;
        int h1 = -1;
        int h2 = -1;
        int minWeight = Integer.MAX_VALUE;
        for (int k = 1; k < graph.vertex; k++) {
            for (int i = 0; i < graph.vertex; i++) {
                for (int j = 0; j < graph.vertex; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println("The edges < " + graph.data[h1] + "," + graph.data[h2] + " > of weight is " + graph.weight[h1][h2]);
            visited[h2] = 1;
            minWeight = Integer.MAX_VALUE;
        }
    }
}

//Construct Graph
class Graph {
    public int vertex;
    public char[] data;
    public int[][] weight;

    public Graph(int vertex) {
        this.vertex = vertex;
        this.data = new char[this.vertex];
        this.weight = new int[this.vertex][this.vertex];
    }

    //Create the lead matrix of the graph
    public void creatGraph(char[] data, int[][] weight) {
        for (int i = 0; i < this.vertex; i++) {
            this.data[i] = data[i];
            for (int j = 0; j < this.vertex; j++) {
                this.weight[i][j] = weight[i][j];
            }
        }
    }

    //Through the Graph
    public void list() {
        for (int[] link :
                weight) {
            System.out.println(Arrays.toString(link));
        }
    }
}