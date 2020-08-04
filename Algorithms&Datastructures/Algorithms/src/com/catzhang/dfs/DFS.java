package com.catzhang.dfs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: crazycatzhang
 * @date: 2020/8/4 3:39 PM
 * @description: Simple implementation of DFS
 */
public class DFS {
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

        graph.dfs();
        System.out.println();
        graph.dfs();
    }
}

//Define Graph
class Graph {
    public ArrayList<String> vertexList;
    public int[][] edges;
    public int numOfEdges;
    public boolean[] isVisited;

    public Graph(int n) {
        this.edges = new int[n][n];
        this.vertexList = new ArrayList<>(n);
        this.numOfEdges = 0;
        this.isVisited = new boolean[n];
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

    //Get the value of index
    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }

    //Get the tie node of the current node
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //Get the next neck joint of the previous neck joint
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //Define the method of DFS
    public void dfs(boolean[] isVisited, int index) {
        if (!isVisited[index]) {
            System.out.print(getValueByIndex(index) + "->");
            isVisited[index] = true;
        }
        int neighborNode = getFirstNeighbor(index);
        while (neighborNode != -1) {
            if (!isVisited[neighborNode]) {
                dfs(isVisited, neighborNode);
            }
            neighborNode = getNextNeighbor(index, neighborNode);
        }
    }

    //Reload DFS
    public void dfs() {
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
        for (int i = 0; i < vertexList.size(); i++) {
            isVisited[i] = false;
        }
    }
}
