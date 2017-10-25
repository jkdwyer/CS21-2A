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
        /*
        MinHeap mH2 = new MinHeap();
        mH2.setDefaultArrayList();
        mH2.heapify(4);
        MinHelper.printHeapArray(mH2.getHeapArr().toString());
        try {
            mH2.heapInsert(7);
        } catch (Exception e) {
            e.getMessage();
        }
        MinHelper.printHeapArray(mH2.getHeapArr().toString());

        MinHeap mH3 = new MinHeap();
        mH3.setDefaultArrayList();
        mH3.buildHeap();
        try {
            mH3.heapSort();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        MinHelper.printSortedArray(mH3.getSortedArr().toString());
        */

        // 0 - Create initial array.
        int top;
        MinHeap mH1 = new MinHeap();
        mH1.setDefaultArrayList();

        // 0 - a - Print initial ArrayList (for me.)
        MinHelper.printHeapArray(mH1.getHeapArr().toString());
        // 0 - b - Serialize and deserialize the initial ArrayList.
        ArrayList<Integer> serArray = MinHelper.serializeArrayList();
        // 0 - c - Print the serArray (for me.)
        System.out.println("serArray: " + serArray);

        // 1 - Create the Integer Priority Queue from the initial ArrayList.
        // 1 - a - Print the PQ (for me.)

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
    }
}
