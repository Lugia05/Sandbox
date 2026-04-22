package org.csu.cpsc.graph;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Map;

public class Graph<E> {
    private Map<E, List<E>> adjList;

    public Graph(){
        adjList = new HashMap<E, List<E>>();
    }

    public void addVertex(E vertex){
        adjList.put(vertex, new LinkedList<E>());
    }

    public void addEdge(E vertexSource, E vertexDestination){
        if(! adjList.containsKey(vertexSource)){
            addVertex(vertexSource);
        }
        if(!adjList.containsKey(vertexDestination)){
            addVertex(vertexDestination);
        }
        
        adjList.get(vertexSource).add(vertexDestination);
    }

    public boolean hasVertex(E vertex){
        return adjList.containsKey(vertex);
    }

    public boolean hasEdge(E vertexSource, E vertexDestination){
        return adjList.get(vertexSource).contains(vertexDestination);
    }

    public List<E> getNeighbors(E vertex){
        return adjList.get(vertex);
    }

    public List<E> bfs(E vertexSource){
        Queue<E> queue = new LinkedList<E>();
        List<E> visited = new ArrayList<E>();

        queue.add(vertexSource);
        visited.add(vertexSource);

        while(! queue.isEmpty()){
            E currentVertex = queue.poll();

            for(E neighbor: adjList.get(currentVertex)){
                if(! visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return visited;
    }

    public List<E> dfs(E startingVertex){
        Stack<E> stack = new Stack<E>();
        List<E> visited = new ArrayList<E>();

        stack.push(startingVertex);

        while(! stack.isEmpty()){
            E currentVertex = stack.pop();

            if(!visited.contains(currentVertex)){
                visited.add(currentVertex);

                for(E neighbor: adjList.get(currentVertex)){
                    stack.push(neighbor);
                }
            }
        }
        return visited;
    }
}
