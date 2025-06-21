public class Simulator {

    private ParcelMaxHeap parcelHeap;
    private VehicleManager vehicleManager;
    private Graph city;

    public Simulator(ParcelMaxHeap heap, VehicleManager vm, Graph city) {

        this.parcelHeap = heap;
        this.vehicleManager = vm;
        this.city = city;
    }

    public void runSimulation() {

        while (!parcelHeap.isEmpty()) {

            Parcel parcel = parcelHeap.extractMax();
            int[] dist = city.dijkstra(parcel.destinationZone);
            Vehicle v = vehicleManager.findNearestAvailable(parcel.destinationZone, dist);

            if (v != null) {
                System.out.println("Assigned Parcel " + parcel.parcelID + " to Vehicle " + v.vehicleID);
                v.isAvailable = false;
                v.currentZone = parcel.destinationZone;

                // simulate time passage and delivery completion
                v.isAvailable = true; // For simulation only
            } else {

                System.out.println("No vehicle available for Parcel " + parcel.parcelID);
            }
        }
    }
}
