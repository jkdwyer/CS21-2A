import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * MakeMinHeap class
 * - contains main method.
 * @author Jan Dwyer
 * @version 1.0     10/24/2017.
 */
public class MakeMinHeap {
    public static void main(String args[]) {
        // instantiate and print a PQ object.
        System.out.println("\nPriority Queue\n");
        PQ pq1 = new PQ();
        pq1.setDefaultArrayList();
        System.out.println("pq1 initial ArrayList:");
        pq1.printNodeArray();
        // test sift.
        // pq1.sift(5);
        // pq1.printNodeArray();

        pq1.buildHeap();
        System.out.println("pq1 after buildHeap():");
        pq1.printNodeArray();

        // test heapAddNewNode()
        Node n10 = new Node(2, 1);
        try {
            pq1.heapAddNewNode(n10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        pq1.printNodeArray();
        System.out.println("pq1 after heapAddNewNode():");
/*
        try {
            pq1.heapSort();
        } catch (IndexOutOfBoundsException ioobe) {
            ioobe.printStackTrace();
            System.out.println(ioobe.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("pq1 after heapSort():");
        pq1.printSortedNodeArray();

        System.out.println("\nMinimum Heap\n");
        // 0 - Create initial array.
        int top;
        MinHeap mH1 = new MinHeap();
        mH1.setDefaultArrayList();

        // 0 - a - Print initial ArrayList (for me.)
        MinHelper.printHeapArray(mH1.getHeapArr().toString());
        System.out.println("Serialize\n");
        // 0 - b - Serialize and deserialize the initial ArrayList.
        ArrayList<Integer> serArray = MinHelper.serializeArrayList();
        // 0 - c - Print the serArray (for me.)
        System.out.println("serArray: " + serArray);

        // 1 - Create the Integer Priority Queue from the initial ArrayList.
        // 1 - a - Print the PQ (see the top section of output above.)

        System.out.println("\nAssignment 2 Output:");
        // 2 - Print your name.
        System.out.println(mH1.getMessage());
        mH1.buildHeap();
        // 3 - Print the built heap.
        MinHelper.printHeapArray(mH1.getHeapArr().toString());
        // 4 - extractmin
        try {
            top = mH1.extractTop();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // 5 - extractmin
        try {
            top = mH1.extractTop();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // 6 - print the heap again.
        MinHelper.printHeapArray(mH1.getHeapArr().toString());
        // 7 - Add new value to heap.
        try {
            mH1.heapAddNewValue(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // 8 - print the data again.
        MinHelper.printHeapArray(mH1.getHeapArr().toString());
        // 9 - Call heapsort.
        try {
            mH1.heapSort();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // 10 - print the data again.
        MinHelper.printSortedArray(mH1.getSortedArr().toString());
*/
    }
}
