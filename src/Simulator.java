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
            Vehicle v = vehicleManager.findNearestAvailable(parcel.destinationZone, parcel.deadline - parcel.orderTime);

//            for(int x = 0; x < dist.length; x++)
//                System.out.println(dist[x]);

            if (v != null) {
                System.out.println("-----------------------------------------------------------");
                System.out.println("Assigned Parcel  - " + parcel.parcelID);
                System.out.println("Assigned Vehicle - " + v.vehicleID);
                System.out.println("From Zone   - " + v.currentZone);
                System.out.println("To Zone     - " + parcel.destinationZone);
                System.out.println("Dead Line   - " + (parcel.deadline - parcel.orderTime) + " min");
                System.out.println("-----------------------------------------------------------\n");

                v.isAvailable = false;
                v.currentZone = parcel.destinationZone;

                // simulate delivery completion
                // v.isAvailable = true; // only for test simulation
            } else {

                System.out.println("-----------------------------------------------------------");
                System.out.println("No vehicle available for Parcel " + parcel.parcelID);
                System.out.println("-----------------------------------------------------------\n");
            }
        }
    }
}
