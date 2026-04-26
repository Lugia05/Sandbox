package org.csu.cpsc.graph;
//package org.csu.cpsc.graph;

import java.util.*;

public class WeightedGraph<E> {
    private Map<E, Map<E, Integer>> adjList;

    public WeightedGraph(){
        adjList = new HashMap<E, Map<E, Integer>>();
    }

    public void addVertex(E vertex){
        adjList.putIfAbsent(vertex, new HashMap<E, Integer>());
    }

    public void addEdge(E vertexSource, E vertexDestination,int weight){
        //Step 1: Add the vertices
        if(! adjList.containsKey(vertexSource)){
            addVertex(vertexSource);
        }

        if(! adjList.containsKey(vertexDestination)){
            addVertex(vertexDestination);
        }
        // K: vertex | V: Map of vertex -> weight
        //Step 2: Add the edge
        adjList.get(vertexSource).put(vertexDestination, weight);
    }

    public boolean hasVertex(E vertex){
        return adjList.containsKey(vertex);
    }

    public boolean hasEdge(E vertexSource, E vertexDestination){
        if(adjList.containsKey(vertexSource)){
            //Map: K: vertex | V: Map of neighbors->weights
            return adjList.get(vertexSource).containsKey(vertexDestination);
        } else {
            return false;
        }
    }

    public String getNeighbors(E vertex){
        // Return a string for the vertex, it's neighbors and weights
        // Example
        // A: 12
        // D: 5

        return "";
    }

    public List<E> bfs(E vertexSource){
        Queue<E> queue = new LinkedList<E>();
        List<E> visited = new ArrayList<E>();

        queue.add(vertexSource);
        visited.add(vertexSource);

        while(! queue.isEmpty()){
            E currentVertex = queue.poll();

            for(E neighbor: adjList.get(currentVertex).keySet()){
                if(! visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return visited;
    }

    public List<E> dfs(E vertexSource){
        Stack<E> stack = new Stack<E>();
        List<E> visited = new ArrayList<E>();

        stack.push(vertexSource);

        while(! stack.isEmpty()){
            E currentVertex = stack.pop();

            if(! visited.contains(currentVertex)){
                visited.add(currentVertex);

                for(E neighbor: adjList.get(currentVertex).keySet()){
                    stack.push(neighbor);
                }
            }
        }

        return visited;
    }

    class Edge {
    E destination;
    int weight;
    }

    public boolean hasPath(E sourceVertex){
        Queue<E> queue = new LinkedList<E>();
        List<E> visited = new ArrayList<E>();

        queue.add(sourceVertex);
        visited.add(sourceVertex);

        while(! queue.isEmpty()){
            E currentVertex = queue.poll();

            for(E neighbor: adjList.get(currentVertex).keySet()){
                if(! visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return true;
    }

    public String shortestPath(E sourceVertex, E destinationVertex){
        // Djikstra's Algorithm

        PriorityQueue<VertexObject> pq = new PriorityQueue<>();
        Map<E, Integer> distances = new HashMap<>();
        Map<E, E> previous = new HashMap<>();
        

        // Initialize distances
        for (E vertex : adjList.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }

        distances.put(sourceVertex, 0);
        pq.add(new VertexObject(sourceVertex, 0));

        while (!pq.isEmpty()) {
            VertexObject current = pq.poll();
            E currentVertex = current.vertex;

            if (currentVertex.equals(destinationVertex)) {
                break;
            }

            Map<E, Integer> neighbors = adjList.get(currentVertex);

            if (neighbors != null) {
                for (Map.Entry<E, Integer> entry : neighbors.entrySet()) {

                    E neighbor = entry.getKey();
                    int weight = entry.getValue();

                    int newDistance = distances.get(currentVertex) + weight;

                    if (newDistance < distances.get(neighbor)) {
                        distances.put(neighbor, newDistance);
                        previous.put(neighbor, currentVertex);
                        pq.add(new VertexObject(neighbor, newDistance));
                    }
                }
            }
        }

        // No path check
        if (distances.get(destinationVertex) == Integer.MAX_VALUE) {
            return "No path found";
        }

        // Reconstruct path
        List<E> path = new ArrayList<>();
        E current = destinationVertex;

        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }

        Collections.reverse(path);

        // Build result string
        String result = "";
        for (E vertex : path) {
            result += vertex + "(" + distances.get(vertex) + ") ";
        }

        return result;
    }

        


private class VertexObject implements Comparable<VertexObject> {
    E vertex;
    int distance;

    public VertexObject(E vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    @Override
    public int compareTo(VertexObject other) {
        return this.distance - other.distance;
    }

    @Override
    public String toString() {
        return vertex + "(" + distance + ")";
    }
}

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
