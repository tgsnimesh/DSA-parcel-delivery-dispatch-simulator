public class Vehicle {
    public int vehicleID;
    public int currentZone;
    public int capacity;
    public boolean isAvailable;

    public Vehicle(int id, int zone, int cap) {

        vehicleID = id;
        currentZone = zone;
        capacity = cap;
        isAvailable = true;
    }
}

