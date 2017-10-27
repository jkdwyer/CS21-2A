/**
 * Node class.
 * - Payload and Priority do not change once initialized.
 * - Key is Node's position in the ArrayList.
 * - Key should change value as the ArrayList is sorted.
 * @author Jan Dwyer
 * @version 1.0         10/25/2017.
 */
public class Node {
    private int payload;
    private int priority;

    public Node() {
    }

    public Node(int pri, int value) {
        payload = value;
        priority = pri;
    }

    public int getPayload() {
        return payload;
    }

    public int getPriority() {
        return priority;
    }
}
