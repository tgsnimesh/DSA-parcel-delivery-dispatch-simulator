public class Parcel {
    public int parcelID;
    public int destinationZone;
    public int deadline; // in minutes
    public int orderTime;
    public int customerPriority; // 1 - low to 5 - high

    public Parcel(int parcelID, int destinationZone, int deadline, int orderTime, int customerPriority) {

        this.parcelID = parcelID;
        this.destinationZone = destinationZone;
        this.deadline = deadline;
        this.orderTime = orderTime;
        this.customerPriority = customerPriority;
    }

    public int getPriorityScore() {

        // customer priority calculation formula
        return (customerPriority * 1000) - (deadline - orderTime);
    }
}

