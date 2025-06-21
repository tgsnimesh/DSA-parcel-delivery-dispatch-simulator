public class Edge {
    public int to;
    public int weight;
    public Edge next;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
        this.next = null;
    }
}
