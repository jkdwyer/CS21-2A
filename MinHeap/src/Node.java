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
    private int key;

    public Node() {
    }

    public Node(int pri, int value, int pos) {
        payload = value;
        priority = pri;
        key = pos;
    }

    public void setKey(int pos) {
        key = pos;
    }

    public int getKey() {
        return key;
    }

    public int getPayload() {
        return payload;
    }

    public int getPriority() {
        return priority;
    }
}
