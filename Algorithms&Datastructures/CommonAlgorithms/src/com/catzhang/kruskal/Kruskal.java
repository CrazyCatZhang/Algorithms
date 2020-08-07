package com.catzhang.kruskal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author: crazycatzhang
 * @date: 2020/8/7 10:23 AM
 * @description: Solve the problem of road repair at bus station through Kruskal algorithm
 */
public class Kruskal {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int matrix[][] = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}};
        Graph graph = new Graph(vertex, matrix);
        kruskal(graph);
    }

    //Get the set of edges and weights
    public static ArrayList<EdgesData> getEdges(Graph graph) {
        ArrayList<EdgesData> edgesData = new ArrayList<>();
        for (int i = 0; i < graph.vertex.length; i++) {
            for (int j = i + 1; j < graph.vertex.length; j++) {
                if (graph.matrix[i][j] != Integer.MAX_VALUE) {
                    edgesData.add(new EdgesData(graph.vertex[i], graph.vertex[j], graph.matrix[i][j]));
                }
            }
        }
        return edgesData;
    }

    //Get vertex index
    public static int getPositions(Graph graph, char vertex) {
        for (int i = 0; i < graph.vertex.length; i++) {
            if (graph.vertex[i] == vertex) {
                return i;
            }
        }
        return -1;
    }

    //Get the end index of the current vertex
    public static int getEndIndex(int[] ends, int current) {
        while (ends[current] != 0) {
            current = ends[current];
        }
        return current;
    }

    //Define Kruskal method
    public static void kruskal(Graph graph) {
        int[] ends = new int[graph.vertex.length];
        ArrayList<EdgesData> resultData = new ArrayList<>();
        ArrayList<EdgesData> edges = getEdges(graph);
        Collections.sort(edges);
        for (int i = 0; i < edges.size(); i++) {
            int point1 = getPositions(graph, edges.get(i).start);
            int point2 = getPositions(graph, edges.get(i).end);
            int pointEnd1 = getEndIndex(ends, point1);
            int pointEnd2 = getEndIndex(ends, point2);
            if (pointEnd1 != pointEnd2) {
                ends[pointEnd1] = pointEnd2;
                resultData.add(edges.get(i));
            }
        }
        for (EdgesData data :
                resultData) {
            System.out.println(data);
        }
    }
}

//Creat Graph
class Graph {
    public char[] vertex;
    public int[][] matrix;
    public int edges;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                if (this.matrix[i][j] != Integer.MAX_VALUE && this.matrix[i][j] != 0) {
                    this.edges++;
                }
            }
        }
    }

    public void list() {
        for (int[] link :
                matrix) {
            System.out.println(Arrays.toString(link));
        }
    }
}

//Creat Edges
class EdgesData implements Comparable<EdgesData> {
    public char start;
    public char end;
    public int weight;

    public EdgesData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EdgesData{" +
                "<" + start +
                "," + end +
                "> = " + weight +
                '}';
    }

    @Override
    public int compareTo(EdgesData o) {
        return this.weight - o.weight;
    }
}