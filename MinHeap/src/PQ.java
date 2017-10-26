import java.util.ArrayList;

public class PQ extends AbstractHeap {
    private String message = "in PQ subclass";
    protected ArrayList<Node> heapArr = new ArrayList<Node>();
    protected ArrayList<Node> sortedArr = new ArrayList<Node>();

    /**
     * setDefaultArrayList() method
     * - Needs to instantiate ten Nodes with value, priority and position (key)
     *      then add each Node to its proper position in the ArrayList.
     * - (Not sure if I actually need the key field or not.)
     */
    public void setDefaultArrayList() {
        Node n0 = new Node(1, 5, 0);
        Node n1 = new Node(2, 3, 1);
        Node n2 = new Node(3, 7, 2);
        Node n3 = new Node(4, 1, 3);
        Node n4 = new Node(5, 2, 4);
        Node n5 = new Node(1, 4, 5);
        Node n6 = new Node(2, 9, 6);
        Node n7 = new Node(3, 8, 7);
        Node n8 = new Node(1, 6, 8);
        Node n9 = new Node(2, 10, 9);
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
        System.out.println("sift - endPos: " + endPos);
        printNodeArray();

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
                System.out.println("recursive call (pri)");
                // recursive call.
                sift(childPos);
            } else if (childPri == parentPri) {
                if (childVal < parentVal) {
                    changeKey(parentPos, childPos);
                    childPos = parentPos;
                    // TODO:  remove this output.
                    System.out.println("recursive call (val)");
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


    public void printNodeArray() {
        System.out.println("nX: K V P (Nodes in PQ object heapArr: Key - Value - Priority)");
        for (int i = 0; i <= 9; i++) {
            Node iNode = heapArr.get(i);
            int iNodeVal = iNode.getPayload();
            int iNodePri = iNode.getPriority();
            System.out.println("n" + i + ": " + i + " " + iNodeVal + " " + iNodePri);
        }
    }
}
