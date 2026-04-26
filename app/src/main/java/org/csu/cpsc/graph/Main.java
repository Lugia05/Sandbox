package org.csu.cpsc.graph;

import org.csu.cpsc.graph.WeightedGraph;


public class Main {

    public static void main(String[] args){
    WeightedGraph<String> graph = new WeightedGraph<>();

    graph.addEdge("A", "D", 60);
    graph.addEdge("A", "C", 12);
    graph.addEdge("B", "A", 10);
    graph.addEdge("E", "A", 10);
    graph.addEdge("C", "D", 32);
    graph.addEdge("C", "B", 20);

    System.out.println(graph.shortestPath("A", "D"));
    }
}
