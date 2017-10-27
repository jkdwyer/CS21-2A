import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PQTest {
    @Test
    public void setDefaultArrayList() throws Exception {
        ArrayList<Node> heapArr = new ArrayList<Node>();
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
        PQ pqObject = new PQ();
        pqObject.setDefaultArrayList();
        Node node0 = pqObject.getNodeAtPos(0);
        Node node1 = pqObject.getNodeAtPos(1);
        Node node2 = pqObject.getNodeAtPos(2);
        Node node3 = pqObject.getNodeAtPos(3);
        Node node4 = pqObject.getNodeAtPos(4);
        Node node5 = pqObject.getNodeAtPos(5);
        Node node6 = pqObject.getNodeAtPos(6);
        Node node7 = pqObject.getNodeAtPos(7);
        Node node8 = pqObject.getNodeAtPos(8);
        Node node9 = pqObject.getNodeAtPos(9);
        // there are no duplicate payload values in default set.
        assertEquals(n0.getPayload(), node0.getPayload());
        assertEquals(n1.getPayload(), node1.getPayload());
        assertEquals(n2.getPayload(), node2.getPayload());
        assertEquals(n3.getPayload(), node3.getPayload());
        assertEquals(n4.getPayload(), node4.getPayload());
        assertEquals(n5.getPayload(), node5.getPayload());
        assertEquals(n6.getPayload(), node6.getPayload());
        assertEquals(n7.getPayload(), node7.getPayload());
        assertEquals(n8.getPayload(), node8.getPayload());
        assertEquals(n9.getPayload(), node9.getPayload());
    }

    @Test
    public void getMessage() throws Exception {
        String message = "in PQ subclass";
        PQ pqObject = new PQ();
        assertEquals(message, pqObject.getMessage());
    }

    @Test
    public void setMessage() throws Exception {
        String message = "testing PQ subclass";
        PQ pqObject = new PQ();
        pqObject.setMessage(message);
        assertEquals(message, pqObject.getMessage());
    }

    @Test
    public void getSortedArrSize() throws Exception {
        PQ pqObject = new PQ();
        pqObject.setDefaultArrayList();
        assertEquals(0, pqObject.getSortedArrSize());
        pqObject.buildHeap();
        pqObject.heapSort();
        assertEquals(10, pqObject.getSortedArrSize());
    }

    @Test
    public void getSortedArrMaxPos() throws Exception {
        PQ pqObject = new PQ();
        pqObject.setDefaultArrayList();
        pqObject.buildHeap();
        pqObject.heapSort();
        assertEquals(9, pqObject.getSortedArrMaxPos());
    }

    @Test
    public void getNodeAtPos() throws Exception {
        PQ pqObject = new PQ();
        pqObject.setDefaultArrayList();
        Node n5 = pqObject.getNodeAtPos(5);
        pqObject.buildHeap();
        pqObject.heapSort();
        Node node = pqObject.getSortedNodeAtPos(0);
        assertEquals(n5, node);
    }

    @Test
    public void getSortedNodeAtPos() throws Exception {
        PQ pqObject = new PQ();
        pqObject.setDefaultArrayList();
        Node n5 = pqObject.getNodeAtPos(5);
        pqObject.buildHeap();
        pqObject.heapSort();
        Node node = pqObject.getSortedNodeAtPos(0);
        assertEquals(n5, node);
    }

    @Test
    public void sift() throws Exception {
        PQ pqObject = new PQ();
        pqObject.setDefaultArrayList();
        Node n0 = pqObject.getNodeAtPos(0);
        Node n1 = pqObject.getNodeAtPos(1);
        Node n2 = pqObject.getNodeAtPos(2);
        Node n3 = pqObject.getNodeAtPos(3);
        Node n4 = pqObject.getNodeAtPos(4);
        Node n5 = pqObject.getNodeAtPos(5);
        Node n6 = pqObject.getNodeAtPos(6);
        Node n7 = pqObject.getNodeAtPos(7);
        Node n8 = pqObject.getNodeAtPos(8);
        Node n9 = pqObject.getNodeAtPos(9);
        pqObject.sift(5);
        Node node;
        node = pqObject.getNodeAtPos(0);
        assertEquals(n5, node);
        node = pqObject.getNodeAtPos(1);
        assertEquals(n1, node);
        node = pqObject.getNodeAtPos(2);
        assertEquals(n0, node);
        node = pqObject.getNodeAtPos(3);
        assertEquals(n3, node);
        node = pqObject.getNodeAtPos(4);
        assertEquals(n4, node);
        node = pqObject.getNodeAtPos(5);
        assertEquals(n2, node);
        node = pqObject.getNodeAtPos(6);
        assertEquals(n6, node);
        node = pqObject.getNodeAtPos(7);
        assertEquals(n7, node);
        node = pqObject.getNodeAtPos(8);
        assertEquals(n8, node);
        node = pqObject.getNodeAtPos(9);
        assertEquals(n9, node);
    }

    @Test
    public void changeKey() throws Exception {
        PQ pqObject = new PQ();
        pqObject.setDefaultArrayList();
        Node firstPos2val = pqObject.getNodeAtPos(2);
        Node firstPos5val = pqObject.getNodeAtPos(5);
        pqObject.changeKey(5,2);
        Node nextPos2val = pqObject.getNodeAtPos(2);
        Node nextPos5val = pqObject.getNodeAtPos(5);
        assertEquals(firstPos5val, nextPos2val);
        assertEquals(firstPos2val, nextPos5val);
    }

    @Test
    public void extractTopNode() throws Exception {
        PQ pqObject = new PQ();
        pqObject.setDefaultArrayList();
        pqObject.buildHeap();
        Node n0 = pqObject.getNodeAtPos(0);
        Node top = pqObject.extractTopNode();
        assertEquals(n0, top);
    }

    @Test
    public void heapSort() throws Exception {
        PQ pqObject = new PQ();
        pqObject.setDefaultArrayList();
        Node n0 = pqObject.getNodeAtPos(0);
        Node n1 = pqObject.getNodeAtPos(1);
        Node n2 = pqObject.getNodeAtPos(2);
        Node n3 = pqObject.getNodeAtPos(3);
        Node n4 = pqObject.getNodeAtPos(4);
        Node n5 = pqObject.getNodeAtPos(5);
        Node n6 = pqObject.getNodeAtPos(6);
        Node n7 = pqObject.getNodeAtPos(7);
        Node n8 = pqObject.getNodeAtPos(8);
        Node n9 = pqObject.getNodeAtPos(9);
        // TODO:  remove this output.
        // pqObject.printNodeArray();
        pqObject.buildHeap();
        pqObject.heapSort();
        // TODO:  remove this output.
        // pqObject.printSortedNodeArray();
        Node node;
        node = pqObject.getSortedNodeAtPos(0);
        assertEquals(n5, node);
        node = pqObject.getSortedNodeAtPos(1);
        assertEquals(n0, node);
        node = pqObject.getSortedNodeAtPos(2);
        assertEquals(n8, node);
        node = pqObject.getSortedNodeAtPos(3);
        assertEquals(n1, node);
        node = pqObject.getSortedNodeAtPos(4);
        assertEquals(n6, node);
        node = pqObject.getSortedNodeAtPos(5);
        assertEquals(n9, node);
        node = pqObject.getSortedNodeAtPos(6);
        assertEquals(n2, node);
        node = pqObject.getSortedNodeAtPos(7);
        assertEquals(n7, node);
        node = pqObject.getSortedNodeAtPos(8);
        assertEquals(n3, node);
        node = pqObject.getSortedNodeAtPos(9);
        assertEquals(n4, node);
    }

}