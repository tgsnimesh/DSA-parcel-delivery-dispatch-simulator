public class VehicleManager {
    private Vehicle[] vehicles;
    private int count;

    public VehicleManager(int maxVehicles) {
        vehicles = new Vehicle[maxVehicles];
        count = 0;
    }

    public void addVehicle(Vehicle v) {
        vehicles[count++] = v;
    }

    public Vehicle findNearestAvailable(int zone, int[] distances) {

        Vehicle nearest = null;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < count; i++) {
            Vehicle v = vehicles[i];
            if (v.isAvailable && distances[v.currentZone] < minDistance) {
                minDistance = distances[v.currentZone];
                nearest = v;
            }
        }

        return nearest;
    }
}
