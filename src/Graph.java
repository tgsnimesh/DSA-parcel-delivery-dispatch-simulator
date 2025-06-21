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

    public int[] dijkstra(int start) {

        int[] dist = new int[nodes.length];
        boolean[] visited = new boolean[nodes.length];

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;

        for (int count = 0; count < nodes.length - 1; count++) {

            int u = findMin(dist, visited);
            visited[u] = true;
            Edge edge = nodes[u].head;

            while (edge != null) {

                if (!visited[edge.to] && dist[u] + edge.weight < dist[edge.to]) {
                    dist[edge.to] = dist[u] + edge.weight;
                }

                edge = edge.next;
            }
        }

        return dist;
    }

}
