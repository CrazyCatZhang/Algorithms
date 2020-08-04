package com.catzhang.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: crazycatzhang
 * @date: 2020/8/4 11:24 AM
 * @description: Simple implementation of Graph
 */
public class GraphDemo {
    public static void main(String[] args) {
        int n = 5;
        String[] Vertex = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        for (String vertex :
                Vertex) {
            graph.addNode(vertex);
        }
        graph.addEdges(0, 1, 1);
        graph.addEdges(0, 2, 1);
        graph.addEdges(1, 2, 1);
        graph.addEdges(1, 3, 1);
        graph.addEdges(1, 4, 1);

        graph.list();
    }
}

//Define Graph
class Graph {
    public ArrayList<String> vertexList;
    public int[][] edges;
    public int numOfEdges;

    public Graph(int n) {
        this.edges = new int[n][n];
        this.vertexList = new ArrayList<>(n);
        this.numOfEdges = 0;
    }

    //Add Node
    public void addNode(String vertex) {
        vertexList.add(vertex);
    }

    //Add Edges
    public void addEdges(int edges1, int edges2, int weight) {
        this.edges[edges1][edges2] = weight;
        this.edges[edges2][edges1] = weight;
        this.numOfEdges++;
    }

    //Get the number of Nodes
    public int getNumOfNodes() {
        return vertexList.size();
    }

    //Get the number of Edges
    public int getNumOfEdges() {
        return this.numOfEdges;
    }

    //Through the graph
    public void list() {
        for (int[] arr :
                edges) {
            System.out.println(Arrays.toString(arr));
        }
    }
}