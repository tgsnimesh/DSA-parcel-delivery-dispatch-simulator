public class ParcelMaxHeap {
    private Parcel[] heap;
    private int size;

    public ParcelMaxHeap(int capacity) {
        heap = new Parcel[capacity];
        size = 0;
    }

    public void insert(Parcel p) {
        heap[size] = p;
        int i = size;
        while (i > 0 && heap[parent(i)].getPriorityScore() < heap[i].getPriorityScore()) {
            swap(i, parent(i));
            i = parent(i);
        }
        size++;
    }

    public Parcel extractMax() {

        if (size == 0) {
            return null;
        }

        Parcel max = heap[0];
        heap[0] = heap[--size];
        heapify(0);
        return max;
    }

    private void heapify(int i) {

        int largest = i;
        int l = left(i);
        int r = right(i);

        if (l < size && heap[l].getPriorityScore() > heap[largest].getPriorityScore()) {
            largest = l;
        }
        if (r < size && heap[r].getPriorityScore() > heap[largest].getPriorityScore()) {
            largest = r;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    private void swap(int i, int j) {

        Parcel temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return 2 * i + 1; }
    private int right(int i) { return 2 * i + 2; }

    public boolean isEmpty() { return size == 0; }
}

