import api.iHeapTDA;
import imp.MaxHeap;
import imp.MinHeap;

public class Main {


    public static void main(String[] args) {

        iHeapTDA minHeap = new MinHeap(10);
        minHeap.agregar(5);
        minHeap.agregar(3);
        minHeap.agregar(17);
        minHeap.agregar(10);
        minHeap.agregar(84);
        minHeap.agregar(19);
        minHeap.agregar(6);
        minHeap.agregar(9);
        minHeap.agregar(22);

        minHeap.print();

        iHeapTDA maxHeap = new MaxHeap(10);
        maxHeap.agregar(5);
        maxHeap.agregar(3);
        maxHeap.agregar(17);
        maxHeap.agregar(10);
        maxHeap.agregar(84);
        maxHeap.agregar(19);
        maxHeap.agregar(6);
        maxHeap.agregar(9);
        maxHeap.agregar(22);

        maxHeap.print();
    }
}