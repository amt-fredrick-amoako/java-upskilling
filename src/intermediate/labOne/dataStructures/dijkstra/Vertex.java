package intermediate.labOne.dataStructures.dijkstra;

public class Vertex <T>{
    private T data;
    private int position;

    public T getData() {
        return data;
    }

    public Vertex(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
