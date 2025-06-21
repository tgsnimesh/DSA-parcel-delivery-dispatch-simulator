public class Graph {
    private Node[] nodes;

    public Graph(int size) {

        nodes = new Node[size];

        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    public void addEdge(int from, int to, int weight) {

        Edge edge = new Edge(to, weight);
        edge.next = nodes[from].head;
        nodes[from].head = edge;
    }

    private int findMin(int[] dist, boolean[] visited) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < dist.length; i++) {

            if (!visited[i] && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        }

        return minIndex;
    }


}
