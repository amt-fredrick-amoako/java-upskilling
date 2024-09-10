package intermediate.labOne.dataStructures.graph;

public class TrainNetwork {
    public static void main(String[] args) {
        Graph trainNetwork = new Graph(true, true);

        Vertex laStation = trainNetwork.addVertex("Los Angeles");
        Vertex sfStation = trainNetwork.addVertex("San Francisco");
        Vertex nyStation = trainNetwork.addVertex("New York");
        Vertex atlStation = trainNetwork.addVertex("Atlanta");
        Vertex denStation = trainNetwork.addVertex("Denver");
        Vertex calStation = trainNetwork.addVertex("Calgary");

        trainNetwork.addEdge(sfStation, laStation, 400);
        trainNetwork.addEdge(laStation, sfStation, 400);
        trainNetwork.addEdge(nyStation, denStation, 1800);
        trainNetwork.addEdge(denStation, nyStation, 1800);
        trainNetwork.addEdge(calStation, denStation, 1000);
        trainNetwork.addEdge(denStation, calStation, 1000);
        trainNetwork.addEdge(laStation, atlStation, 2100);
        trainNetwork.addEdge(atlStation, laStation, 2100);

        trainNetwork.removeEdge(nyStation, denStation);
        trainNetwork.removeEdge(calStation, denStation);
        trainNetwork.removeEdge(denStation, calStation);

        trainNetwork.removeVertex(calStation);

        trainNetwork.print();
    }
}
