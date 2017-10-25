import java.io.Serializable;
import java.util.ArrayList;
import java.io.Serializable;

public class MinHeap extends AbstractHeap implements Serializable {
    private String message = "testMessage from MinHeap subclass";

    public void setDefaultArrayList() {
        heapArr.add(5);
        heapArr.add(3);
        heapArr.add(7);
        heapArr.add(1);
        heapArr.add(2);
        heapArr.add(4);
        heapArr.add(9);
        heapArr.add(8);
        heapArr.add(6);
        heapArr.add(10);
        arrSize = heapArr.size();
        arrMaxPos = (arrSize-1);
        message = "\nName:  Jan Dwyer\n";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String msg) {
        message = msg;
    }

    /**
     * sift() method
     * - does a partial, recursive sort from any position in the ArrayList.
     * - for MinHeap, no child may have a lower value than its parent.
     * - Forgot to remove method body from abstract class version, but
     *      this local version will overwrite it.
     * @param endPos
     */
    public void sift(int endPos) {
        // TODO:  remove this output.
        // System.out.println("sift - endPos: " + endPos + " heapArr: " + heapArr + "\n");
        int childPos = endPos;
        while (childPos > stopPosition) {
            int parentPos = parent(childPos);
            if (heapArr.get(childPos) < heapArr.get(parentPos)) {
                swap(parentPos, childPos);
                childPos = parentPos;
                // TODO:  remove this output.
                // System.out.println("recursive call");
                // recursive call.
                sift(childPos);
            } else {
                childPos = parentPos;
                // no swap needed.
            }
        }
    }
}   // end MinHeap class.

