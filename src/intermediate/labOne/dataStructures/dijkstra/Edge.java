package intermediate.labOne.dataStructures.dijkstra;

public class Edge {

    private int weight;

    private Vertex endpointOne, endpointTwo;

    private  int position;

    public Edge(int weight, Vertex endpointOne, Vertex endpointTwo) {
        this.weight = weight;
        this.endpointOne = endpointOne;
        this.endpointTwo = endpointTwo;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int data) {
        this.weight = data;
    }

    public Vertex getEndpointOne() {
        return endpointOne;
    }


    public Vertex getEndpointTwo() {
        return endpointTwo;
    }



    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
