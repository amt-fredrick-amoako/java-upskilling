package intermediate.labOne.algorithms.dijkstra;

import java.util.*;

public class Graph<T> {

    private ArrayList<Vertex<T>> vertices;
    private ArrayList<Edge> edges;

    public Graph(ArrayList<Vertex<T>> vertices, ArrayList<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public Map<T, List<Edge>> getAdjList() {
        Map<T, List<Edge>> adjList = new HashMap<>();
        for (Edge e : edges) {
            adjList.computeIfAbsent((T) e.getEndpointOne().getData(), k -> new ArrayList<>()).add(e);
            adjList.computeIfAbsent((T) e.getEndpointTwo().getData(), k -> new ArrayList<>()).add(e);
        }
        return adjList;
    }

    public Map<T, Integer> dijkstra(Vertex<T> source) {
        Map<T, Integer> distances = new HashMap<>();
        PriorityQueue<Vertex<T>> queue = new PriorityQueue<>(Comparator.comparingInt(v -> distances.get(v.getData())));

        for (Vertex<T> v : vertices) {
            distances.put(v.getData(), Integer.MAX_VALUE);
            queue.add(v);
        }
        distances.put(source.getData(), 0);
        queue.remove(source);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex<T> v = queue.poll();
            int currentDistance = distances.get(v.getData());

            for (Edge e : getAdjList().get(v.getData())) {
                Vertex<T> neighbor = e.getEndpointOne().equals(v) ? e.getEndpointTwo() : e.getEndpointOne();
                int distanceThroughCurrentVertex = currentDistance + e.getWeight();
                if (distanceThroughCurrentVertex < distances.get(neighbor.getData())) {
                    distances.put(neighbor.getData(), distanceThroughCurrentVertex);

                    // Reorder the priority queue
                    queue.remove(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        Vertex<String> A = new Vertex<>("Agape High");
        Vertex<String> B = new Vertex<>("Lapaz");
        Vertex<String> C = new Vertex<>("Airport Junction");
        Vertex<String> D = new Vertex<>("Jungle Avenue");
        Vertex<String> E = new Vertex<>("Hospital");

        ArrayList<Vertex<String>> vertices = new ArrayList<>(Arrays.asList(A, B, C, D, E));
        ArrayList<Edge> edges = new ArrayList<>(Arrays.asList(
                new Edge(5, A, B),
                new Edge(10, A, D),
                new Edge(15, A, C),
                new Edge(3, B, D),
                new Edge(1, C, D),
                new Edge(2, C, B),
                new Edge(8, D, E),
                new Edge(4, B, E)
        ));

        Graph<String> graph = new Graph<>(vertices, edges);
        Map<String, Integer> distances = graph.dijkstra(A);

        for (Map.Entry<String, Integer> entry : distances.entrySet()) {
            System.out.println("Distance from Town hall to " + entry.getKey() + " is " + entry.getValue());
        }
    }
}
