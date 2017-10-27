import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    @Test
    public void getPayload() throws Exception {
        Node n0 = new Node(1, 5);
        int value = n0.getPayload();
        assertEquals(5, value);
    }

    @Test
    public void getPriority() throws Exception {
        Node n0 = new Node(1, 5);
        int pri = n0.getPriority();
        assertEquals(1, pri);
    }

}