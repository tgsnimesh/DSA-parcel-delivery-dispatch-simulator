public class Main {
    public static void main(String[] args) {

        ParcelMaxHeap parcelHeap = new ParcelMaxHeap(10);

        parcelHeap.insert(new Parcel(101, 2, 60, 10, 5));
        parcelHeap.insert(new Parcel(102, 4, 120, 20, 3));
        parcelHeap.insert(new Parcel(103, 1, 60, 10, 5));
        parcelHeap.insert(new Parcel(104, 3, 100, 20, 5));
        parcelHeap.insert(new Parcel(105, 3, 100, 20, 1));
        parcelHeap.insert(new Parcel(106, 3, 100, 20, 4));


        Graph city = new Graph(5);
        city.addEdge(0, 1, 10);
        city.addEdge(1, 2, 15);
        city.addEdge(2, 3, 20);
        city.addEdge(3, 4, 10);
        city.addEdge(0, 4, 30);

        VehicleManager vm = new VehicleManager(4, city);
        vm.addVehicle(new Vehicle(1, 0, 2));
        vm.addVehicle(new Vehicle(2, 1, 2));
        vm.addVehicle(new Vehicle(3, 2, 2));
        vm.addVehicle(new Vehicle(4, 3, 2));

        Simulator simulator = new Simulator(parcelHeap, vm, city);
        simulator.runSimulation();
    }
}
