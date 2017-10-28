import java.util.ArrayList;

public class PQ extends AbstractHeap {
    private String message = "in PQ subclass";
    protected ArrayList<Node> heapArr = new ArrayList<Node>();
    protected ArrayList<Node> sortedArr = new ArrayList<Node>();
    int sortedArrSize = 0;
    int sortedArrMaxPos = 0;


    public String getMessage() {
        return message;
    }

    public void setMessage(String msg) {
        message = msg;
    }

    public int getSortedArrSize() {
        return sortedArrSize;
    }

    public int getSortedArrMaxPos() {
        return sortedArrMaxPos;
    }

    public ArrayList<Node> getHeapNodeArr() {
        return heapArr;
    }

    public ArrayList<Node> getSortedNodeArr() {
        return sortedArr;
    }

    public Node getNodeAtPos(int index) {
        return heapArr.get(index);
    }

    public Node getSortedNodeAtPos(int index) {
        return sortedArr.get(index);
    }


    /**
     * setDefaultArrayList() method
     * - Needs to instantiate ten Nodes with value, priority and position (key)
     *      then add each Node to its proper position in the ArrayList.
     * - (Not sure if I actually need the key field or not.)
     */
    public void setDefaultArrayList() {
        Node n0 = new Node(1, 5);
        Node n1 = new Node(2, 3);
        Node n2 = new Node(3, 7);
        Node n3 = new Node(4, 1);
        Node n4 = new Node(5, 2);
        Node n5 = new Node(1, 4);
        Node n6 = new Node(2, 9);
        Node n7 = new Node(3, 8);
        Node n8 = new Node(1, 6);
        Node n9 = new Node(2, 10);
        heapArr.add(n0);
        heapArr.add(n1);
        heapArr.add(n2);
        heapArr.add(n3);
        heapArr.add(n4);
        heapArr.add(n5);
        heapArr.add(n6);
        heapArr.add(n7);
        heapArr.add(n8);
        heapArr.add(n9);
        arrSize = heapArr.size();
        arrMaxPos = (arrSize-1);
    }


    /**
     * siftNode() method
     * - does a partial, recursive sort from any position in the ArrayList.
     * - for MinHeap, no child may have a lower value than its parent.
     * - Forgot to remove method body from abstract class version, but
     *      this local version will overwrite it.
     * @param endPos
     */
    public void sift(int endPos) {
        // TODO:  remove this output.
        // System.out.println("sift - endPos: " + endPos);
        // printNodeArray();

        int childPos = endPos;
        while (childPos > stopPosition) {
            int parentPos = parent(childPos);
            Node parentNode = heapArr.get(parentPos);
            Node childNode = heapArr.get(childPos);
            int parentPri = parentNode.getPriority();
            int childPri = childNode.getPriority();
            int parentVal = parentNode.getPayload();
            int childVal = childNode.getPayload();

            if (childPri < parentPri) {
                changeKey(parentPos, childPos);
                childPos = parentPos;
                // TODO:  remove this output.
                // System.out.println("recursive call (pri)");
                // recursive call.
                sift(childPos);
            } else if (childPri == parentPri) {
                if (childVal < parentVal) {
                    changeKey(parentPos, childPos);
                    childPos = parentPos;
                    // TODO:  remove this output.
                    // System.out.println("recursive call (val)");
                    // recursive call.
                    sift(childPos);
                } else {
                    childPos = parentPos;
                    // no swap needed.
                }
            } else {
                childPos = parentPos;
                // no swap needed.
            }
        }
    }


    /**
     * changeKey() method
     * - This is equivalent to swap() but must call Node.setKey()
     *     Exchanges value in pos1 with value in pos2 of ArrayList.
     * @param parentPos1
     * @param childPos2
     */
    public void changeKey(int parentPos1, int childPos2) {
        Node parentNode = heapArr.get(parentPos1);
        Node childNode = heapArr.get(childPos2);
        heapArr.set(parentPos1, childNode);
        heapArr.set(childPos2, parentNode);
    }


    /**
     * extractTopNode() method
     * - Needs to use an ArrayList<Node> for PQ.
     * - Local method overwrite of inherited vsn only works
     *      with same signature, so this needs a new name.
     * @return
     * @throws Exception
     */
    public Node extractTopNode() throws Exception {
        if (isHeap) {
            Node top = heapArr.get(0);
            heapArr.remove(0);
            // reset size and max position, then re-build the heap.
            arrSize = heapArr.size();
            arrMaxPos = (arrSize-1);
            buildHeap();
            return top;
        } else {
            throw new Exception("Error: extractTopNode() can only be used on a completed heap.");
        }
    }


    /**
     * heapSort() method
     * - For PQ objects this method must call extractTopNode.
     * @throws Exception
     */
    public void heapSort() throws Exception {
        if (isHeap) {
            int maxPos = arrMaxPos;
            for (int i = 0; i <= maxPos; i++) {
                Node topVal = extractTopNode();
                sortedArr.add(i, topVal);
                sortedArrSize = sortedArr.size();
                sortedArrMaxPos = (sortedArrSize-1);
            }
            isSorted = true;
        } else {
            throw new Exception("Error: heapSort() can only be used on a completed heap.");
        }
    }


    /**
     * heapAddNewNode() method
     * - change in signature requires a change in name.
     * @param newNode
     * @throws Exception
     */
    public void heapAddNewNode(Node newNode) throws Exception {
        if (isHeap) {
            heapArr.add(newNode);
            arrSize = heapArr.size();
            arrMaxPos = (arrSize-1);
            buildHeap();
        } else {
            throw new Exception("Error: heapAddNewNode() can only be used on a completed heap.");
        }
    }


    public void printNodeArray() {
        System.out.println("nX: K V P (Nodes in PQ object heapNodeArr: Key - Value - Priority)");
        for (int i = 0; i <= arrMaxPos; i++) {
            Node iNode = heapArr.get(i);
            int iNodeVal = iNode.getPayload();
            int iNodePri = iNode.getPriority();
            System.out.print("n" + i + ": " + i + " " + iNodeVal + " " + iNodePri + "   ");
        }
        System.out.println();
    }

    public void printSortedNodeArray() {
        System.out.println("nX: K V P (Nodes in PQ object sortedNodeArr: Key - Value - Priority)");
        for (int i = 0; i <= sortedArrMaxPos; i++) {
            Node iNode = sortedArr.get(i);
            int iNodeVal = iNode.getPayload();
            int iNodePri = iNode.getPriority();
            System.out.print("n" + i + ": " + i + " " + iNodeVal + " " + iNodePri + "   ");
        }
        System.out.println();
    }
}
