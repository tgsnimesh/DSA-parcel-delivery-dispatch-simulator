public class VehicleManager {
    private Vehicle[] vehicles;
    private int count;
    private Graph graph; // Add reference to Graph

    public VehicleManager(int maxVehicles, Graph g) {
        vehicles = new Vehicle[maxVehicles];
        count = 0;
        this.graph = g;
    }

    public void addVehicle(Vehicle v) {
        vehicles[count++] = v;
    }

    public Vehicle findNearestAvailable(int destinationZone, int deliveryDeadline) {
        Vehicle best = null;
        int minTravelTime = Integer.MAX_VALUE;

        for (int i = 0; i < count; i++) {
            Vehicle v = vehicles[i];
            if (!v.isAvailable) continue;

            // Run Dijkstra from this vehicle's location
            int[] distances = graph.dijkstra(v.currentZone);
            int travelTime = distances[destinationZone];

            // Check if reachable and better than current best
            if (travelTime < minTravelTime && travelTime <= deliveryDeadline) {
                minTravelTime = travelTime;
                best = v;
            }
        }

        return best;
    }
}
